package com.guvnoh.boma.repositories

import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ProductsRepository {

    private val productsRef = FirebaseRefs.fullStock

    private var listener: ValueEventListener? = null


     // Observe products in realtime
    fun observeProducts(
        onChange: (List<Product>) -> Unit
    ) {
        listener?.let { productsRef.removeEventListener(it) }

        listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = snapshot.children.mapNotNull { child ->
                    child.getValue(Product::class.java)
                }
                onChange(products.filter { it.id!=null })
            }

            override fun onCancelled(error: DatabaseError) {
                // log if needed
            }
        }

        productsRef.addValueEventListener(listener!!)
    }


     // Add new product
    fun addProduct(product: Product) {
        val name = product.name ?: return
         product.id = productsRef.push().key
        productsRef.child(name).setValue(product)
    }


     // Update price
    fun updatePrice(productId: String, newPrice: Double) {
        productsRef
            .child(productId)
            .child("stringPrice")
            .setValue(newPrice)
        productsRef
            .child(productId)
            .child("doublePrice")
            .setValue(newPrice)
    }


     // Delete product completely
    fun deleteProduct(productId: String) {
        productsRef
            .child(productId)
            .removeValue()
    }


     // Call this when ViewModel is cleared
    fun clear() {
        listener?.let { productsRef.removeEventListener(it) }
        listener = null
    }
}
