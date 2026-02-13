package com.guvnoh.boma.uidesigns.screens.priceChange

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.PreferenceManager
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.repositories.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for handling price changes.
 *
 * Note: Push notifications are now handled server-side via Firebase Cloud Functions.
 * When a price is updated in the database, the Cloud Function automatically
 * sends notifications to all registered devices.
 */
class PriceChangeViewmodel(private val preferences: PreferenceManager? = null) : ViewModel() {

    // Product list
    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products

    // User id
    private val _userId = MutableStateFlow(preferences?.getUserId("userId") ?: "")
    val userId = _userId

    // Price change products - map of productId to new price
    private val _priceChangeProducts = MutableStateFlow<Map<String, String>>(emptyMap())
    val priceChangeProducts: StateFlow<Map<String, String>> = _priceChangeProducts

    init {
        observeProducts(FirebaseRefs.Products)
        preferences?.getUserId("userId")
    }

    private fun observeProducts(repo: DatabaseReference) {
        val repository = ProductsRepository()
        repository.observeProducts(repo) { list ->
            _products.value = list
        }
    }

    fun clearPriceChangeList() {
        _priceChangeProducts.value = emptyMap()
    }

    /**
     * Remove a single product from the price change list
     */
    fun removeFromPriceChangeList(productId: String) {
        val updated = _priceChangeProducts.value.toMutableMap()
        updated.remove(productId)
        _priceChangeProducts.value = updated
    }

    fun addToPriceChangeList(product: Products, newPrice: String) {
        val validPrice = validateEntry(newPrice)
        if (validPrice.isNotEmpty()) {
            val pricesToUpdate = _priceChangeProducts.value.toMutableMap()
            pricesToUpdate[product.id!!] = validPrice
            _priceChangeProducts.value = pricesToUpdate
        }
    }

    /**
     * Update price in Firebase.
     * The Cloud Function will automatically detect this change and
     * send push notifications to all registered devices.
     */
    private fun updatePrice(product: Products, newPrice: String) {
        val productsRepo = FirebaseRefs.Products
        val productRef = productsRepo.child(product.id ?: return)

        // Update both string and double price
        productRef.child("stringPrice").setValue(newPrice)
        productRef.child("doublePrice").setValue(newPrice.toDouble())
    }

    private fun validateEntry(newPrice: String): String {
        val parsedNewPrice = newPrice.filter { ch -> ch.isDigit() || ch == '.' }
        val parsed = parsedNewPrice.toDoubleOrNull()
        if (parsed != null && parsed > 0.0) return parsed.toString()
        return ""
    }

    fun errorCheck(newPrice: String): String? {
        val double = newPrice.toDoubleOrNull()
        return when {
            newPrice.isEmpty() -> "Empty Field"
            double == null -> "Invalid Price"
            double >= 0 -> null
            else -> "Invalid Price"
        }
    }

    fun getPendingPrice(productId: String): String {
        val map = priceChangeProducts.value
        return map[productId] ?: ""
    }

    /**
     * Update all prices in the pending list.
     * Each price update will trigger the Firebase Cloud Function,
     * which will send push notifications to all devices.
     */
    fun updatePrices(
        context: Context,
        map: Map<String, String>,
        navController: NavController
    ) {
        if (map.isEmpty()) {
            Toast.makeText(context, "No prices to update", Toast.LENGTH_SHORT).show()
            return
        }

        var updateCount = 0
        map.forEach { (productId, newPrice) ->
            val productToUpdate = products.value.find { it.id == productId }
            if (productToUpdate != null) {
                updatePrice(productToUpdate, newPrice)
                updateCount++
            }
        }

        val message = if (updateCount == 1) {
            "Price updated successfully"
        } else {
            "$updateCount prices updated successfully"
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

        // Navigate back to products screen
        navController.navigate(Screen.Products.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    /**
     * Factory for creating PriceChangeViewmodel with dependencies
     */
    class Factory(private val preferences: PreferenceManager? = null) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PriceChangeViewmodel::class.java)) {
                return PriceChangeViewmodel(preferences) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}