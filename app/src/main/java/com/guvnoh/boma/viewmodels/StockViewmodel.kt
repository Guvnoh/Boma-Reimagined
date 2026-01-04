package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.repositories.ProductsRepository
import com.guvnoh.boma.repositories.StockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@RequiresApi(Build.VERSION_CODES.O)
class StockViewModel(
) : ViewModel() {

    private val _wareHouseFulls = MutableStateFlow<Map<Product, FullsStock>>(emptyMap())
    val wareHouseStock: StateFlow<Map<Product, FullsStock>> = _wareHouseFulls

    private val _headOfficeFulls = MutableStateFlow<Map<Product, FullsStock>>(emptyMap())
    val headOfficeStock: StateFlow<Map<Product, FullsStock>> = _headOfficeFulls

        //empties stock
    private val _emptiesStock = MutableStateFlow<Map<String, EmptiesStock>>(emptyMap())
    val emptiesStock: StateFlow<Map<String, EmptiesStock>> = _emptiesStock



    private val stockRepository: StockRepository = StockRepository()

    init {
        observeFullsStock(FirebaseRefs.warehouseFulls)
        observeFullsStock(FirebaseRefs.HeadOfficeFulls)
        observeEmptiesStock()
        AppMetaViewModel().checkDailyReset {
            AppMetaViewModel().resetSoldToday(FirebaseRefs.warehouseFulls)
            AppMetaViewModel().resetSoldToday(FirebaseRefs.HeadOfficeFulls)
        }
    }

    private fun convertListToMap(list: List<Product>): Map<Product, FullsStock>{
        val map: MutableMap<Product, FullsStock> = mutableMapOf()

        list.forEach {
            val stock = it.stock?:FullsStock()
            map[it] = stock
        }
        return map
    }

    private fun observeFullsStock(repo: DatabaseReference) {
        val map: MutableMap<Product, FullsStock> = mutableMapOf()
        val products = when(repo){
            FirebaseRefs.warehouseFulls -> {
                val stockLocation = FirebaseRefs.warehouseFulls
                ProductsRepository().observeProducts(stockLocation){
                    products ->
                    _wareHouseFulls.value = convertListToMap(products)
                }
                _wareHouseFulls.value
            }
            FirebaseRefs.HeadOfficeFulls -> {
                val stockLocation = FirebaseRefs.HeadOfficeFulls
                ProductsRepository().observeProducts(stockLocation){
                        products ->
                    _headOfficeFulls.value = convertListToMap(products)
                }
                _headOfficeFulls.value
            }
            else -> {
                val stockLocation = FirebaseRefs.warehouseFulls
                ProductsRepository().observeProducts(stockLocation){
                        products ->
                    _wareHouseFulls.value = convertListToMap(products)
                }
                _wareHouseFulls.value
            }
        }
        val productStockList: List<Product> = products.keys.toList()
        stockRepository.getStockData(productStockList).forEach {
            map[it.value.first] = it.value.second
        }
        when(repo){
            FirebaseRefs.warehouseFulls -> _wareHouseFulls.value = map
            FirebaseRefs.HeadOfficeFulls -> _headOfficeFulls.value = map
        }
    }

    private fun observeEmptiesStock() {
        stockRepository.observeEmptiesStock { map ->
            _emptiesStock.value = map
        }
    }

    fun sellProduct(productId: String, quantity: Double, repo: DatabaseReference) {
        stockRepository.sellProduct(
            productId = productId,
            soldQty = quantity,
            repo = repo
        )
    }

}
