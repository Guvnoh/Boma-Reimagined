//package com.guvnoh.boma.repositories
//
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.MutableData
//import com.google.firebase.database.Transaction
//import com.google.firebase.database.ValueEventListener
//import com.guvnoh.boma.database.FirebaseRefs
//import com.guvnoh.boma.domain.DateProvider
//import com.guvnoh.boma.models.FullsStock
//import com.guvnoh.boma.models.Product
//
//
//class StockRepository {
//
//    private val stockRef = FirebaseRefs.fullStock
//
//    private var listener: ValueEventListener? = null
//
//
//
//    /**
//     * Observe products in realtime
//     */
//    fun observeProducts(
//        onChange: (Map<String, FullsStock>) -> Unit
//    ) {
//        listener?.let { stockRef.removeEventListener(it) }
//        val stockMap: MutableMap<String, FullsStock> = mutableMapOf()
//
//            listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                snapshot.children.mapNotNull { child ->
//                    val product = child.getValue(Product::class.java)
//                    if (product?.stock != null){
//                        val stock= product.stock
//                        product.name?.let {
//                            if (stock != null) {
//                                stockMap[it] = stock
//                            }
//                        }
//                    }
//                }
//                onChange(stockMap)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // log if needed
//            }
//        }
//        stockRef.addValueEventListener(listener!!)
//    }
//
//    fun updateStockTransaction(
//        productId: String,
//        soldQty: Double
//    ) {
//        val stockRef = FirebaseRefs.fullStock
//            .child(productId)
//            .child("stock")
//
//        stockRef.runTransaction(object : Transaction.Handler {
//
//            override fun doTransaction(data: MutableData): Transaction.Result {
//                val stock = data.getValue(FullsStock::class.java)
//                    ?: return Transaction.success(data)
//
//                val currentClosing = stock.closingStock ?: stock.openingStock ?: 0.0
//
//                val closing = (currentClosing - soldQty).coerceAtLeast(0.0)
//
//
//
//                stock.closingStock = closing
//                stock.soldToday = (stock.soldToday ?: 0.0) + soldQty
//                stock.soldLast = soldQty
//                stock.lastTimeSold = DateProvider.todayString()
//
//                data.value = stock
//                return Transaction.success(data)
//            }
//
//            override fun onComplete(
//                error: DatabaseError?,
//                committed: Boolean,
//                snapshot: DataSnapshot?
//            ) = Unit
//        })
//    }
//
//    fun resetSoldToday() {
//        FirebaseRefs.fullStock.get().addOnSuccessListener { snapshot ->
//            snapshot.children.forEach { productSnap ->
//                val stockRef = productSnap.child("stock").ref
//
//                stockRef.runTransaction(object : Transaction.Handler {
//                    override fun doTransaction(data: MutableData): Transaction.Result {
//                        val stock = data.getValue(FullsStock::class.java)
//                            ?: return Transaction.success(data)
//
//                        stock.openingStock = stock.closingStock ?: 0.0
//                        stock.soldToday = 0.0
//
//                        data.value = stock
//                        return Transaction.success(data)
//                    }
//
//                    override fun onComplete(
//                        error: DatabaseError?,
//                        committed: Boolean,
//                        snapshot: DataSnapshot?
//                    ) = Unit
//                })
//            }
//        }
//    }
//}


package com.guvnoh.boma.repositories

import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.FullsStock
import com.google.firebase.database.*
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.Product

class StockRepository() {

    //private val fullsRef = FirebaseRefs.fullStock
    private val wareHouseFullsRepo = FirebaseRefs.warehouseFulls
    private val headOfficeFulls = FirebaseRefs.HeadOfficeFulls
    private val emptiesRef = FirebaseRefs.empties

    private var warehouseFullsListener: ValueEventListener? = null
    private var headOfficeFullsListener: ValueEventListener? = null
    private var emptiesListener: ValueEventListener? = null

    // ------------------------------------------------
    // FULLS STOCK (OBSERVE)
    // ------------------------------------------------

    fun getStockData(products: List<Product>): MutableMap<String, Pair<Product, FullsStock>>{
        val stockMap: MutableMap<String, Pair<Product, FullsStock>> = mutableMapOf()
        products.forEach{
            if (it.name!=null && it.stock!=null){
                stockMap[it.name!!] = Pair(it, it.stock!!)
            }
        }
        return stockMap
    }

//    fun observeFullsStock(
//        repo: DatabaseReference,
//        map: MutableMap<String, Pair<Product, FullsStock>>,
//        onChange: (Map<String, FullsStock>) -> Unit,
//    ) {
//        var listener = when(repo){
//            FirebaseRefs.warehouseFulls -> warehouseFullsListener
//            FirebaseRefs.HeadOfficeFulls -> headOfficeFullsListener
//            else -> null
//        }
//        listener?.let { repo.removeEventListener(it) }
//
//        listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val result = mutableMapOf<String, FullsStock>()
//
//                snapshot.children.forEach { productSnap ->
//                    //val productId = productSnap.key ?: return@forEach
//                    val stockSnap = productSnap.child("stock")
//
//                    val stock = stockSnap.getValue(FullsStock::class.java)
//                        ?: FullsStock()
//                    result[productId] = stock
//                }
//
//                onChange(result)
//            }
//
//            override fun onCancelled(error: DatabaseError) = Unit
//        }
//
//        repo.addValueEventListener(listener)
//    }

    // ------------------------------------------------
    // EMPTIES (OBSERVE)
    // ------------------------------------------------

    fun observeEmptiesStock(
        onChange: (Map<String, EmptiesStock>) -> Unit
    ) {
        emptiesListener?.let { emptiesRef.removeEventListener(it) }

        emptiesListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val result = mutableMapOf<String, EmptiesStock>()

                snapshot.children.forEach { productSnap ->
                    val productId = productSnap.key ?: return@forEach
                    val empty = productSnap.getValue(EmptiesStock::class.java)
                        ?: EmptiesStock()

                    result[productId] = empty
                }

                onChange(result)
            }

            override fun onCancelled(error: DatabaseError) = Unit
        }

        emptiesRef.addValueEventListener(emptiesListener!!)
    }

    // ------------------------------------------------
    // SELL PRODUCT (ATOMIC & CORRECT)
    // ------------------------------------------------

    fun sellProduct(
        productId: String,
        soldQty: Double,
        repo: DatabaseReference
    ) {
        if (soldQty <= 0) return

        val stockRef = repo
            .child(productId)
            .child("stock")

        stockRef.runTransaction(object : Transaction.Handler {
            override fun doTransaction(data: MutableData): Transaction.Result {
                val stock = data.getValue(FullsStock::class.java)
                    ?: FullsStock()

                val opening = stock.openingStock ?: 0.0
                val currentClosing =
                    stock.closingStock ?: opening

                if (currentClosing < soldQty) {
                    return Transaction.abort()
                }

                stock.soldToday =
                    (stock.soldToday ?: 0.0) + soldQty

                stock.closingStock =
                    (currentClosing - soldQty).coerceAtLeast(0.0)

                data.value = stock
                return Transaction.success(data)
            }

            override fun onComplete(
                error: DatabaseError?,
                committed: Boolean,
                snapshot: DataSnapshot?
            ) = Unit
        })
    }

    // ------------------------------------------------
    // UPDATE EMPTIES
    // ------------------------------------------------

    fun updateEmpties(
        productId: String,
        delta: Double
    ) {
        val emptyRef = emptiesRef.child(productId)

        emptyRef.runTransaction(object : Transaction.Handler {
            override fun doTransaction(data: MutableData): Transaction.Result {
                val empty = data.getValue(EmptiesStock::class.java)
                    ?: EmptiesStock()

                empty.quantity =
                    ((empty.quantity ?: 0.0) + delta).coerceAtLeast(0.0)

                data.value = empty
                return Transaction.success(data)
            }

            override fun onComplete(
                error: DatabaseError?,
                committed: Boolean,
                snapshot: DataSnapshot?
            ) = Unit
        })
    }

    // ------------------------------------------------
    // DAILY RESET (CALLED BY AppMetaViewModel)
    // ------------------------------------------------


    // ------------------------------------------------
    // CLEANUP
    // ------------------------------------------------

    fun clear(repo: DatabaseReference) {
        warehouseFullsListener?.let { FirebaseRefs.warehouseFulls.removeEventListener(it) }
        headOfficeFullsListener?.let { FirebaseRefs.HeadOfficeFulls.removeEventListener(it) }
        emptiesListener?.let { emptiesRef.removeEventListener(it) }

        warehouseFullsListener = null
        headOfficeFullsListener = null
        emptiesListener = null
    }
}

