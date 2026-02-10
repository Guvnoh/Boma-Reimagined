package com.guvnoh.boma.uidesigns.screens.priceChange

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.MainActivity
import com.guvnoh.boma.R
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.PreferenceManager
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.repositories.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first

class PriceChangeViewmodel( val preferences: PreferenceManager): ViewModel() {

    //product list
    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products

    //user id
    private val _userId = MutableStateFlow(preferences.getUserId("userId"))
    val userId =_userId

    //price change products
    private val _priceChangeProducts = MutableStateFlow<Map<String, String>>(emptyMap())
    val priceChangeProducts: StateFlow<Map<String, String>> = _priceChangeProducts

    init {
        observeProducts(FirebaseRefs.Products)
        preferences.getUserId("userId")
    }


    private fun observeProducts(repo: DatabaseReference) {
        val repository = ProductsRepository()
        repository.observeProducts(repo) { list ->
            _products.value = list
        }
    }

    fun clearPriceChangeList(){
        _priceChangeProducts.value = emptyMap()
    }


     fun addToPriceChangeList(product: Products, newPrice: String ){
        val validPrice = validateEntry(newPrice) //ensure entry is a valid double then convert to string
        val pricesToUpdate = _priceChangeProducts.value.toMutableMap()
        pricesToUpdate[product.id!!] = validPrice
        _priceChangeProducts.value = pricesToUpdate
    }


    // Update price
    private fun updatePrice(product: Products, newPrice: String) {
        val productsRepo = FirebaseRefs.Products
        // update string and double price of product parameter
        productsRepo.child(product.id ?: "error")
            .child("stringPrice")
            .setValue(newPrice)

        productsRepo.child(product.id?:"error")
            .child("doublePrice")
            .setValue(newPrice.toDouble())

    }

    private fun validateEntry(newPrice: String): String{
        val parsedNewPrice = newPrice.filter { ch -> ch.isDigit() || ch == '.' }
        val parsed = parsedNewPrice.toDoubleOrNull()
        if (parsed != null && parsed > 0.0) return parsed.toString()
        return ""
    }

    fun errorCheck(newPrice: String): String?{
        val double = newPrice.toDoubleOrNull()
        val result = when{
            newPrice.isEmpty() -> "Empty Field"
            double == null -> "Invalid Price"
            double >= 0 -> null
            else -> "Invalid Price"
        }

        return  result
    }

//    private fun sendNotification(context: Context, content: String) {
//        val id = System.currentTimeMillis().toInt()
//        val intent = Intent(context, MainActivity::class.java)
//            .putExtra("route", Screen.PriceChange.route)
//
//        val pendingIntent = PendingIntent.getActivity(
//            context,
//            id,
//            intent,
//            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//        )
//
//        val notification = NotificationCompat.Builder(context, "default_channel")
//            .setSmallIcon(R.drawable.boma_logo)
//            .setContentTitle("Price Update!")
//            .setContentText(content)
//            .setContentIntent(pendingIntent)
//            .setAutoCancel(true)
//            .build()
//
//        if (ActivityCompat.checkSelfPermission(
//                context,
//                Manifest.permission.POST_NOTIFICATIONS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return
//        }
//
//        NotificationManagerCompat.from(context).notify(id, notification)
//    }


    fun getPendingPrice(productId: String): String{
        val pendingPrice: String
        val map = priceChangeProducts.value
        val pendingProductId = if (productId in map.keys){map.keys.first { productId == it }} else return ""
        pendingPrice = map[pendingProductId]!!
        return pendingPrice
    }

    fun updatePrices(
        context: Context,
        map: Map<String, String>,
        navController: NavController){

        map.keys.forEach { productId ->
            val productToUpdate = products.value.first { it.id == productId }
            val newPrice = map[productId]
            updatePrice(productToUpdate, newPrice!!)

//            sendNotification(
//                context = context,
//                content = "${productToUpdate.name}   ----->  ${nairaFormat(newPrice.toDouble())} "
//            )
        }
        Toast.makeText(context, "Prices updated", Toast.LENGTH_SHORT).show()

        navController.navigate(Screen.Products.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true

        }
    }
}