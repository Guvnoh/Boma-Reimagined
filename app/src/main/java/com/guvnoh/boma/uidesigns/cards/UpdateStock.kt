package com.guvnoh.boma.uidesigns.cards
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.State
//import androidx.compose.runtime.collectAsState
//import com.guvnoh.boma.database.fulls
//import com.guvnoh.boma.formatters.checkIfSoldToday
//import com.guvnoh.boma.formatters.getDate
//import com.guvnoh.boma.models.BomaViewModel
//import com.guvnoh.boma.models.SoldProduct
//
//@RequiresApi(Build.VERSION_CODES.O)
//fun updateDB(soldProduct: SoldProduct,
//             newDepletion: Double,
//             closingStock: Double,
//             newSoldToday: Double ){
//    val stockRef = fulls
//        .child(soldProduct.product?.name?:"unknown")
//        .child("stock")
//    // ✅ Now update everything together
//    stockRef.child("closingStock").setValue(closingStock)
//    stockRef.child("lastTimeSold").setValue(getDate())
//    stockRef.child("soldLast").setValue(newDepletion)
//    stockRef.child("soldToday").setValue(newSoldToday)
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//private fun updateStock(soldProducts: State<List<SoldProduct>>) {
//
//    soldProducts.value.forEach { soldProduct ->
//        var soldToday = 0.0
//        var closingStock = soldProduct.product?.stock?.closingStock?:0.0
//        val openingStock = soldProduct.product?.stock?.openingStock?:0.0
//        val receivedStock = soldProduct.product?.stock?.receivedStock?.quantity?:0.0
//        val currentStock = openingStock + receivedStock
//        val soldQty = soldProduct.doubleQuantity?:0.0
//       if ( checkIfSoldToday(soldProduct.product?.stock?.lastTimeSold?:"err")){
//           soldToday = (soldProduct.product?.stock?.soldToday?:0.0) + (soldProduct.doubleQuantity?:0.0)
//           closingStock = currentStock - soldQty
//       }
//        updateDB(
//            soldProduct = soldProduct,
//            newDepletion = soldQty,
//            closingStock = closingStock,
//            newSoldToday = soldToday
//        )
//
//    }
//}
//
