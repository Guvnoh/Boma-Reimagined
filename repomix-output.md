This file is a merged representation of the entire codebase, combined into a single document by Repomix.

# File Summary

## Purpose
This file contains a packed representation of the entire repository's contents.
It is designed to be easily consumable by AI systems for analysis, code review,
or other automated processes.

## File Format
The content is organized as follows:
1. This summary section
2. Repository information
3. Directory structure
4. Repository files (if enabled)
5. Multiple file entries, each consisting of:
  a. A header with the file path (## File: path/to/file)
  b. The full contents of the file in a code block

## Usage Guidelines
- This file should be treated as read-only. Any changes should be made to the
  original repository files, not this packed version.
- When processing this file, use the file path to distinguish
  between different files in the repository.
- Be aware that this file may contain sensitive information. Handle it with
  the same level of security as you would the original repository.

## Notes
- Some files may have been excluded based on .gitignore rules and Repomix's configuration
- Binary files are not included in this packed representation. Please refer to the Repository Structure section for a complete list of file paths, including binary files
- Files matching patterns in .gitignore are excluded
- Files matching default ignore patterns are excluded
- Files are sorted by Git change count (files with more changes are at the bottom)

# Directory Structure
```
.gitignore
app/.gitignore
app/build.gradle.kts
app/google-services.json
app/proguard-rules.pro
app/src/androidTest/java/com/guvnoh/boma/ExampleInstrumentedTest.kt
app/src/main/AndroidManifest.xml
app/src/main/ic_launcher-playstore.png
app/src/main/java/com/guvnoh/boma/database/firebaseRefs.kt
app/src/main/java/com/guvnoh/boma/dateProvider/DateProvider.kt
app/src/main/java/com/guvnoh/boma/formatters/CurrencyFormatter.kt
app/src/main/java/com/guvnoh/boma/formatters/NumberFormatter.kt
app/src/main/java/com/guvnoh/boma/formatters/TimeFormatter.kt
app/src/main/java/com/guvnoh/boma/functions/FetchRecords.kt
app/src/main/java/com/guvnoh/boma/functions/PushRecord.kt
app/src/main/java/com/guvnoh/boma/functions/Screenshot.kt
app/src/main/java/com/guvnoh/boma/functions/SendDummyData.kt
app/src/main/java/com/guvnoh/boma/functions/stockCalculator.kt
app/src/main/java/com/guvnoh/boma/functions/VibratePhone.kt
app/src/main/java/com/guvnoh/boma/MainActivity.kt
app/src/main/java/com/guvnoh/boma/models/AutoScrollingText.kt
app/src/main/java/com/guvnoh/boma/models/Empties.kt
app/src/main/java/com/guvnoh/boma/models/FullsStock.kt
app/src/main/java/com/guvnoh/boma/models/Product.kt
app/src/main/java/com/guvnoh/boma/models/Screen.kt
app/src/main/java/com/guvnoh/boma/models/SplashScreen.kt
app/src/main/java/com/guvnoh/boma/navigation/MainNavigation.kt
app/src/main/java/com/guvnoh/boma/navigation/StockPageNavigation.kt
app/src/main/java/com/guvnoh/boma/repositories/AppMetaRepository.kt
app/src/main/java/com/guvnoh/boma/repositories/ProductRepository.kt
app/src/main/java/com/guvnoh/boma/repositories/StockRepository.kt
app/src/main/java/com/guvnoh/boma/ui/theme/Color.kt
app/src/main/java/com/guvnoh/boma/ui/theme/Theme.kt
app/src/main/java/com/guvnoh/boma/ui/theme/Type.kt
app/src/main/java/com/guvnoh/boma/uidesigns/cards/EmptiesStockCard.kt
app/src/main/java/com/guvnoh/boma/uidesigns/cards/ProductCard.kt
app/src/main/java/com/guvnoh/boma/uidesigns/cards/RecordCard.kt
app/src/main/java/com/guvnoh/boma/uidesigns/cards/StockCard.kt
app/src/main/java/com/guvnoh/boma/uidesigns/cards/SwipableProductCard.kt
app/src/main/java/com/guvnoh/boma/uidesigns/cards/UpdateStock.kt
app/src/main/java/com/guvnoh/boma/uidesigns/DrawerMenu.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/AddProductPage.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/AddSupplyDetails.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/DeleteProduct.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/priceChange/PriceChangeCard.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/priceChange/PriceChangePage.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/priceChange/PriceChangeViewmodel.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/ProductsPage.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/Receipt.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/RecordDetailsScreen.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/RecordsScreen.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/stock/HeadOfficeStock.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/stock/StockEmptiesScreen.kt
app/src/main/java/com/guvnoh/boma/uidesigns/screens/stock/WarehouseStock.kt
app/src/main/java/com/guvnoh/boma/viewmodels/AppMetaViewModel.kt
app/src/main/java/com/guvnoh/boma/viewmodels/productViewModel.kt
app/src/main/java/com/guvnoh/boma/viewmodels/ReceiptViewmodel.kt
app/src/main/java/com/guvnoh/boma/viewmodels/RecordViewModel.kt
app/src/main/java/com/guvnoh/boma/viewmodels/StockViewmodel.kt
app/src/main/res/drawable/amstel.jpg
app/src/main/res/drawable/aquafina.jpg
app/src/main/res/drawable/beta_malt.jpg
app/src/main/res/drawable/boma_logo.jpg
app/src/main/res/drawable/bottle.jpg
app/src/main/res/drawable/budweiser.png
app/src/main/res/drawable/castle_lite.jpg
app/src/main/res/drawable/coke.png
app/src/main/res/drawable/despy.png
app/src/main/res/drawable/eva.jpg
app/src/main/res/drawable/fearless.jpg
app/src/main/res/drawable/fish.jpg
app/src/main/res/drawable/grand_malt.jpg
app/src/main/res/drawable/guinness.png
app/src/main/res/drawable/gulder.png
app/src/main/res/drawable/heineken.jpg
app/src/main/res/drawable/hero.jpg
app/src/main/res/drawable/ic_launcher_background.xml
app/src/main/res/drawable/ic_launcher_foreground.xml
app/src/main/res/drawable/legend.jpg
app/src/main/res/drawable/life.jpg
app/src/main/res/drawable/maltina.jpg
app/src/main/res/drawable/naira.xml
app/src/main/res/drawable/naira1.png
app/src/main/res/drawable/nutri_choco.jpg
app/src/main/res/drawable/nutri_milk.png
app/src/main/res/drawable/nutri_yo.jpg
app/src/main/res/drawable/orijin.jpg
app/src/main/res/drawable/orijin2.jpg
app/src/main/res/drawable/pepsi.jpg
app/src/main/res/drawable/pop_cola.jpg
app/src/main/res/drawable/predator.jpg
app/src/main/res/drawable/price_change.xml
app/src/main/res/drawable/radler.png
app/src/main/res/drawable/record.xml
app/src/main/res/drawable/star.jpg
app/src/main/res/drawable/stock.xml
app/src/main/res/drawable/tiger.jpg
app/src/main/res/drawable/trophy_stout.jpg
app/src/main/res/drawable/trophy.jpg
app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml
app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml
app/src/main/res/mipmap-hdpi/ic_launcher_foreground.webp
app/src/main/res/mipmap-hdpi/ic_launcher_round.webp
app/src/main/res/mipmap-hdpi/ic_launcher.webp
app/src/main/res/mipmap-mdpi/ic_launcher_foreground.webp
app/src/main/res/mipmap-mdpi/ic_launcher_round.webp
app/src/main/res/mipmap-mdpi/ic_launcher.webp
app/src/main/res/mipmap-xhdpi/ic_launcher_foreground.webp
app/src/main/res/mipmap-xhdpi/ic_launcher_round.webp
app/src/main/res/mipmap-xhdpi/ic_launcher.webp
app/src/main/res/mipmap-xxhdpi/ic_launcher_foreground.webp
app/src/main/res/mipmap-xxhdpi/ic_launcher_round.webp
app/src/main/res/mipmap-xxhdpi/ic_launcher.webp
app/src/main/res/mipmap-xxxhdpi/ic_launcher_foreground.webp
app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.webp
app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp
app/src/main/res/values/colors.xml
app/src/main/res/values/strings.xml
app/src/main/res/values/themes.xml
app/src/main/res/xml/backup_rules.xml
app/src/main/res/xml/data_extraction_rules.xml
app/src/test/java/com/guvnoh/boma/ExampleUnitTest.kt
build.gradle.kts
gradle.properties
gradle/libs.versions.toml
gradle/wrapper/gradle-wrapper.jar
gradle/wrapper/gradle-wrapper.properties
gradlew
gradlew.bat
settings.gradle.kts
```

# Files

## File: .gitignore
```
*.iml
.gradle
/local.properties
/.idea/caches
/.idea/libraries
/.idea/modules.xml
/.idea/workspace.xml
/.idea/navEditor.xml
/.idea/assetWizardSettings.xml
.DS_Store
/build
/captures
.externalNativeBuild
.cxx
local.properties
```

## File: app/.gitignore
```
/build
```

## File: app/google-services.json
```json
{
  "project_info": {
    "project_number": "1036788853215",
    "firebase_url": "https://freemann-firms-default-rtdb.firebaseio.com",
    "project_id": "freemann-firms",
    "storage_bucket": "freemann-firms.firebasestorage.app"
  },
  "client": [
    {
      "client_info": {
        "mobilesdk_app_id": "1:1036788853215:android:cb4340cf04dc0b277cfc6a",
        "android_client_info": {
          "package_name": "com.guvnoh.binl"
        }
      },
      "oauth_client": [],
      "api_key": [
        {
          "current_key": "AIzaSyBvT3qj25i69EE63fUFWwDE4XHx-07x7k8"
        }
      ],
      "services": {
        "appinvite_service": {
          "other_platform_oauth_client": []
        }
      }
    },
    {
      "client_info": {
        "mobilesdk_app_id": "1:1036788853215:android:2d49ef49181dd99f7cfc6a",
        "android_client_info": {
          "package_name": "com.guvnoh.boma"
        }
      },
      "oauth_client": [],
      "api_key": [
        {
          "current_key": "AIzaSyBvT3qj25i69EE63fUFWwDE4XHx-07x7k8"
        }
      ],
      "services": {
        "appinvite_service": {
          "other_platform_oauth_client": []
        }
      }
    },
    {
      "client_info": {
        "mobilesdk_app_id": "1:1036788853215:android:a91464966917adc97cfc6a",
        "android_client_info": {
          "package_name": "com.guvnoh.freemannfirms"
        }
      },
      "oauth_client": [],
      "api_key": [
        {
          "current_key": "AIzaSyBvT3qj25i69EE63fUFWwDE4XHx-07x7k8"
        }
      ],
      "services": {
        "appinvite_service": {
          "other_platform_oauth_client": []
        }
      }
    }
  ],
  "configuration_version": "1"
}
```

## File: app/proguard-rules.pro
```
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
```

## File: app/src/androidTest/java/com/guvnoh/boma/ExampleInstrumentedTest.kt
```kotlin
package com.guvnoh.boma

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.guvnoh.boma", appContext.packageName)
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/dateProvider/DateProvider.kt
```kotlin
package com.guvnoh.boma.dateProvider

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Locale

object DateProvider {
    fun todayString(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now().toString()
        } else {
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/formatters/NumberFormatter.kt
```kotlin
package com.guvnoh.boma.formatters

fun halfAndQuarter(num: Double): String{
    //converts 0.5 to display as '½', same for 0.25 (quarter)
    //also converts them when they have integer companions e.g '1½' etc...
    val integerPart = (num).toInt()
    return if (num % 1 == 0.5){
        if(integerPart==0){
            "½"
        } else "$integerPart½"
    }else if (num % 1 == 0.25){
        if(integerPart==0){
            "¼"
        } else "$integerPart¼"
    }
    else if (num>num.toInt()){
        num.toString()
    }else num.toInt().toString()
}
```

## File: app/src/main/java/com/guvnoh/boma/functions/Screenshot.kt
```kotlin
package com.guvnoh.boma.functions

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.compose.ui.platform.LocalView
import java.io.OutputStream

fun captureScreen(view: View): Bitmap {
    val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
    val canvas = android.graphics.Canvas(bitmap)
    view.draw(canvas)
    return bitmap
}

fun saveBitmapToGallery(context: Context, bitmap: Bitmap) {
    val filename = "Screenshot_${System.currentTimeMillis()}.png"
    val resolver = context.contentResolver
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
        put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
    }

    val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

    uri?.let {
        val outputStream: OutputStream? = resolver.openOutputStream(it)
        outputStream.use { stream ->
            if (stream != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            }
        }
    }
    Toast.makeText(context, "Screenshot saved.", Toast.LENGTH_SHORT).show()
}
```

## File: app/src/main/java/com/guvnoh/boma/functions/stockCalculator.kt
```kotlin
package com.guvnoh.boma.functions

object StockCalculator {

    fun calculateClosingStock(
        opening: Double,
        received: Double,
        sold: Double
    ): Double {
        return (opening + received - sold).coerceAtLeast(0.0)
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/functions/VibratePhone.kt
```kotlin
package com.guvnoh.boma.functions

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
fun vibratePhone(context: Context, duration: Long = 100L) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        val vibrator = vibratorManager.defaultVibrator
        vibrator.vibrate(
            VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE)
        )
    } else {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(
            VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE)
        )
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/models/Screen.kt
```kotlin
package com.guvnoh.boma.models

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.guvnoh.boma.R

sealed class MenuIcon {
    data class Resource(@DrawableRes val resId: Int): MenuIcon()
    data class Vector( val imageVector: ImageVector): MenuIcon()
}

open class Screen(
    val route: String,
    val title: String,
    val icon: MenuIcon? = null
) {
    data object Products : Screen(
        route = "products",
        title = "Products",
        icon = MenuIcon.Vector(Icons.Default.ShoppingCart)
    )

    data object PriceChange : Screen(
        route = "price_change",
        title = "Change Price",
        icon = MenuIcon.Resource(R.drawable.naira)
    )

    data object Receipt : Screen(route = "receipt", title = "Receipt",)
    data object AddProduct : Screen(
        route = "add_product",
        title = "Add Products",
        icon = MenuIcon.Vector(Icons.Default.AddCircle)
    )

    data object DeleteProduct : Screen(
        route = "delete_product",
        title = "Delete Products",
        icon = MenuIcon.Vector(Icons.Default.Delete)
    )

    data object Stock :
        Screen(route = "stock", title = "Stock", icon = MenuIcon.Resource(R.drawable.stock))

    data object WarehouseStock :
        Screen(route = "warehouseStock", title = "Warehouse Stock", icon = MenuIcon.Resource(R.drawable.stock))

    data object HeadOfficeStock :
        Screen(route = "headOfficeStock", title = "HeadOffice Stock", icon = MenuIcon.Resource(R.drawable.stock))

    data object Records :
        Screen(route = "records", title = "Records", icon = MenuIcon.Resource(R.drawable.record))

    data object RecordDetails : Screen(route = "record_details", title = "Record")


}
```

## File: app/src/main/java/com/guvnoh/boma/repositories/AppMetaRepository.kt
```kotlin
package com.guvnoh.boma.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.guvnoh.boma.dateProvider.DateProvider
import com.guvnoh.boma.database.FirebaseRefs

class AppMetaRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkNewDay(onNewDay: () -> Unit) {

        FirebaseRefs.appMeta
            .child("lastProcessedDay")
            .runTransaction(object : Transaction.Handler {
                override fun doTransaction(data: MutableData): Transaction.Result {
                    val today = DateProvider.todayString()
                    if (data.value == today) return Transaction.abort()
                    data.value = today
                    return Transaction.success(data)
                }

                override fun onComplete(
                    error: DatabaseError?,
                    committed: Boolean,
                    currentData: DataSnapshot?
                ) {
                    if (committed && error == null) onNewDay()
                }

            })

    }
}
```

## File: app/src/main/java/com/guvnoh/boma/ui/theme/Type.kt
```kotlin
package com.guvnoh.boma.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/cards/UpdateStock.kt
```kotlin
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
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/stock/HeadOfficeStock.kt
```kotlin
//package com.guvnoh.boma.uidesigns.screens
//
//import androidx.compose.runtime.Composable
//import com.guvnoh.boma.models.Screen
//
//@Composable
//fun HeadOfficeStock(){
//
//}

package com.guvnoh.boma.uidesigns.screens.stock

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.wear.compose.material.Icon
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.StockSplashScreen
import com.guvnoh.boma.uidesigns.cards.StockCard
import com.guvnoh.boma.viewmodels.StockViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockScreen(
    stockViewModel: StockViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    stock: Map<String, FullsStock>,
    title: String

    ) {
    //val products by productsViewModel.products.collectAsState()


    var showSplash by remember { mutableStateOf(true) }
//    var topBarTitle by remember { mutableStateOf("Full Stock") }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        containerColor = MaterialTheme.colorScheme.background,

        // --- FAB ---
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Update stock",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                text = {
                    Text(
                        text = "Update",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp),
                elevation = FloatingActionButtonDefaults.elevation(6.dp)
            )
        },

        // --- Top Bar ---
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today: ${getDate()}",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(0.85f),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                    thickness = 1.dp
                )
            }
        },

        // --- Bottom Bar ---
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 4.dp
            ) {
                val bottomBarItems = listOf(BottomBarItem.Fulls, BottomBarItem.Empties)
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomBarItems.forEach { item ->
                    val selected = currentRoute == item.route

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { item.icon },
                        label = { Text(item.title) },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ) { innerPadding ->
        // --- Screen Content ---
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (showSplash) {
                StockSplashScreen(
                    modifier = Modifier.fillMaxSize(),
                    onTimeOut = { showSplash = false },
                    stock = stock.values.toMutableList()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                ) {
                    items(stock.keys.toMutableList()) {
                            brand ->
                        val brandStock = stock[brand] ?: FullsStock()
                        StockCard(brand, brandStock)
                    }
                }
            }
        }
    }
}

//open class BottomBarItem(
//    val route: String,
//    val title: String,
//    val icon: Int,
//
//    ){
//    data object Fulls: BottomBarItem(route = "fulls", title = "Fulls", R.drawable.orijin)
//    data object Empties: BottomBarItem(route = "empties", title = "Empties", R.drawable.bottle)
//}

//fun sendStockData(list: List<Product>){
//
//    list.forEach {
//        val random1 = (20..800).random()
//        val random2 = (20..800).random()
//        val stock = FullsStock(
//            closingStock = random1.toDouble(),
//            openingStock = random2.toDouble(),
//            depletion = 0.0,
//            lastTimeSold = "Fri, Oct 31 2025"
//        )
//        it.stock = stock
//        FirebaseRefs.fullStock
//            .child(it.name?:"unknown")
//            .setValue(it)
//
//    }
//
//}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStock(){
    // StockFullsScreen(stockViewModel = viewModel(), navController = rememberNavController(), )

}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/stock/StockEmptiesScreen.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens.stock

import android.os.Build
import androidx.annotation.RequiresApi
import com.guvnoh.boma.uidesigns.cards.EmptiesStockCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Icon
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.EmptyType
import com.guvnoh.boma.models.StockSplashScreen
import com.guvnoh.boma.viewmodels.StockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockEmptiesScreen(
    paddingValues: PaddingValues,
    vm: StockViewModel,
    navController: NavController,

    ){

    val emptiesStock by vm.emptiesStock.collectAsState()
    var showSplash by remember { mutableStateOf(true) }
    //var topBarTitle by remember { mutableStateOf("Empties") }

    Scaffold(
        floatingActionButton = {FloatingActionButton(
            onClick = {
                //navController.navigate()
            }
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                Text(text = "Update")
            }
        }},
        modifier = Modifier.padding(paddingValues),
        topBar = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "Empties",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        bottomBar = {
            NavigationBar {
                val bottomBarItems = listOf(BottomBarItem.Fulls, BottomBarItem.Empties)
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                bottomBarItems.forEach {
                    val selected = currentRoute == it.route
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            val route = it.route
                            navController.navigate(route){launchSingleTop = true
                            } },
                        icon = {it.icon},
                        label = { Text(it.title) }
                    )
                }
            }
        }
    ){
        if (showSplash){
            StockSplashScreen(
                modifier = Modifier.padding(it),
                onTimeOut = {showSplash = false},
                empties = emptiesStock.values.toMutableList()
            )
        }else{
            LazyColumn(
                modifier = Modifier.padding(it)
            ) {
                items(emptiesStock.values.toMutableList()){
                        brandStock ->
                    EmptiesStockCard(brandStock)
                }
            }
        }
    }
}

fun sendEmptiesData(){
    val list: List<EmptyCompany> = EmptyCompany.entries

    list.forEach {
        val random1 = (20..800).random()
        val random2 = (20..800).random()
        val emptiesStock =
            when(it){
                EmptyCompany.HERO ->
                    EmptiesStock(
                        company = it,
                        emptyType = EmptyType.TWELVE,
                        quantity = random2.toDouble(),
                    )
                EmptyCompany.NBL ->
                    EmptiesStock(
                        company = it,
                        emptyType = EmptyType.TWELVE,
                        quantity = random2.toDouble(),
                    )
                EmptyCompany.COCA_COLA ->
                    EmptiesStock(
                        company = it,
                        emptyType = EmptyType.TWENTY_FOUR,
                        quantity = random2.toDouble(),
                    )
                EmptyCompany.GUINNESS ->
                    EmptiesStock(
                        company = it,
                        emptyType = EmptyType.EIGHTEEN,
                        quantity = random2.toDouble(),
                    )

            }
        FirebaseRefs.empties
            .child(emptiesStock.company?.name?:"unknown")
            .setValue(emptiesStock)
    }

}



@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStock(){
    StockEmptiesScreen(PaddingValues(), viewModel(), navController = rememberNavController())

}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/stock/WarehouseStock.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens.stock

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Icon
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.models.StockSplashScreen
import com.guvnoh.boma.uidesigns.cards.StockCard
import com.guvnoh.boma.viewmodels.StockViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockFullsScreen(
    paddingValues: PaddingValues,
    stockViewModel: StockViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,

    ) {
    //val products by productsViewModel.products.collectAsState()
    val warehouse by stockViewModel.wareHouseStock.collectAsState()
    val headOffice by stockViewModel.headOfficeStock.collectAsState()
    var stockChoice by remember { mutableStateOf(warehouse) }

    var showSplash by remember { mutableStateOf(true) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
            //.background(MaterialTheme.colorScheme.background),
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),

        // --- FAB ---
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Update stock",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                text = {
                    Text(
                        text = "Update",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp),
                elevation = FloatingActionButtonDefaults.elevation(6.dp)
            )
        },

        // --- Top Bar ---
        topBar = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .wrapContentHeight()
                    .statusBarsPadding()
                    .padding(vertical = 12.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = getDate(),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black//MaterialTheme.colorScheme.onSurface
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(0.85f),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                    thickness = 1.dp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    // choose stock

                    Button(
                        onClick = {
                            stockChoice = warehouse
                        },
                        colors = if (stockChoice != warehouse) {
                            ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                        }else ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ){
                        Text(
                            text = Screen.WarehouseStock.title,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                    }


                    Button(
                        onClick = {
                            stockChoice = headOffice
                        },
                        colors = if (stockChoice != headOffice) {
                            ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                        }else ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ){
                        Text(
                            text = Screen.HeadOfficeStock.title,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                    }
                }

            }
        },

        // --- Bottom Bar ---
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 4.dp
            ) {
                val bottomBarItems = listOf(BottomBarItem.Fulls, BottomBarItem.Empties)
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomBarItems.forEach { item ->
                    val selected = currentRoute == item.route

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { item.icon },
                        label = { Text(item.title) },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ) { innerPadding ->
        // --- Screen Content ---
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (showSplash) {
                StockSplashScreen(
                    modifier = Modifier.fillMaxSize(),
                    onTimeOut = { showSplash = false },
                    stock = stockChoice.values.toMutableList()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                ) {
                    items(stockChoice.keys.toMutableList()) {
                        brand ->
                        val name = brand.name?:"error"
                        val brandStock = stockChoice[brand] ?: FullsStock()
                        StockCard(name, brandStock)
                    }
                }
            }
        }
    }
}

open class BottomBarItem(
    val route: String,
    val title: String,
    val icon: Int,

    ){
    data object Fulls: BottomBarItem(route = "fulls", title = "Fulls", R.drawable.orijin)
    data object Empties: BottomBarItem(route = "empties", title = "Empties", R.drawable.bottle)
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStock(){
    val vm: StockViewModel = viewModel()
   StockFullsScreen(
       paddingValues = PaddingValues(),
       stockViewModel = vm,
       navController = rememberNavController(),
       modifier = Modifier,
   )

}
```

## File: app/src/main/java/com/guvnoh/boma/viewmodels/RecordViewModel.kt
```kotlin
package com.guvnoh.boma.viewmodels

import androidx.lifecycle.ViewModel
import com.guvnoh.boma.functions.getDatabaseRecords
import com.guvnoh.boma.models.Receipt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecordViewModel: ViewModel(){
    private val _records = MutableStateFlow<List<Receipt>> (emptyList())
    val records: StateFlow<List<Receipt>> = getDbRecords()
    private var _record = MutableStateFlow<Receipt?>(null)
    val record: StateFlow<Receipt?> = _record

    private fun getDbRecords(): StateFlow<List<Receipt>>{
        getDatabaseRecords {
            dbRecords ->
            _records.value = dbRecords.asReversed()
        }
        return _records
    }
    fun setCurrentRecord(receipt: Receipt){
        _record.value = receipt
    }
}
```

## File: app/src/main/res/drawable/ic_launcher_foreground.xml
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aapt="http://schemas.android.com/aapt"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path android:pathData="M31,63.928c0,0 6.4,-11 12.1,-13.1c7.2,-2.6 26,-1.4 26,-1.4l38.1,38.1L107,108.928l-32,-1L31,63.928z">
        <aapt:attr name="android:fillColor">
            <gradient
                android:endX="85.84757"
                android:endY="92.4963"
                android:startX="42.9492"
                android:startY="49.59793"
                android:type="linear">
                <item
                    android:color="#44000000"
                    android:offset="0.0" />
                <item
                    android:color="#00000000"
                    android:offset="1.0" />
            </gradient>
        </aapt:attr>
    </path>
    <path
        android:fillColor="#FFFFFF"
        android:fillType="nonZero"
        android:pathData="M65.3,45.828l3.8,-6.6c0.2,-0.4 0.1,-0.9 -0.3,-1.1c-0.4,-0.2 -0.9,-0.1 -1.1,0.3l-3.9,6.7c-6.3,-2.8 -13.4,-2.8 -19.7,0l-3.9,-6.7c-0.2,-0.4 -0.7,-0.5 -1.1,-0.3C38.8,38.328 38.7,38.828 38.9,39.228l3.8,6.6C36.2,49.428 31.7,56.028 31,63.928h46C76.3,56.028 71.8,49.428 65.3,45.828zM43.4,57.328c-0.8,0 -1.5,-0.5 -1.8,-1.2c-0.3,-0.7 -0.1,-1.5 0.4,-2.1c0.5,-0.5 1.4,-0.7 2.1,-0.4c0.7,0.3 1.2,1 1.2,1.8C45.3,56.528 44.5,57.328 43.4,57.328L43.4,57.328zM64.6,57.328c-0.8,0 -1.5,-0.5 -1.8,-1.2s-0.1,-1.5 0.4,-2.1c0.5,-0.5 1.4,-0.7 2.1,-0.4c0.7,0.3 1.2,1 1.2,1.8C66.5,56.528 65.6,57.328 64.6,57.328L64.6,57.328z"
        android:strokeWidth="1"
        android:strokeColor="#00000000" />
</vector>
```

## File: app/src/main/res/drawable/naira.xml
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android" android:height="24dp" android:viewportHeight="84.992" android:viewportWidth="84.992" android:width="24dp">
      
    <path android:fillColor="#000000" android:pathData="M63.611,77.556c-1.207,0 -2.303,-0.176 -3.256,-0.52c-0.947,-0.338 -1.854,-0.892 -2.691,-1.641c-0.842,-0.751 -1.645,-1.65 -2.377,-2.674c-0.746,-1.044 -1.492,-2.107 -2.213,-3.16l-9.885,-15.154H26.451v15.539c0,2.52 -0.584,4.438 -1.734,5.709c-1.162,1.278 -2.611,1.899 -4.428,1.899c-1.881,0 -3.342,-0.628 -4.469,-1.919c-1.125,-1.283 -1.695,-3.198 -1.695,-5.689V54.407h-9.58C2.039,54.407 0,52.368 0,49.862s2.039,-4.545 4.545,-4.545h9.58v-7.757h-9.58C2.039,37.561 0,35.522 0,33.017s2.039,-4.545 4.545,-4.545h9.58V17.146c0,-2.189 0.238,-3.909 0.707,-5.11c0.586,-1.39 1.508,-2.464 2.834,-3.322c1.326,-0.86 2.719,-1.278 4.258,-1.278c1.189,0 2.221,0.194 3.061,0.579c0.863,0.394 1.594,0.906 2.236,1.565c0.654,0.669 1.33,1.547 2.012,2.606c0.701,1.09 1.424,2.225 2.191,3.437l8.492,12.849h18.746V15.046c0,-2.554 0.547,-4.484 1.625,-5.739c1.082,-1.259 2.506,-1.871 4.352,-1.871c1.908,0 3.371,0.613 4.469,1.874c1.093,1.254 1.646,3.185 1.646,5.736v13.426h9.693c2.506,0 4.545,2.039 4.545,4.545s-2.039,4.544 -4.545,4.544h-9.693v7.758h9.693c2.506,0 4.545,2.038 4.545,4.545c0,2.506 -2.039,4.543 -4.545,4.543h-9.693v14.467C70.754,74.716 68.418,77.556 63.611,77.556zM24.951,51.407h19.051c0.506,0 0.979,0.256 1.256,0.68l10.312,15.809c0.688,1.01 1.426,2.055 2.157,3.081c0.604,0.841 1.256,1.575 1.938,2.183c0.549,0.492 1.121,0.846 1.707,1.055c0.629,0.229 1.381,0.343 2.24,0.343c1.747,0 4.143,0 4.143,-5.683V52.907c0,-0.828 0.673,-1.5 1.5,-1.5h11.193c0.853,0 1.545,-0.693 1.545,-1.545s-0.692,-1.545 -1.545,-1.545H69.254c-0.828,0 -1.5,-0.672 -1.5,-1.5V36.061c0,-0.828 0.672,-1.5 1.5,-1.5h11.193c0.852,0 1.545,-0.692 1.545,-1.544s-0.693,-1.545 -1.545,-1.545H69.254c-0.828,0 -1.5,-0.672 -1.5,-1.5V15.046c0,-2.25 -0.494,-3.29 -0.91,-3.767c-0.363,-0.418 -0.908,-0.844 -2.205,-0.844c-0.971,0 -1.572,0.239 -2.076,0.826c-0.409,0.479 -0.899,1.523 -0.899,3.784v14.926c0,0.828 -0.672,1.5 -1.5,1.5H39.109c-0.504,0 -0.975,-0.253 -1.252,-0.673l-8.951,-13.545c-0.781,-1.23 -1.5,-2.359 -2.197,-3.443c-0.572,-0.891 -1.123,-1.609 -1.637,-2.135c-0.379,-0.391 -0.814,-0.694 -1.334,-0.932c-0.439,-0.201 -1.068,-0.308 -1.814,-0.308c-0.955,0 -1.789,0.253 -2.627,0.796c-0.816,0.529 -1.352,1.144 -1.686,1.934c-0.172,0.44 -0.486,1.602 -0.486,3.981v12.825c0,0.828 -0.672,1.5 -1.5,1.5H4.545C3.693,31.472 3,32.165 3,33.017s0.693,1.544 1.545,1.544h11.08c0.828,0 1.5,0.672 1.5,1.5v10.757c0,0.828 -0.672,1.5 -1.5,1.5H4.545C3.693,48.317 3,49.011 3,49.862s0.693,1.545 1.545,1.545h11.08c0.828,0 1.5,0.672 1.5,1.5v17.039c0,1.719 0.33,3.004 0.953,3.715c0.547,0.627 1.207,0.895 2.211,0.895c0.963,0 1.621,-0.273 2.205,-0.917c0.625,-0.688 0.957,-1.966 0.957,-3.69V52.907C23.451,52.079 24.123,51.407 24.951,51.407zM60.162,63.331c-0.494,0 -0.969,-0.246 -1.252,-0.674l-5.896,-8.924c-0.303,-0.461 -0.33,-1.052 -0.067,-1.537c0.262,-0.486 0.771,-0.789 1.319,-0.789h5.896c0.828,0 1.5,0.672 1.5,1.5v8.924c0,0.662 -0.436,1.246 -1.068,1.437C60.451,63.31 60.305,63.331 60.162,63.331zM57.055,54.407l1.607,2.432v-2.432H57.055zM60.162,48.317h-9.92c-0.504,0 -0.975,-0.253 -1.252,-0.673l-7.107,-10.757c-0.305,-0.461 -0.332,-1.052 -0.07,-1.538c0.262,-0.485 0.77,-0.789 1.32,-0.789h17.029c0.828,0 1.5,0.672 1.5,1.5v10.757C61.662,47.646 60.99,48.317 60.162,48.317zM51.049,45.317h7.613v-7.757h-12.74L51.049,45.317zM40.029,48.317H24.951c-0.828,0 -1.5,-0.672 -1.5,-1.5V36.061c0,-0.828 0.672,-1.5 1.5,-1.5h8.063c0.506,0 0.979,0.256 1.256,0.681l7.016,10.757c0.301,0.461 0.324,1.049 0.063,1.533C41.086,48.017 40.58,48.317 40.029,48.317zM26.451,45.317H37.26l-5.059,-7.757h-5.75V45.317zM29.041,31.473h-4.09c-0.828,0 -1.5,-0.672 -1.5,-1.5v-6.271c0,-0.664 0.436,-1.249 1.072,-1.438c0.635,-0.188 1.322,0.062 1.684,0.618l4.09,6.271c0.301,0.461 0.326,1.05 0.064,1.534C30.098,31.17 29.592,31.473 29.041,31.473z"/>
    
</vector>
```

## File: app/src/main/res/drawable/price_change.xml
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="960"
    android:viewportHeight="960">
  <path
      android:pathData="M80,800v-640h800v640L80,800ZM160,720h640v-480L160,240v480ZM160,720v-480,480ZM320,680h80v-40h40q17,0 28.5,-11.5T480,600v-120q0,-17 -11.5,-28.5T440,440L320,440v-40h160v-80h-80v-40h-80v40h-40q-17,0 -28.5,11.5T240,360v120q0,17 11.5,28.5T280,520h120v40L240,560v80h80v40ZM640,650 L720,570L560,570l80,80ZM560,400h160l-80,-80 -80,80Z"
      android:fillColor="#e3e3e3"/>
</vector>
```

## File: app/src/main/res/drawable/record.xml
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="960"
    android:viewportHeight="960">
  <path
      android:pathData="M240,880q-50,0 -85,-35t-35,-85v-120h120v-560h600v680q0,50 -35,85t-85,35L240,880ZM720,800q17,0 28.5,-11.5T760,760v-600L320,160v480h360v120q0,17 11.5,28.5T720,800ZM360,360v-80h360v80L360,360ZM360,480v-80h360v80L360,480ZM240,800h360v-80L200,720v40q0,17 11.5,28.5T240,800ZM240,800h-40,400 -360Z"
      android:fillColor="#e3e3e3"/>
</vector>
```

## File: app/src/main/res/drawable/stock.xml
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="960"
    android:viewportHeight="960">
  <path
      android:pathData="M200,840q-33,0 -56.5,-23.5T120,760v-640h80v640h640v80L200,840ZM240,720v-360h160v360L240,720ZM440,720v-560h160v560L440,720ZM640,720v-200h160v200L640,720Z"
      android:fillColor="#e3e3e3"/>
</vector>
```

## File: app/src/main/res/values/colors.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700B3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
</resources>
```

## File: app/src/main/res/values/strings.xml
```xml
<resources>
    <string name="app_name">BOMA</string>
</resources>
```

## File: app/src/main/res/values/themes.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>

    <style name="Theme.BOMA" parent="android:Theme.Material.Light.NoActionBar" />
</resources>
```

## File: app/src/main/res/xml/backup_rules.xml
```xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample backup rules file; uncomment and customize as necessary.
   See https://developer.android.com/guide/topics/data/autobackup
   for details.
   Note: This file is ignored for devices older that API 31
   See https://developer.android.com/about/versions/12/backup-restore
-->
<full-backup-content>
    <!--
   <include domain="sharedpref" path="."/>
   <exclude domain="sharedpref" path="device.xml"/>
-->
</full-backup-content>
```

## File: app/src/main/res/xml/data_extraction_rules.xml
```xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample data extraction rules file; uncomment and customize as necessary.
   See https://developer.android.com/about/versions/12/backup-restore#xml-changes
   for details.
-->
<data-extraction-rules>
    <cloud-backup>
        <!-- TODO: Use <include> and <exclude> to control what is backed up.
        <include .../>
        <exclude .../>
        -->
    </cloud-backup>
    <!--
    <device-transfer>
        <include .../>
        <exclude .../>
    </device-transfer>
    -->
</data-extraction-rules>
```

## File: app/src/test/java/com/guvnoh/boma/ExampleUnitTest.kt
```kotlin
package com.guvnoh.boma

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
```

## File: gradle.properties
```
# Project-wide Gradle settings.
# IDE (e.g. Android Studio) users:
# Gradle settings configured through the IDE *will override*
# any settings specified in this file.
# For more details on how to configure your build environment visit
# http://www.gradle.org/docs/current/userguide/build_environment.html
# Specifies the JVM arguments used for the daemon process.
# The setting is particularly useful for tweaking memory settings.
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
# When configured, Gradle will run in incubating parallel mode.
# This option should only be used with decoupled projects. For more details, visit
# https://developer.android.com/r/tools/gradle-multi-project-decoupled-projects
# org.gradle.parallel=true
# AndroidX package structure to make it clearer which packages are bundled with the
# Android operating system, and which are packaged with your app's APK
# https://developer.android.com/topic/libraries/support-library/androidx-rn
android.useAndroidX=true
# Kotlin code style for this project: "official" or "obsolete":
kotlin.code.style=official
# Enables namespacing of each library's R class so that its R class includes only the
# resources declared in the library itself and none from the library's dependencies,
# thereby reducing the size of the R class for that library
android.nonTransitiveRClass=true
```

## File: gradlew
```
#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/" >/dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "`uname`" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
  NONSTOP* )
    nonstop=true
    ;;
esac

CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar


# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Increase the maximum file descriptors if we can.
if [ "$cygwin" = "false" -a "$darwin" = "false" -a "$nonstop" = "false" ] ; then
    MAX_FD_LIMIT=`ulimit -H -n`
    if [ $? -eq 0 ] ; then
        if [ "$MAX_FD" = "maximum" -o "$MAX_FD" = "max" ] ; then
            MAX_FD="$MAX_FD_LIMIT"
        fi
        ulimit -n $MAX_FD
        if [ $? -ne 0 ] ; then
            warn "Could not set maximum file descriptor limit: $MAX_FD"
        fi
    else
        warn "Could not query maximum file descriptor limit: $MAX_FD_LIMIT"
    fi
fi

# For Darwin, add options to specify how the application appears in the dock
if $darwin; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if [ "$cygwin" = "true" -o "$msys" = "true" ] ; then
    APP_HOME=`cygpath --path --mixed "$APP_HOME"`
    CLASSPATH=`cygpath --path --mixed "$CLASSPATH"`

    JAVACMD=`cygpath --unix "$JAVACMD"`

    # We build the pattern for arguments to be converted via cygpath
    ROOTDIRSRAW=`find -L / -maxdepth 1 -mindepth 1 -type d 2>/dev/null`
    SEP=""
    for dir in $ROOTDIRSRAW ; do
        ROOTDIRS="$ROOTDIRS$SEP$dir"
        SEP="|"
    done
    OURCYGPATTERN="(^($ROOTDIRS))"
    # Add a user-defined pattern to the cygpath arguments
    if [ "$GRADLE_CYGPATTERN" != "" ] ; then
        OURCYGPATTERN="$OURCYGPATTERN|($GRADLE_CYGPATTERN)"
    fi
    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    i=0
    for arg in "$@" ; do
        CHECK=`echo "$arg"|egrep -c "$OURCYGPATTERN" -`
        CHECK2=`echo "$arg"|egrep -c "^-"`                                 ### Determine if an option

        if [ $CHECK -ne 0 ] && [ $CHECK2 -eq 0 ] ; then                    ### Added a condition
            eval `echo args$i`=`cygpath --path --ignore --mixed "$arg"`
        else
            eval `echo args$i`="\"$arg\""
        fi
        i=`expr $i + 1`
    done
    case $i in
        0) set -- ;;
        1) set -- "$args0" ;;
        2) set -- "$args0" "$args1" ;;
        3) set -- "$args0" "$args1" "$args2" ;;
        4) set -- "$args0" "$args1" "$args2" "$args3" ;;
        5) set -- "$args0" "$args1" "$args2" "$args3" "$args4" ;;
        6) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" ;;
        7) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" ;;
        8) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" "$args7" ;;
        9) set -- "$args0" "$args1" "$args2" "$args3" "$args4" "$args5" "$args6" "$args7" "$args8" ;;
    esac
fi

# Escape application args
save () {
    for i do printf %s\\n "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\$s/\$/' \\\\/" ; done
    echo " "
}
APP_ARGS=`save "$@"`

# Collect all arguments for the java command, following the shell quoting and substitution rules
eval set -- $DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS "\"-Dorg.gradle.appname=$APP_BASE_NAME\"" -classpath "\"$CLASSPATH\"" org.gradle.wrapper.GradleWrapperMain "$APP_ARGS"

exec "$JAVACMD" "$@"
```

## File: gradlew.bat
```batch
@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar


@rem Execute Gradle
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable GRADLE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%GRADLE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
```

## File: settings.gradle.kts
```kotlin
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BOMA"
include(":app")
```

## File: app/src/main/AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
    <uses-permission android:name="android.permission.VIBRATE" />



    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.BOMA"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:windowSoftInputMode="adjustResize"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.BOMA">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## File: app/src/main/java/com/guvnoh/boma/formatters/CurrencyFormatter.kt
```kotlin
package com.guvnoh.boma.formatters

import java.text.DecimalFormat

//fun nairaFormat(num: Double): String{
//    var format = DecimalFormat("#,###")
//    val decimal =  num % 1 != 0.0
//
//    return if (num>=0.0 && decimal){
//        format = DecimalFormat("#,##0.00")
//        "₦${format.format(num)}.${num.toString().split(".")[1]}"
//    }else if (num == 0.0) {
//        "₦0.00"
//    }else if (num>=0.0){
//        "₦${format.format(num)}"
//    }else{"₦0.00"}
//}

fun nairaFormat(num: Double): String {
    val hasDecimal = num % 1 != 0.0
    val absValue = kotlin.math.abs(num)

    val format = if (hasDecimal) {
        DecimalFormat("#,##0.00")
    } else {
        DecimalFormat("#,###")
    }

    val formatted = format.format(absValue)

    return if (num < 0) {
        "-₦$formatted"
    } else {
        "₦$formatted"
    }
}

fun nairaFormat(num: Int): String {
    val format = DecimalFormat("#,###")
    val absValue = kotlin.math.abs(num)

    return if (num < 0) {
        "-₦${format.format(absValue)}"
    } else {
        "₦${format.format(absValue)}"
    }
}



//fun nairaFormat(num: Int): String{
//    val format = DecimalFormat("#,###")
//    return if (num>0){"₦${format.format(num)}"}else{"₦0.00"}
//}
```

## File: app/src/main/java/com/guvnoh/boma/ui/theme/Color.kt
```kotlin
package com.guvnoh.boma.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val hmmm = Color(0xFF8A0404)
```

## File: app/src/main/java/com/guvnoh/boma/ui/theme/Theme.kt
```kotlin
//package com.guvnoh.boma.ui.theme
//
//import android.app.Activity
//import android.os.Build
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.darkColorScheme
//import androidx.compose.material3.dynamicDarkColorScheme
//import androidx.compose.material3.dynamicLightColorScheme
//import androidx.compose.material3.lightColorScheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.platform.LocalContext
//
//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)
//
//@Composable
//fun BOMATheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = false,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}
package com.guvnoh.boma.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

// 🎨 Brand Colors
val GreenPrimary = Color(0xFF0A7D4F)   // Primary brand green
val AmberSecondary = Color(0xFFFFD166) // Accent for totals
val CoralTertiary = Color(0xFFEF476F)  // Alerts / highlights

// ⚪ Neutrals
val BackgroundLight = Color(0xFFF9FAFB)
val SurfaceLight = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1E293B)

// ✅ Status
val ErrorRed = Color(0xFFD62828)
val SuccessMint = Color(0xFF06D6A0)

// Light color scheme
private val LightColors = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = Color.White,
    secondary = AmberSecondary,
    onSecondary = Color.Black,
    tertiary = CoralTertiary,
    onTertiary = Color.White,
    background = BackgroundLight,
    onBackground = TextDark,
    surface = SurfaceLight,
    onSurface = TextDark,
    error = ErrorRed,
    onError = Color.White
)

// Dark color scheme (optional, tweak if needed)
private val DarkColors = darkColorScheme(
    primary = GreenPrimary,
    onPrimary = Color.White,
    secondary = AmberSecondary,
    onSecondary = Color.Black,
    tertiary = CoralTertiary,
    onTertiary = Color.White,
    background = Color(0xFF121212),
    onBackground = Color(0xFFEAEAEA),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFEAEAEA),
    error = ErrorRed,
    onError = Color.White


)
val lightGray = Color.LightGray

// ✅ Define your shapes here
val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)

@Composable
fun BOMATheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/DrawerMenu.kt
```kotlin
package com.guvnoh.boma.uidesigns

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.R
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.navigation.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.guvnoh.boma.models.MenuIcon
import com.guvnoh.boma.models.Screen.AddProduct
import com.guvnoh.boma.models.Screen.DeleteProduct
import com.guvnoh.boma.models.Screen.PriceChange
import com.guvnoh.boma.models.Screen.Products
import com.guvnoh.boma.models.Screen.Receipt
import com.guvnoh.boma.models.Screen.RecordDetails
import com.guvnoh.boma.models.Screen.Records
import com.guvnoh.boma.models.Screen.Stock
import com.guvnoh.boma.viewmodels.AppMetaViewModel


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Boma() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val vm: AppMetaViewModel = viewModel()
    var selectedScreen by remember { mutableStateOf<Screen>(Products) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                // Drawer Header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.boma_logo),
                            contentDescription = "Boma Logo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(120.dp)
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                // Drawer Items with ripple + hover
                DrawerItem(
                    screen = Products,
                    scope = scope,
                    isSelected = selectedScreen == Products,
                    drawerState = drawerState,
                    navController = navController,
                    onItemSelected = {selectedScreen = it}
                )


                DrawerItem(
                    screen = PriceChange,
                    scope = scope,
                    isSelected = selectedScreen == PriceChange,
                    drawerState = drawerState,
                    navController = navController,
                    onItemSelected = {selectedScreen = it}
                )

                DrawerItem(
                    screen = Stock,
                    scope = scope,
                    isSelected = selectedScreen == Stock,
                    drawerState = drawerState,
                    navController = navController,
                    onItemSelected = {selectedScreen = it}
                )

                DrawerItem(
                    screen = Records,
                    scope = scope,
                    isSelected = selectedScreen == Records,
                    drawerState = drawerState,
                    navController = navController,
                    onItemSelected = {selectedScreen = it}
                )

                DrawerItem(
                    screen = AddProduct,
                    scope = scope,
                    isSelected = selectedScreen == AddProduct,
                    drawerState = drawerState,
                    navController = navController,
                    onItemSelected = {selectedScreen = it}
                )

                DrawerItem(
                    screen = DeleteProduct,
                    scope = scope,
                    isSelected = selectedScreen == DeleteProduct,
                    drawerState = drawerState,
                    navController = navController,
                    onItemSelected = {
                        selectedScreen = it

                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        val navBackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackEntry?.destination?.route
                        val screenList: List<Screen> = listOf(
                            Products, PriceChange, Records, Receipt, RecordDetails, AddProduct, DeleteProduct, Stock
                        )
                        var currentTitle = ""
                        screenList.forEach {
                            if (it.route == currentRoute) currentTitle = it.title
                        }
                        Text(
                            text = currentTitle,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    },
                    navigationIcon = {

                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Navigation(innerPadding, navController)
        }
    }
}

@Composable
fun DrawerItem(
    screen: Screen,
    scope: CoroutineScope,
    isSelected: Boolean = false,
    drawerState: DrawerState,
    navController: NavController,
    onItemSelected: (Screen) -> Unit = {}
){
    val interactionSource = remember { MutableInteractionSource() }
    val bg = if (isSelected)
        MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
    else
        MaterialTheme.colorScheme.surface

    val tint = if (isSelected)
        MaterialTheme.colorScheme.primary
    else
        MaterialTheme.colorScheme.onSurface
    Row(
        modifier = Modifier

            .fillMaxWidth()
            .background(bg)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    scope.launch{ drawerState.close() }
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {

                        }
                        launchSingleTop = true
                    }
                    onItemSelected(screen)
                }
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when(val icon = screen.icon){
            is MenuIcon.Resource -> Icon(painterResource( icon.resId), "", tint = tint)
            is MenuIcon.Vector -> Icon(imageVector = icon.imageVector, "", tint = tint)
            null -> Icon(Icons.Default.Info, "", tint = tint)
        }
//        Icon(screen.icon, contentDescription = screen.title, tint = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.width(16.dp))
        Text(
            text = screen.title,
            color = tint,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    Boma()
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/priceChange/PriceChangeCard.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens.priceChange

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.brandData
import com.guvnoh.boma.repositories.ProductsRepository

@Composable
fun PriceChangeCard(
    product: Products,
    priceChangeViewmodel: PriceChangeViewmodel
) {
    var newPrice by remember { mutableStateOf("") }
    var priceError by remember { mutableStateOf<String?>(null) }
    var isExpanded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val imageRes = ProductsRepository()
        .getImage(context, product.imageName ?: "bottle.jpg")
        .takeIf { it != 0 } ?: R.drawable.bottle

    val currentPrice by remember { mutableDoubleStateOf(
        product.stringPrice?.toDoubleOrNull() ?: 0.0)}
    val pendingPrice = newPrice.toDoubleOrNull()?:0.0
    val priceChange  = pendingPrice - currentPrice
    val priceChangePercent  = if (currentPrice >0.0 && pendingPrice >0.0 ) {
        ((pendingPrice - currentPrice) / currentPrice) * 100
    } else 0.0


    Card(
        onClick = { isExpanded = !isExpanded },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isExpanded)
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.08f)
            else
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isExpanded) 4.dp else 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Main Row: Image + Product Info + Price
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Product Image
                Surface(
                    modifier = Modifier.size(64.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ) {
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = product.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Product Name & Current Price
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = product.name ?: "Unknown",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = nairaFormat(currentPrice),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        if (priceError == null) {
                            Icon(
                                imageVector = Icons.Default.TrendingUp,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = if (priceChange > 0)
                                    Color(0xFF4CAF50)
                                else
                                    Color(0xFFF44336)
                            )
                        }
                    }
                }

                // New Price Badge
                if (priceError == null && pendingPrice >0.0) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 4.dp)
                    ) {
                        Text(
                            text = nairaFormat(pendingPrice),
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            // Expanded Section: Input + Stats
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))

                    // Input Field
                    OutlinedTextField(
                        value = newPrice,
                        onValueChange = { input ->
                            val filtered = input.filter { it.isDigit() || it == '.' }
                            if (filtered.count { it == '.' } <= 1) {
                                newPrice = filtered
                                if (filtered.isNotEmpty()) {
                                    priceChangeViewmodel.changePrices(
                                        newPrice = filtered,
                                        product = product
                                    )
                                }
                                priceError = priceChangeViewmodel.errorCheck(filtered)
                            }
                        },
                        label = { Text("Enter New Price") },
                        leadingIcon = {
                            Text(
                                "₦",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        },
                        trailingIcon = {
                            if (newPrice.isNotEmpty()) {
                                IconButton(onClick = {
                                    newPrice = ""
                                    priceError = null
                                }) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Clear",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        },
                        placeholder = {
                            Text(
                                currentPrice.toString(),
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        isError = priceError != null,
                        supportingText = {
                            if (priceError != null) {
                                Text(priceError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline
                        )
                    )

                    // Price Change Stats
                    if (priceError == null) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Change Amount
                            Surface(
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Change",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${if (priceChange > 0) "+" else ""}${nairaFormat(priceChange)}",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        color = if (priceChange > 0) Color(0xFF4CAF50) else Color(0xFFF44336)
                                    )
                                }
                            }

                            // Percentage Change

                            Surface(
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Percent",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${if (priceChangePercent > 0) "+" else ""}%.1f%%".format(priceChangePercent),
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        color = if (priceChangePercent > 0) Color(0xFF4CAF50) else Color(0xFFF44336)
                                    )
                                }
                            }
                        }
                    }

                    // Confirm Button
                    if (priceError == null) {
                        Button(
                            onClick = {
                                newPrice = ""
                                isExpanded = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "Confirm Price Change",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.SemiBold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowCard() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                PriceChangeCard(brandData[1], viewModel())
            }
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/priceChange/PriceChangePage.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens.priceChange

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.guvnoh.boma.models.Screen


@Composable
fun PriceChangePage(
    navController: NavController,
    paddingValues: PaddingValues,
    priceChangeViewmodel: PriceChangeViewmodel
) {
    val productList by priceChangeViewmodel.products.collectAsState()
    val priceChangeList by priceChangeViewmodel.priceChangeProducts.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.padding(paddingValues),
        bottomBar = {
            Surface(
                tonalElevation = 4.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            priceChangeList.forEach { product ->
                                if (product.id!=null && product.doublePrice!=null){
                                    priceChangeViewmodel.updatePrice(product)
                                }
                            }
                            Toast.makeText(context, "Prices updated", Toast.LENGTH_SHORT).show()

                            navController.navigate(Screen.Products.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        enabled = priceChangeList.isNotEmpty(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Save Changes")
                        Spacer(Modifier.width(8.dp))
                        Text("Save Changes")
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(productList.sortedBy { it.name }) { product ->
                PriceChangeCard(product, priceChangeViewmodel)
            }
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/priceChange/PriceChangeViewmodel.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens.priceChange

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.repositories.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PriceChangeViewmodel: ViewModel() {

    //product list
    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products

    //price change products
    private val _priceChangeProducts = MutableStateFlow<List<Products>>(emptyList())
    val priceChangeProducts: StateFlow<List<Products>> = _priceChangeProducts

    init {
        observeProducts(FirebaseRefs.Products)
    }

    private fun observeProducts(repo: DatabaseReference) {
        val repository = ProductsRepository()
        repository.observeProducts(repo) { list ->
            _products.value = list
        }
    }


    private fun addToPriceChangeList(product: Products, newPrice: String ){
        val current = _priceChangeProducts.value.toMutableList()
        product.stringPrice = newPrice
        current.add(product)
        _priceChangeProducts.value = current
    }

//    // price change
//    fun updatePrice(product: Products) {
//        val repository = ProductsRepository()
//        repository.updatePrice(product)
//    }

    // Update price
    fun updatePrice(product: Products) {
        val productsRepo = FirebaseRefs.Products
        // update string and double price of product parameter
        productsRepo.child(product.id ?: "error")
            .child("stringPrice")
            .setValue(product.stringPrice)

        productsRepo.child(product.id?:"error")
            .child("doublePrice")
            .setValue(product.doublePrice)

    }

    fun changePrices(newPrice: String, product: Products){
        val parsedNewPrice = newPrice.filter { ch -> ch.isDigit() || ch == '.' }
        val parsed = parsedNewPrice.toDoubleOrNull()
        if (parsed != null && parsed > 0.0) {
            product.stringPrice = newPrice
            product.doublePrice = parsed
            addToPriceChangeList(product, newPrice)
        }
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
}
```

## File: app/src/main/java/com/guvnoh/boma/viewmodels/AppMetaViewModel.kt
```kotlin
//package com.guvnoh.boma.models
//
//import android.os.Build
//import android.util.Log
//import androidx.annotation.RequiresApi
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.guvnoh.boma.database.bomaStock
//import com.guvnoh.boma.formatters.checkIfSoldToday
//import com.guvnoh.boma.formatters.getDate
//import com.guvnoh.boma.functions.getDBProductList
//import com.guvnoh.boma.functions.getDBaseEmptiesStock
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.tasks.await
//
//class BomaViewModel : ViewModel() {
//    //products
//    private val _products = MutableStateFlow<List<Product>>(emptyList())
//    val products: StateFlow<List<Product>> = getProductList()
//
//    //sold products
//    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
//    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts
//

//

//

//
//    //fulls stock
//    private val _fullsStock = MutableStateFlow<List<FullsStock>>(emptyList())
//    val fullsStock: StateFlow<List<FullsStock>> = getDBFullsStock()
//

//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun confirmSoldToday(productList: List<Product>){
//        val stockDataBase = bomaStock.child("Fulls")
//
//        productList.forEach {
//            val isSoldToday = checkIfSoldToday(it.stock?.lastTimeSold?:"")
//            //Log.d("SendData", "Processing ${it.name} - soldToday=${it.stock.soldToday} - isSoldToday=$isSoldToday")
//            if (!isSoldToday && (it.stock?.soldToday?:0.0) > 0){
//                it.name?.let { brandName ->
//                    stockDataBase
//                        .child(brandName)
//                        .child("stock")
//                        .child("soldToday")
//                        .setValue(0.0)
//                }
//            }
//
//        }
//    }
//
//
//    //get stock data from database
//    private fun getDBFullsStock(): StateFlow<List<FullsStock>> {
//        val list = mutableListOf<FullsStock>()
//         _products.value.forEach {
//             it.stock?.let { it1 -> list.add(it1) }
//        }
//        _fullsStock.value = list
//        return _fullsStock
//    }
//
//    private fun getDBEmpties(): StateFlow<List<EmptiesStock>> {
//        getDBaseEmptiesStock {
//            emptiesStock ->
//            _emptiesStock.value = emptiesStock
//        }
//        return _emptiesStock
//    }
//
//

//

//
//    private fun getProductList(): StateFlow<List<Product>> {
//        // Fetch products
//        getDBProductList { dbList ->
//            _products.value = dbList
//        }
//
//        return _products
//    }
//
//    fun updateCustomerName(name: String){
//        _customerName.value = name
//    }
//

//
//    fun removeProduct(soldProduct: SoldProduct?) {
//        val current = _soldProducts.value.toMutableList()
//        val validSoldProduct = soldProduct ?: return
//        current.removeAll { it.product?.name == validSoldProduct.product?.name }
//        _soldProducts.value = current.toList()
//    }
//

//
//}
//

package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.MutableData
import com.google.firebase.database.Transaction
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.repositories.AppMetaRepository

class AppMetaViewModel : ViewModel() {

    private val metaRepo = AppMetaRepository()

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkDailyReset(onReset: () -> Unit) {
        metaRepo.checkNewDay {
            onReset()
        }
    }
    private fun resetStockData(ref: DatabaseReference){
        ref.runTransaction(object : Transaction.Handler {
            override fun doTransaction(data: MutableData): Transaction.Result {
                val stock = data.getValue(FullsStock::class.java)
                    ?: return Transaction.success(data)

                val closing = stock.closingStock ?: 0.0

                stock.openingStock = closing
                stock.soldToday = 0.0

                data.value = stock
                return Transaction.success(data)
            }

            override fun onComplete(
                error: DatabaseError?,
                committed: Boolean,
                currentData: DataSnapshot?
            ) {}
        })
    }

    fun resetSoldToday() {
        val repo = FirebaseRefs.Products
        repo.get().addOnSuccessListener { snapshot ->
            snapshot.children.forEach { productSnap ->
                val productId = productSnap.key ?: return@forEach

                val warehouseStock = repo
                    .child(productId)
                    .child("store")
                    .child("warehouse")

                val headOfficeStock = repo
                    .child(productId)
                    .child("store")
                    .child("headOffice")

                resetStockData(warehouseStock)
                resetStockData(headOfficeStock)

            }
        }
    }
}
```

## File: app/src/main/res/drawable/ic_launcher_background.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<vector
    android:height="108dp"
    android:width="108dp"
    android:viewportHeight="108"
    android:viewportWidth="108"
    xmlns:android="http://schemas.android.com/apk/res/android">
    <path android:fillColor="#3DDC84"
          android:pathData="M0,0h108v108h-108z"/>
    <path android:fillColor="#00000000" android:pathData="M9,0L9,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,0L19,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M29,0L29,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M39,0L39,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M49,0L49,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M59,0L59,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M69,0L69,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M79,0L79,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M89,0L89,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M99,0L99,108"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,9L108,9"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,19L108,19"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,29L108,29"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,39L108,39"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,49L108,49"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,59L108,59"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,69L108,69"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,79L108,79"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,89L108,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M0,99L108,99"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,29L89,29"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,39L89,39"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,49L89,49"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,59L89,59"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,69L89,69"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M19,79L89,79"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M29,19L29,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M39,19L39,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M49,19L49,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M59,19L59,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M69,19L69,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
    <path android:fillColor="#00000000" android:pathData="M79,19L79,89"
          android:strokeColor="#33FFFFFF" android:strokeWidth="0.8"/>
</vector>
```

## File: app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background"/>
    <foreground android:drawable="@mipmap/ic_launcher_foreground"/>
</adaptive-icon>
```

## File: app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background"/>
    <foreground android:drawable="@mipmap/ic_launcher_foreground"/>
</adaptive-icon>
```

## File: build.gradle.kts
```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}
```

## File: gradle/wrapper/gradle-wrapper.properties
```
#Tue Sep 23 21:00:45 WAT 2025
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=file:/C:/Users/machine/Desktop/GradleCache/.gradle/wrapper/dists/gradle-8.10.2-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
```

## File: app/src/main/java/com/guvnoh/boma/database/firebaseRefs.kt
```kotlin
package com.guvnoh.boma.database


import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseRefs {

    private val db = FirebaseDatabase.getInstance()



    //database root folder
    private val root: DatabaseReference = db.reference.child("Boma")

    val Products = root.child("Products")

    val bomaEmpties = root.child("Empties")


    //val displayProductsRepo = root.child("BomaStock").child("Stock_Fulls")
    val empties = root.child("BomaStock").child("Empties")
    val records = root.child("BomaDBRecords2")
    val appMeta = root.child("appMeta")
}
```

## File: app/src/main/java/com/guvnoh/boma/functions/SendDummyData.kt
```kotlin
package com.guvnoh.boma.functions
import com.guvnoh.boma.database.FirebaseRefs

object SendDummyData {

//    private fun convertProductToProducts(product: Product, store: Store){
//        product.id?.let {
//            productId ->
//            FirebaseRefs.Products.child(productId).setValue(Products().copy(
//                name = product.name?:"error",
//                stringPrice = product.stringPrice?:"",
//                doublePrice = product.doublePrice?:0.0,
//                id = productId,
//                imageName = product.imageName?:"",
//                image = product.image?: R.drawable.bottle,
//                type = product.type?:ProductType.BOTTLE,
//                empties = product.empties,
//                store = store
//            ))
//        }
//    }
//
//    fun createNewFullsStock(wareHouse: List<Product>, headOffice: List<Product>){
//
//        wareHouse.forEach { product ->
//            val store = Store()
//            store.warehouse = product.stock
//            headOffice.forEach {
//                if (it == product){
//                    store.headOffice = it.stock
//                }
//            }
//            convertProductToProducts(product, store)
//        }
//
//
//
//    }

    fun cleardb(){
        FirebaseRefs.Products.removeValue()
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/MainActivity.kt
```kotlin
package com.guvnoh.boma


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.guvnoh.boma.ui.theme.BOMATheme
import com.guvnoh.boma.uidesigns.Boma

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BOMATheme {
                Boma()
            }
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/models/AutoScrollingText.kt
```kotlin
package com.guvnoh.boma.models

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight

@Composable
fun AutoScrollingText(
    text: String,
    modifier: Modifier,
    speed: Int = 40,

) {
    val scrollState = rememberScrollState()
    var direction by remember { mutableIntStateOf(1) }

    val textWidth = remember { mutableIntStateOf(0) }
    val containerWidth = remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier
            .clipToBounds()
            .onGloballyPositioned {
                coordinates ->
                containerWidth.intValue = coordinates.size.width
            }
    ){
        Row (
            modifier = Modifier
                .horizontalScroll(scrollState, enabled = false)
                .onGloballyPositioned {
                    coordinates ->
                    textWidth.intValue = coordinates.size.width
                }
        ){
            Text(
                text = text,
                softWrap = false,
                maxLines = 1,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
    LaunchedEffect (
        textWidth.intValue,
        containerWidth.intValue
    ){
        val textBreadth= textWidth.intValue
        val containerBreadth = containerWidth.intValue
        if (textBreadth <= containerBreadth) return@LaunchedEffect
        while (true){
            val maxScroll = (textBreadth - containerBreadth).coerceAtLeast(0)
            val next = when(direction){
                1 -> maxScroll
                -1 -> 0
                else -> 0
            }
            scrollState.animateScrollTo(
                next,
                animationSpec = tween(
                    durationMillis = (maxScroll * speed).coerceAtLeast(500),
                    easing = LinearEasing
                )
            )
            direction *= -1
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/models/Empties.kt
```kotlin
package com.guvnoh.boma.models

data class Empties (
    val company: EmptyCompany? = null,
    var emptyType: EmptyType? = null
)

enum class EmptyCompany{
    COCA_COLA,
    HERO,
    NBL,
    GUINNESS,
}

enum class EmptyType{
    TWENTY,
    TWELVE,
    TWENTY_FOUR,
    EIGHTEEN,
    SIX
}
```

## File: app/src/main/java/com/guvnoh/boma/repositories/ProductRepository.kt
```kotlin
package com.guvnoh.boma.repositories

import android.content.Context
import android.util.Log
import com.guvnoh.boma.database.FirebaseRefs
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.R
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.Products

class ProductsRepository {

    private val productsRepo = FirebaseRefs.Products

    private var listener: ValueEventListener? = null


     // Observe products in realtime
    fun observeProducts(
         repo: DatabaseReference,
        onChange: (List<Products>) -> Unit
    ) {
        listener?.let { repo.removeEventListener(it) }

        listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = snapshot.children.mapNotNull { child ->
                    child.getValue(Products::class.java)
                }
                onChange(products.filter { it.id!=null })
            }

            override fun onCancelled(error: DatabaseError) {
                // log if needed
            }
        }

        repo.addValueEventListener(listener!!)
    }


    fun getDBaseEmptiesStock(callback: (MutableList<EmptiesStock>) -> Unit) {

        FirebaseRefs.empties.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val stockList = mutableListOf<EmptiesStock>()
                for (product in snapshot.children) {
                    val stock = product.getValue(EmptiesStock::class.java)
                    if (stock!=null){
                        stockList.add(stock)
                    }
                }
                callback(stockList)
            }

            override fun onCancelled(error: DatabaseError) {
                // handle error if needed
                Log.d("DB_getDBStock_ERR", "onCancelled: $error")
            }
        })
    }



    fun getImage(context: Context, name: String):Int{
        val resId = (context.resources.getIdentifier(name,"drawable",context.packageName))
        return if(resId !=0)resId else R.drawable.bottle
    }



    // Add new product
    fun addProduct(product: Products) {
        val key = productsRepo.push().key.toString()
         product.id = key
        product.id?.let { productsRepo.child(it).setValue(product)}
    }



     // Delete product completely
    fun deleteProduct(productId: String) {
         productsRepo.child(productId).removeValue()
    }


     // Call this when ViewModel is cleared
    fun clear() {
        listener?.let { productsRepo.removeEventListener(it) }
        listener = null
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/repositories/StockRepository.kt
```kotlin
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
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Store

class StockRepository() {

    private val products = FirebaseRefs.Products
    private val emptiesRef = FirebaseRefs.empties

    private var productsListener: ValueEventListener? = null
    private var emptiesListener: ValueEventListener? = null

    // ------------------------------------------------
    // FULLS STOCK (OBSERVE)
    // ------------------------------------------------


    fun observeFullsStock(
        store: String,
        onChange: (MutableMap<String, Pair<Products, FullsStock>>) -> Unit,
    ){
        var listener = productsListener
        listener?.let { FirebaseRefs.Products.removeEventListener(it) }

        listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val products = snapshot.children.mapNotNull { child ->
                    child.getValue(Products::class.java)
                }
                val stockMap: MutableMap<String, Pair<Products,FullsStock>> = mutableMapOf()
                when (store){
                    "warehouse" -> {
                        products.forEach { product ->

                            val stock = product.store?.warehouse ?: FullsStock()
                            stockMap[product.id?:""] = Pair(product, stock)
                        }
                    }
                    "headOffice" -> {
                        products.forEach { product ->

                            val stock = product.store?.headOffice ?: FullsStock()
                            stockMap[product.id?:""] = Pair(product, stock)
                        }
                    }
                }

                onChange(stockMap)
            }

            override fun onCancelled(error: DatabaseError) = Unit
        }

        products.addValueEventListener(listener)
    }

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
        store: String
    ) {
        if (soldQty <= 0) return

        val stockRef = when(store){
            "warehouse" -> FirebaseRefs.Products.child(productId).child("store").child("warehouse")
            "headOffice" -> FirebaseRefs.Products.child(productId).child("store").child("headOffice")
            else -> FirebaseRefs.Products.child(productId).child("store").child("warehouse")
        }

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
        productsListener?.let { FirebaseRefs.Products.removeEventListener(it) }
        emptiesListener?.let { emptiesRef.removeEventListener(it) }

        productsListener = null
        emptiesListener = null
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/cards/RecordCard.kt
```kotlin
package com.guvnoh.boma.uidesigns.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.models.brandData
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.viewmodels.RecordViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecordCard(
    record: Receipt,
    navController: NavHostController,
    vm: RecordViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp) ,
        onClick = {
                vm.setCurrentRecord(record)
                navController.navigate(Screen.RecordDetails.route) {
                    launchSingleTop = true
                }
                  },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Customer name
                Text(
                    text = record.customerName?:"noName",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Date (smaller and lighter)
                Text(
                    text = record.date?:"noDATE",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                )
            }

            // Optional amount or indicator (if available in Receipt)
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "₦${"%,.2f".format(record.grandTotal?.toDoubleOrNull())}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "View Details",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun RecordsCardDemo(){
    RecordCard(
        Receipt(
            customerName = "Chukwuka",
            date = getDate(),
            soldProducts = listOf(
                SoldProduct(
                    product = brandData[0],
                    stringQuantity = "1",
                    doubleQuantity = 1.0,

                    )
            ),
        ), rememberNavController(), viewModel()
    )
}
```

## File: app/src/main/java/com/guvnoh/boma/viewmodels/productViewModel.kt
```kotlin
package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.formatters.halfAndQuarter
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.repositories.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class ProductsViewModel(
    private val repository: ProductsRepository = ProductsRepository()
) : ViewModel() {

    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products: StateFlow<List<Products>> = _products

    //customer
    private val _customerName = mutableStateOf("")
    var customerName: State<String> = _customerName

    //sold products
    private val _soldProducts = MutableStateFlow<List<SoldProduct>>(emptyList())
    val soldProducts: StateFlow<List<SoldProduct>> = _soldProducts


    init {
        observeProducts(FirebaseRefs.Products)
    }

    //get products from database

    private fun observeProducts(repo: DatabaseReference) {
        repository.observeProducts(repo) { list ->
            _products.value = list
        }
    }

    // customer name

    fun setCustomerName(name: String) {
        _customerName.value = name
    }

    //sold products management

    fun updateSoldProduct(
        product: Products,
        stringQuantity: String,
        doubleQuantity: Double
    ) {
        _soldProducts.update { list ->
            val updated = list.toMutableList()
            val index = updated.indexOfFirst { it.product?.name == product.name }

            val total = ((product.stringPrice?.toDoubleOrNull() ?: 0.0) * doubleQuantity).toInt()

            val soldProduct = SoldProduct(
                product = product,
                stringQuantity = stringQuantity,
                doubleQuantity = doubleQuantity,
                intTotal = total,
                receiptQuantity = halfAndQuarter(doubleQuantity)
            )

            if (index >= 0) {
                updated[index] = soldProduct
            } else {
                updated.add(soldProduct)
            }

            updated
        }
    }

    //generate receipt
    @RequiresApi(Build.VERSION_CODES.O)
    fun generateReceipt(): Receipt {
        val validSoldProducts = soldProducts.value.filter { (it.intTotal ?: 0) > 0 }.toList()
        //val productList by vm.products.collectAsState()
        val grandTotal = validSoldProducts.sumOf { it.intTotal ?: 0 }
        val date = getDate()
        val receipt = Receipt(
            id = FirebaseRefs.records.push().key.toString().replace("-", ""),
            soldProducts = validSoldProducts,
            customerName = customerName.value,
            date = date,
            grandTotal = grandTotal.toString()
        )
        return receipt
    }


    fun addProduct(product: Products) {
        repository.addProduct(product)
    }

    fun deleteProduct(productId: String) {
        repository.deleteProduct(productId)
    }

    fun clearTotals() {
        _soldProducts.value = emptyList()
    }

    fun clearName() {
        _customerName.value = ""
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/viewmodels/ReceiptViewmodel.kt
```kotlin
package com.guvnoh.boma.viewmodels

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReceiptViewmodel : ViewModel(){

    private val _receipt = MutableStateFlow<Receipt?>(null)
    val receipt: StateFlow<Receipt?> = _receipt



    fun setCurrentReceipt(receipt: Receipt){
        _receipt.value = receipt
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun saveSale(list: List<SoldProduct>, stockViewModel: StockViewModel, store: String){
        list.forEach { soldProduct ->
            soldProduct.doubleQuantity?.let {
                qty -> soldProduct.product?.name?.let {
                    name -> stockViewModel.sellProduct(name, qty, store)
                }
            }

        }
    }

    fun getGrandTotal(): Int{
        val total = receipt.value?.soldProducts?.sumOf {
            it.intTotal?:0
        }
        return total?:0
    }

    fun copy(receipt: Receipt, context: Context){
        val textToCopy = copyToClipboard(receipt)
        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", textToCopy)
        clipBoard.setPrimaryClip(clip)
        Toast.makeText(context, "Text copied!", Toast.LENGTH_SHORT).show()
    }

    private fun copyToClipboard(receipt: Receipt): String {
        //The variable finalText holds the complete text to be sent to the clipboard
        val finalText = StringBuilder()
        val soldProductsRaw = receipt.soldProducts?: emptyList()
        val soldProducts = soldProductsRaw.filter { it.intTotal!! >0 }.toList()
        val grandTotal = soldProducts.sumOf { it.intTotal?:0 }
        soldProducts.forEach {
            val copiedQuantity: String = it.receiptQuantity?:"0"
            val textToCopy = "$copiedQuantity ${it.product?.name} ${nairaFormat(it.intTotal?:0)}\n"

            finalText.append(textToCopy)
        }
        if (soldProducts.size > 1) {
            finalText.append("Total: $grandTotal")
        }
        return finalText.toString()
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/viewmodels/StockViewmodel.kt
```kotlin
package com.guvnoh.boma.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.repositories.StockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@RequiresApi(Build.VERSION_CODES.O)
class StockViewModel(
) : ViewModel() {

    private val _wareHouseFulls = MutableStateFlow<Map<Products, FullsStock>>(emptyMap())
    val wareHouseStock: StateFlow<Map<Products, FullsStock>> = _wareHouseFulls

    private val _headOfficeFulls = MutableStateFlow<Map<Products, FullsStock>>(emptyMap())
    val headOfficeStock: StateFlow<Map<Products, FullsStock>> = _headOfficeFulls

        //empties stock
    private val _emptiesStock = MutableStateFlow<Map<String, EmptiesStock>>(emptyMap())
    val emptiesStock: StateFlow<Map<String, EmptiesStock>> = _emptiesStock



    private val stockRepository: StockRepository = StockRepository()

    init {
        observeFullsStock("warehouse")
        observeFullsStock("headOffice")
        observeEmptiesStock()
        AppMetaViewModel().checkDailyReset {
            AppMetaViewModel().resetSoldToday()
        }
    }

//    private fun convertListToMap(list: List<Products>): Map<Products, FullsStock>{
//        val map: MutableMap<Products, FullsStock> = mutableMapOf()
//
//        list.forEach {
//            val stock = it.stock?:FullsStock()
//            map[it] = stock
//        }
//        return map
//    }

    private fun observeFullsStock(store: String) {
        stockRepository.observeFullsStock(store){ stock ->
            when(store){
                "warehouse" -> {_wareHouseFulls.value = stock.values.toMap()}
                "headOffice" -> {_headOfficeFulls.value = stock.values.toMap()}
            }
        }

    }

    private fun observeEmptiesStock() {
        stockRepository.observeEmptiesStock { map ->
            _emptiesStock.value = map
        }
    }

    fun sellProduct(productId: String, quantity: Double, store: String) {
        stockRepository.sellProduct(
            productId = productId,
            soldQty = quantity,
            store = store
        )
    }

}
```

## File: app/src/main/java/com/guvnoh/boma/functions/FetchRecords.kt
```kotlin
package com.guvnoh.boma.functions

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Receipt

fun getDatabaseRecords(callback: (MutableList<Receipt>) -> Unit) {

    FirebaseRefs.records.orderByChild("timeStamp")
        .addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val records = snapshot.children.mapNotNull {
                it.getValue(Receipt::class.java)
            }.sortedByDescending { it.timeStamp }

            callback(records.toMutableList())
        }

        override fun onCancelled(error: DatabaseError) {
            Log.d("get records error: ", "$error")
        }
    })
}
```

## File: app/src/main/java/com/guvnoh/boma/functions/PushRecord.kt
```kotlin
package com.guvnoh.boma.functions

import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.models.Receipt

fun sendRecord(record: Receipt){
    val newRef = FirebaseRefs.records.push()
    val recordMap = mapOf(
        "timeStamp" to record.timeStamp,
        "id" to record.id,
        "soldProducts" to record.soldProducts,
        "customerName" to record.customerName,
        "date" to record.date,
        "grandTotal" to record.grandTotal
    )
    newRef.setValue(recordMap)
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/cards/EmptiesStockCard.kt
```kotlin
package com.guvnoh.boma.uidesigns.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import com.guvnoh.boma.models.EmptiesStock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.halfAndQuarter
import kotlinx.coroutines.launch

@Composable
fun EmptiesStockCard(emptiesStock: EmptiesStock) {
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = { scope.launch { /* handle click */ } },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // --- Header Row ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = emptiesStock.company?.name?:"unknown",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )

                // Optional visual indicator for low stock
                val isLowStock = (emptiesStock.quantity ?: 0.0) < 25.0
                val indicatorColor = if (isLowStock)
                    MaterialTheme.colorScheme.error
                else
                    MaterialTheme.colorScheme.primary

                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(indicatorColor, CircleShape)
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                thickness = 1.dp
            )


            // --- Current Stock ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = halfAndQuarter(emptiesStock.quantity ?: 0.0),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = if ((emptiesStock.quantity ?: 0.0) <= 25.0)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.onSurface
                )
            }

            // --- Optional Footer Highlight ---
            if ((emptiesStock.quantity ?: 0.0) <= 25.0) {
                Text(
                    text = "⚠️ Low stock — restock soon",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.error
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStockCard(){
    //StockCard(Product())
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/cards/StockCard.kt
```kotlin
package com.guvnoh.boma.uidesigns.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.checkIfSoldToday
import com.guvnoh.boma.formatters.halfAndQuarter
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.brandData
import kotlinx.coroutines.launch



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockCard(name: String, stock: FullsStock) {
    val scope = rememberCoroutineScope()
    val soldToday = stock.soldToday

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = { scope.launch { /* handle click */ } },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // --- Header Row ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary
                )

                // Optional visual indicator for low stock
                val isLowStock = (stock.closingStock ?: 0.0) < 5.0
                val indicatorColor = if (isLowStock)
                    MaterialTheme.colorScheme.error
                else
                    MaterialTheme.colorScheme.primary

                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(indicatorColor, CircleShape)
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            // --- Sold Today ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Sold Today",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = halfAndQuarter(soldToday?:0.0),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // --- Current Stock ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Current Stock",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = halfAndQuarter(stock.closingStock ?: 0.0),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = if ((stock.closingStock ?: 0.0) < 5.0)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.onSurface
                )
            }

            // --- Optional Footer Highlight ---
            if ((stock.closingStock ?: 0.0) < 5.0) {
                Text(
                    text = "⚠️ Low stock — restock soon",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.error
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ShowStockCard(){
    StockCard("P",FullsStock())
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/AddSupplyDetails.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.ReceivedStock
import com.guvnoh.boma.models.brandData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateStockCard(padding: PaddingValues,product: Products){
    var quantity by remember { mutableStateOf("") }
    val source by remember { mutableStateOf("") }
    val stock = ReceivedStock(product = product, quantity = 0.0, source = source)
    var nameError by remember { mutableStateOf<String?>(null) }
    val sourceError by remember { mutableStateOf<String?>(null) }
    Scaffold(
        modifier = Modifier.padding(padding),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Add Received Stock",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = "Enter product details below",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Quantity received
                    OutlinedTextField(
                        value = quantity,
                        onValueChange = { entry ->
                            quantity = entry
                            stock.quantity = entry.toDoubleOrNull()

                            nameError = if ((quantity.toDoubleOrNull() ?: 0.0) <= 0.0) "Valid quantity is required" else null
                        },
                        label = { Text("Product Quantity") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = nameError != null,
                        singleLine = true,
                        supportingText = {
                            if (nameError != null) {
                                Text(nameError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )

                    // Supplier info
                    OutlinedTextField(
                        value = source,
                        onValueChange = { input ->
                            stock.source = input

                        },
                        label = { Text("Supplier") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = sourceError != null,
                        singleLine = true,
                        supportingText = {
                            if (sourceError != null) {
                                Text(sourceError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )


                    // Done Button
                    Button(
                        onClick = {}
//                            if (productName.isNotBlank() && productPrice.isNotBlank() && category.isNotBlank()) {
//                                databasePrices.child(newProduct.name).setValue(newProduct)
//                                navController.navigate(Screen.Products.route) {
//                                    popUpTo(navController.graph.findStartDestination().id) {
//                                        inclusive = true
//                                    }
//                                    launchSingleTop = true
//                                }
//                            } else {
//                                if (productName.isBlank()) nameError = "Name is required"
//                                if (productPrice.isBlank()) priceError = "Price is required"
//                                if (category.isBlank()) categoryError = "Category is required"
//                                Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
//                            }
//                        },
                                ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = CircleShape
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Done")
                        Spacer(Modifier.width(8.dp))
                        Text("Save Product", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowDemo(){
    UpdateStockCard(padding = PaddingValues(), product = brandData[1])
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/RecordsScreen.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.guvnoh.boma.uidesigns.cards.RecordCard
import com.guvnoh.boma.viewmodels.RecordViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecordsScreen(
    vm: RecordViewModel,
    navController: NavHostController,
    paddingValues: PaddingValues
    ){
    val records by vm.records.collectAsState()

    var date by remember { mutableStateOf("") }


    Scaffold (modifier = Modifier.padding(paddingValues)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (records.isEmpty()){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text("No Records Yet!")
                }
            }else{

                LazyColumn {
                    stickyHeader {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = date,
                                style = MaterialTheme.typography.titleLarge,
                            )
                        }

                    }
                    items(records){
                            record ->
                        date = record.date.toString()

                        RecordCard(
                            record = record,
                            navController = navController,
                            vm = vm
                        )
                    }
                }
            }
        }
    }

}
```

## File: app/src/main/java/com/guvnoh/boma/formatters/TimeFormatter.kt
```kotlin
package com.guvnoh.boma.formatters

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getDate(): String{
    val now = LocalDateTime.now()
    val date = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy")
    return now.format(date)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getTime(): String{
    val now = LocalDateTime.now()
    val time = DateTimeFormatter.ofPattern("HH:mm:ss")
    return now.format(time)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDay(): String{
    return  LocalDateTime.now().toString()
}


@RequiresApi(Build.VERSION_CODES.O)
fun checkIfSoldToday(timeSold: String): Boolean {
    val now = LocalDateTime.now()
    val date = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy")
    val timeNow = now.format(date)

//    val todayString = "$dayOfWeek, $monthNow $dayOfMonth $yearNow"
//    val formattedReceiptTime = timeSold.replace("[, ]", "")
//    val formattedTimeToday = todayString.replace("[, ]", "")

    return (timeSold.lowercase() == timeNow.lowercase())

}
```

## File: app/src/main/java/com/guvnoh/boma/models/FullsStock.kt
```kotlin
package com.guvnoh.boma.models

import com.guvnoh.boma.formatters.getDate

data class FullsStock(
    var openingStock: Double? = null,
    var closingStock: Double? = null,
    val depletion: Double? = null,
    var lastTimeSold: String? = null,
    var soldLast: Double? = null,
    var soldToday: Double? = null,
    var receivedStock: ReceivedStock? = null,
)

data class Store(
    var warehouse: FullsStock? = null,
    var headOffice: FullsStock? = null
)

data class ReceivedStock(
    val date: String? = null,
    val product: Products? = null,
    var quantity: Double? = null,
    var source: String? = null
)

data class Return(
    val product: Products? = null,
    var quantity: Double? = null,
    var type: ReturnType? = null
)
enum class ReturnType{
    COMPANY,
    CUSTOMER
}


data class EmptiesStock(
    var emptyType: EmptyType? = null,
    var company: EmptyCompany? = null,
    var quantity: Double? = null,
)
```

## File: app/src/main/java/com/guvnoh/boma/models/SplashScreen.kt
```kotlin
package com.guvnoh.boma.models

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text

@Composable
fun StockSplashScreen(
    modifier: Modifier,
    onTimeOut: () -> Unit,
    stock: MutableList<FullsStock>? = null,
    empties: MutableList<EmptiesStock>? = null,
){
    Box (
        modifier = modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        if (stock!=null){
            LaunchedEffect(stock) {
                if (stock.isNotEmpty()){
                    onTimeOut()
                }

            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Loading...",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                CircularProgressIndicator()
            }
        }else{
            if (empties!=null){
                LaunchedEffect(empties) {
                    if (empties.isNotEmpty()){
                        onTimeOut()
                    }

                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Loading...",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun ProductSplashScreen(
    modifier: Modifier,
    onTimeOut: () -> Unit,
    list: MutableList<Products>,
){
    Box (
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LaunchedEffect(list) {
            if (list.isNotEmpty()){
                onTimeOut()
            }
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Loading...",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            CircularProgressIndicator()
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/navigation/StockPageNavigation.kt
```kotlin
package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.uidesigns.screens.stock.BottomBarItem
import com.guvnoh.boma.uidesigns.screens.stock.StockEmptiesScreen
import com.guvnoh.boma.uidesigns.screens.stock.StockFullsScreen
import com.guvnoh.boma.viewmodels.StockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StockPageNav(
    vm: StockViewModel,
    paddingValues: PaddingValues
){
    val navController = rememberNavController()

    NavHost(
        startDestination = BottomBarItem.Fulls.route,
        navController = navController
    ){
        composable(BottomBarItem.Empties.route){ StockEmptiesScreen(paddingValues, vm, navController) }
        composable(BottomBarItem.Fulls.route){
            StockFullsScreen(
                paddingValues = paddingValues,
                stockViewModel = vm,
                navController = navController
            ) }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/cards/SwipableProductCard.kt
```kotlin
package com.guvnoh.boma.uidesigns.cards

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.guvnoh.boma.models.Products
import kotlinx.coroutines.launch
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.vibratePhone
import com.guvnoh.boma.repositories.ProductsRepository
import com.guvnoh.boma.viewmodels.ProductsViewModel
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun SwipeableProductCard(
    product: Products,
    navController: NavController,
    productsViewModel: ProductsViewModel,
) {
    val scope = rememberCoroutineScope()
    val alert = remember { mutableStateOf(false) }

    // Swipeable state
    val swipeableState = rememberSwipeableState(initialValue = 0)

    val width = 300f // adjust to card width in pixels
    val anchors = mapOf(
        0f to 0,               // resting position
        width * 0.3f to 1      // 30% swipe triggers
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.Transparent)
    ) {
        // Background with trash can
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.CenterStart,

        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.Red,
                modifier = Modifier.size(50.dp)
            )
        }

        // Foreground card
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.5f) },
                    orientation = Orientation.Horizontal
                )
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) },
        ) {
            DeleteProductCard(product)
        }
    }

    // When fully swiped to 30%, show alert
    LaunchedEffect(swipeableState.currentValue) {
        if (swipeableState.currentValue == 1) {

            scope.launch {
                // Reset card back after swipe
                swipeableState.animateTo(0)
                alert.value = true

            }
        }
    }

    if (alert.value) {
        val context = LocalContext.current
        vibratePhone(context)
        AlertDialogg(
            onDelete = {
                productsViewModel.deleteProduct(product.id?:"")
                       },
            product = product,
            alert = alert,
            navController = navController
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogg(
    onDelete: (Products) -> Unit,
    product: Products,
    alert: MutableState<Boolean>,
    navController: NavController){
    if (alert.value){
        BasicAlertDialog(
            onDismissRequest = {},
        ){
            Surface(
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation,
            ){
                Column (
                    modifier = Modifier.padding(24.dp)
                ){
                    Text(
                        text = "Delete product?",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Are you sure you want to delete this product?",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Row (
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = {alert.value = false}) {
                            Text(text = "Cancel")

                        }
                        TextButton(onClick = {
                            onDelete(product)
                        alert.value = false}) {
                            Text(text = "Continue")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun DeleteProductCard(
    product: Products
) {

    val context = LocalContext.current
    val resId =
        ProductsRepository().getImage(context,product.imageName?:"bottle.jpg")

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 🖼 Product Image with gradient ring
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                                MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(resId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
            }

            // 📋 Product Details
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = product.name?:"unknown",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = nairaFormat(product.stringPrice?.toInt()?:0),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/DeleteProduct.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Icon
import com.guvnoh.boma.uidesigns.cards.SwipeableProductCard
import com.guvnoh.boma.viewmodels.ProductsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteProduct(
    navController: NavController,
    paddingValues: PaddingValues,
    productsViewModel: ProductsViewModel
) {
    val productList by productsViewModel.products.collectAsState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .imePadding()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Icon(Icons.Filled.Info, "")
                    Text(
                        text = "Remove Product from Database",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )

                }
            )
        }
    ){
        innerPadding ->
        Column (Modifier.padding(innerPadding)){
            // Product List
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(productList.sortedBy { it.name }) { product ->
                    SwipeableProductCard(
                        product = product,
                        navController = navController,
                        productsViewModel
                    )
                }
            }
        }
    }
}
```

## File: gradle/libs.versions.toml
```toml
[versions]
agp = "8.8.0"
kotlin = "2.0.0"
coreKtx = "1.13.1"
junit = "4.13.2"
junitVersion = "1.3.0"
espressoCore = "3.7.0"
lifecycleRuntimeKtx = "2.9.4"
activityCompose = "1.9.2"
composeBom = "2024.04.01"
navigationCompose = "2.9.4"
googleGmsGoogleServices = "4.4.3"
firebaseDatabase = "22.0.1"
composeMaterial = "1.5.2"
ui = "1.9.4"


[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
androidx-material-icons-extended = { module = "androidx.compose.material:material-icons-extended" }
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }
firebase-database = { group = "com.google.firebase", name = "firebase-database", version.ref = "firebaseDatabase" }
androidx-compose-material = { group = "androidx.wear.compose", name = "compose-material", version.ref = "composeMaterial" }
ui = { module = "androidx.compose.ui:ui", version.ref = "ui" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
google-gms-google-services = { id = "com.google.gms.google-services", version.ref = "googleGmsGoogleServices" }
```

## File: app/src/main/java/com/guvnoh/boma/navigation/MainNavigation.kt
```kotlin
package com.guvnoh.boma.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.functions.SendDummyData
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.uidesigns.screens.AddProduct
import com.guvnoh.boma.uidesigns.screens.DeleteProduct
import com.guvnoh.boma.uidesigns.screens.priceChange.PriceChangePage
import com.guvnoh.boma.uidesigns.screens.ProductsPage
import com.guvnoh.boma.uidesigns.screens.ReceiptPage
import com.guvnoh.boma.uidesigns.screens.RecordDetails
import com.guvnoh.boma.uidesigns.screens.RecordsScreen
import com.guvnoh.boma.uidesigns.screens.priceChange.PriceChangeViewmodel
import com.guvnoh.boma.viewmodels.AppMetaViewModel
import com.guvnoh.boma.viewmodels.ProductsViewModel
import com.guvnoh.boma.viewmodels.ReceiptViewmodel
import com.guvnoh.boma.viewmodels.RecordViewModel
import com.guvnoh.boma.viewmodels.StockViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    paddingValues: PaddingValues,
    navController: NavHostController,
    ){

    val records: RecordViewModel  = viewModel()
    val record by records.record.collectAsState()
    val productsViewModel: ProductsViewModel = viewModel()
    val bomaViewModel: AppMetaViewModel = viewModel()
    val stockViewModel: StockViewModel = viewModel()
    val receiptViewmodel: ReceiptViewmodel = viewModel()
    val priceChangeViewmodel: PriceChangeViewmodel = viewModel()





    LaunchedEffect(Unit) {
        bomaViewModel.checkDailyReset{
            AppMetaViewModel().resetSoldToday()
        }
    }



    NavHost(
        startDestination = Screen.Products.route,
        navController = navController

    ){
        composable(Screen.Products.route){ ProductsPage(navController, paddingValues, productsViewModel, receiptViewmodel) }
        composable(Screen.PriceChange.route){ PriceChangePage(navController, paddingValues, priceChangeViewmodel) }
        composable(Screen.Receipt.route){ ReceiptPage(stockViewModel, receiptViewmodel) }
        composable(Screen.AddProduct.route){ AddProduct(paddingValues, navController, productsViewModel) }
        composable(Screen.DeleteProduct.route){ DeleteProduct(navController, paddingValues, productsViewModel) }
        composable(Screen.Stock.route){ StockPageNav(vm = stockViewModel, paddingValues = paddingValues) }
        composable(Screen.WarehouseStock.route){ StockPageNav(vm = stockViewModel, paddingValues = paddingValues) }
        composable(Screen.Records.route){ RecordsScreen(records, navController, paddingValues) }
        composable(Screen.RecordDetails.route){
            record?.let { selectedRecord -> RecordDetails(selectedRecord) }
        }
    }

}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/cards/ProductCard.kt
```kotlin
package com.guvnoh.boma.uidesigns.cards

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.AutoScrollingText
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.repositories.ProductsRepository
import com.guvnoh.boma.viewmodels.ProductsViewModel

@Composable
fun ProductCard(
    product: Products,
    viewModel: ProductsViewModel,
) {
    val soldProducts = viewModel.soldProducts.collectAsState()

    val soldProduct = soldProducts.value.find { it.product?.name == product.name }

    val quantity = soldProduct?.stringQuantity?:""

    val total = soldProduct?.intTotal?:0

    val stock = product.store?.warehouse?.closingStock?:0.0

    val enabled: Boolean by remember { mutableStateOf((stock > 0)) }

    val context = LocalContext.current
    val resId = ProductsRepository().getImage(context,product.imageName?:"bottle.jpg")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = if (enabled){
            CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        }else{
            CardDefaults.cardColors(containerColor = Color.LightGray)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 🖼 Product Image with gradient ring
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                                MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(resId),
                    contentDescription = product.name,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
            }

            // 📋 Product Details
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                AutoScrollingText(product.name?:"unknown", modifier = Modifier)

                Text(
                    text = nairaFormat(product.stringPrice?.toInt()?:0),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                )

                if (!enabled) {
                    Text( text = "⚠️out of stock!",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 14.sp
                        )
                    )
                }

                //TOTAL
                Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End){
                    // 🧮 Show Total if available
                    AnimatedVisibility(
                        visible = total > 0,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Text(
                            text = nairaFormat(total),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF2E7D32) // deep green
                            )
                        )
                    }
                }
            }

            // 🔢 Quantity Input
            if (enabled){
                OutlinedTextField(
                    value = quantity,
                    onValueChange = { newValue ->
                        val input = newValue.toDoubleOrNull()?:0.0

                        viewModel.updateSoldProduct(
                            product = product,
                            stringQuantity = newValue,
                            doubleQuantity = input
                        )
                    },
                    label = { Text("Qty") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(90.dp),
                    shape = RoundedCornerShape(12.dp)
                )
            }
        }
    }
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/RecordDetailsScreen.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.captureScreen
import com.guvnoh.boma.functions.saveBitmapToGallery
import com.guvnoh.boma.functions.vibratePhone
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordDetails(receipt: Receipt) {
    val context = LocalContext.current
    val view = LocalView.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Record", style = MaterialTheme.typography.titleLarge) }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {receipt.soldProducts?.let{ copy(it, context) }}) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                Button(onClick = {
                    vibratePhone(context, 100L)
                    saveBitmapToGallery(context, captureScreen(view))
                } ){
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header Info
            Text("Receipt #${receipt.id}", style = MaterialTheme.typography.titleMedium)
            Text("Customer: ${receipt.customerName}", style = MaterialTheme.typography.bodyLarge)
            Text("Date: ${(receipt.date?:"error")}", style = MaterialTheme.typography.bodyMedium)

            Spacer(Modifier.height(16.dp))

            // Products List (scrollable)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    receipt.soldProducts?.let {
                        items(it) { product ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    product.receiptQuantity?:"0",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    product.product?.name?:"unknown",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(nairaFormat(product.intTotal?:0), fontWeight = FontWeight.Bold)
                            }
                            HorizontalDivider()
                        }
                    }
                }
            }

            // Total Section
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Grand Total", style = MaterialTheme.typography.titleMedium)
                val grandTotal = receipt.soldProducts?.let {
                    soldProducts ->
                    nairaFormat(soldProducts.sumOf { it.intTotal?:0 })
                }
                Text(
                    text = grandTotal?:"0.00",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun RecordCardDetailsDemo() {

    val sampleProducts = listOf(
        SoldProduct().apply {
            receiptQuantity = "2"
            intTotal = 1200
            product = Products()
            product?.name = "Toothpaste"
        },
        SoldProduct().apply {
            receiptQuantity = "1"
            intTotal = 800
            product = Products()
            product?.name = "Soap"
        }
    )

    RecordDetails(
        receipt = Receipt(
            id = "001",
            customerName = "John Doe",
            date = "Thu, Oct 30 2025",
            soldProducts = sampleProducts
        )
    )
}

// --- Clipboard copy helpers ---

private fun copy(list: List<SoldProduct>, context: Context) {
    val textToCopy = copyToClipboard(list)
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Receipt", textToCopy)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(context, "Receipt copied!", Toast.LENGTH_SHORT).show()
}

fun copyToClipboard(list: List<SoldProduct>): String {
    val builder = StringBuilder()
    val grandTotal = nairaFormat(list.sumOf { it.intTotal?:0 })

    list.forEach {
        builder.append("${it.receiptQuantity} ${it.product?.name} ${nairaFormat(it.intTotal?:0)}\n")
    }

    if (list.isNotEmpty()) builder.append("Total: $grandTotal")
    return builder.toString()
}
```

## File: app/build.gradle.kts
```kotlin
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.guvnoh.boma"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.guvnoh.boma"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.ui) // or your Compose version



    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose )
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.database)
    implementation(libs.androidx.compose.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/AddProductPage.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Empties
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.EmptyType
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.viewmodels.ProductsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProduct(padding: PaddingValues,
               navController: NavController,
               productsViewModel: ProductsViewModel) {

    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    val noOfBottles by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var isBottleProduct by remember { mutableStateOf(false) }

    val context = LocalContext.current


    var nameError by remember { mutableStateOf<String?>(null) }
    var priceError by remember { mutableStateOf<String?>(null) }
    var categoryError by remember { mutableStateOf<String?>(null) }

    val sortCategories = listOf(
        "COCACOLA", "HERO", "NBL", "GUINNESS", "PETS", "CANS", "OTHER"
    )

    val newProduct = Products()

    Scaffold(
        modifier = Modifier.padding(padding),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Add Product",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = "Enter product details below",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Product Name
                    OutlinedTextField(
                        value = productName,
                        onValueChange = { name ->
                            productName = name
                            newProduct.name = name
                            nameError = if (name.isBlank()) "Name is required" else null
                        },
                        label = { Text("Product Name") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = nameError != null,
                        singleLine = true,
                        supportingText = {
                            if (nameError != null) {
                                Text(nameError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )

                    // Product Price
                    OutlinedTextField(
                        value = productPrice,
                        onValueChange = { input ->
                            productPrice = input.filter { it.isDigit() || it == '.' }
                            newProduct.stringPrice = productPrice
                            newProduct.doublePrice = productPrice.toDoubleOrNull() ?: 0.0
                            priceError = if (productPrice.isBlank()) "Price is required" else null
                        },
                        label = { Text("Product Price (₦)") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = priceError != null,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        supportingText = {
                            if (priceError != null) {
                                Text(priceError!!, color = MaterialTheme.colorScheme.error)
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )

                    // Category Dropdown
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = category,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Category") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                            },
                            isError = categoryError != null,
                            supportingText = {
                                if (categoryError != null) {
                                    Text(categoryError!!, color = MaterialTheme.colorScheme.error)
                                }
                            },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            sortCategories.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        category = option
                                        expanded = false
                                        when (option) {
                                            "COCACOLA" -> {
                                                newProduct.empties = Empties(EmptyCompany.COCA_COLA)
                                                isBottleProduct = true
                                            }
                                            "HERO" -> {
                                                newProduct.empties = Empties(EmptyCompany.HERO)
                                                isBottleProduct = true
                                            }
                                            "NBL" -> {
                                                newProduct.empties = Empties(EmptyCompany.NBL)
                                                isBottleProduct = true
                                            }
                                            "GUINNESS" -> {
                                                newProduct.empties = Empties(EmptyCompany.GUINNESS)
                                                isBottleProduct = true
                                            }
                                            else -> {isBottleProduct = false}
                                        }
                                        categoryError = null
                                    }
                                )
                            }
                        }
                    }


                    if (isBottleProduct){
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded }
                        ) {
                            OutlinedTextField(
                                value = category,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Empty Type") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                isError = categoryError != null,
                                supportingText = {
                                    if (categoryError != null) {
                                        Text(categoryError!!, color = MaterialTheme.colorScheme.error)
                                    }
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp)
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                noOfBottles.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option.toString()) },
                                        onClick = {
                                            expanded = false

                                            //no of bottles
                                            newProduct.empties?.emptyType = when(option.toString()){
                                                "12" -> EmptyType.TWELVE
                                                "18" -> EmptyType.EIGHTEEN
                                                "20" -> EmptyType.TWENTY
                                                "24" -> EmptyType.TWENTY_FOUR
                                                else -> EmptyType.TWELVE

                                            }

                                            categoryError = null
                                        }
                                    )
                                }
                            }
                        }

                    }

                    // Done Button
                    Button(
                        onClick = {
                            if (productName.isNotBlank()
                                && productPrice.isNotBlank()
                                && category.isNotBlank()
                                && isBottleProduct) {
                                newProduct.type = ProductType.BOTTLE
                                productsViewModel.addProduct(newProduct)
                                navController.navigate(Screen.Products.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        inclusive = true
                                    }
                                    launchSingleTop = true
                                }
                            } else {
                                if (productName.isBlank()) nameError = "Name is required"
                                if (productPrice.isBlank()) priceError = "Price is required"
                                if (category.isBlank()) categoryError = "Category is required"
                                Toast.makeText(context, "Incomplete product details!", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        shape = CircleShape
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Done")
                        Spacer(Modifier.width(8.dp))
                        Text("Save Product", style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowAddScreen(){
    val pvm: ProductsViewModel = viewModel()
    AddProduct(PaddingValues(5.dp), rememberNavController(), pvm)
}
```

## File: app/src/main/java/com/guvnoh/boma/models/Product.kt
```kotlin
package com.guvnoh.boma.models

import com.guvnoh.boma.R

//data class Product (
//    var name: String? = null,
//    var stringPrice: String? = null,
//    var imageName: String? = null,
//    var image: Int = R.drawable.bottle,
//    var id: String? = null,
//    var doublePrice: Double? = null,
//    var stock: FullsStock? = null,
//    var type: ProductType? = null,
//    var empties: Empties? = null
//
//)

data class Products (
    var name: String? = null,
    var stringPrice: String? = null,
    var imageName: String? = null,
    var image: Int = R.drawable.bottle,
    var id: String? = null,
    var doublePrice: Double? = null,
    var store: Store? = null,
    var type: ProductType? = null,
    var empties: Empties? = null

)

enum class ProductType(){
    BOTTLE,
    PET,
    CAN
}

data class SoldProduct(
    var product: Products? = null,
    var stringQuantity: String? = null,
    var doubleQuantity: Double? = null,
    var receiptQuantity: String? = null,
    var intTotal: Int? = null,
)

data class Receipt(
    val timeStamp: Long? = null,
    var id: String? = null,
    var soldProducts: List<SoldProduct>? = null,
    var customerName: String? = null,
    var date: String? = null,
    var grandTotal: String? = null
)

val brandData = mutableListOf(
    //coca cola
    Products(name = "50cl", stringPrice = "6300", imageName = "coke", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.COCA_COLA, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "35cl", stringPrice = "3800", imageName = "coke", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.COCA_COLA, emptyType = EmptyType.TWENTY_FOUR)),

    //Hero
    Products(name = "Hero", stringPrice = "8500", imageName = "hero", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Budweiser", stringPrice = "10000", imageName = "budweiser", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Castle Lite", stringPrice = "9500", imageName = "castle_lite", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Flying fish", stringPrice = "13000", imageName = "fish", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWENTY)),
    Products(name = "Trophy", stringPrice = "8500", imageName = "trophy", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),
    Products(name = "Trophy Stout", stringPrice = "9500", imageName = "trophy_stout", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.HERO, emptyType = EmptyType.TWELVE)),

    //NBL
    Products(name = "Amstel", stringPrice =  "13000", imageName = "amstel", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "Desperados", stringPrice = "16600", imageName = "despy", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Products(name = "Gulder", stringPrice = "10800", imageName = "gulder", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Heineken", stringPrice = "11900", imageName = "heineken", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Legend(big)", stringPrice = "11200", imageName = "legend", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Life", stringPrice = "9200", imageName = "life", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Maltina", stringPrice = "13000", imageName = "maltina", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "Radler", stringPrice = "13000", imageName = "radler", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Products(name = "Star", stringPrice = "10500", imageName = "star", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWELVE)),
    Products(name = "Tiger", stringPrice = "15000", imageName = "tiger", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),
    Products(name = "Medium Heineken", stringPrice = "17000", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.NBL, emptyType = EmptyType.TWENTY)),

    //Guinness
    Products(name = "Medium stout", stringPrice = "17000", imageName = "guinness", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.EIGHTEEN)),
    Products(name = "Small stout", stringPrice = "19000", imageName = "guinness", type = ProductType.BOTTLE, empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.TWENTY_FOUR)),
    Products(name = "Orijin", stringPrice = "9500", imageName = "orijin", type = ProductType.BOTTLE,empties = Empties(company = EmptyCompany.GUINNESS, emptyType = EmptyType.TWELVE)),

    //Cans
    Products(name = "Beta Malt", stringPrice = "10500", imageName = "beta_malt", type = ProductType.CAN),
    Products(name = "Grand Malt", stringPrice = "10700", imageName = "grand_malt", type = ProductType.CAN),
    Products(name = "Amstel can", stringPrice = "12500", imageName = "amstel", type = ProductType.CAN),
    Products(name = "Life can", stringPrice = "15000", imageName = "life", type = ProductType.CAN),
    Products(name = "Star can", stringPrice = "12000", imageName = "star", type = ProductType.CAN),
    Products(name = "Hero can", stringPrice = "10500", imageName = "hero", type = ProductType.CAN),
    Products(name = "Trophy can", stringPrice = "10500", imageName = "trophy", type = ProductType.CAN),
    Products(name = "Heineken can", stringPrice = "15500", imageName = "heineken", type = ProductType.CAN),
    Products(name = "Guinness can", stringPrice = "25000", imageName = "guinness", type = ProductType.CAN),

    //Pets
    Products(name = "Bigger boy", stringPrice = "4600", imageName = "coke", type = ProductType.PET),
    Products(name = "Predator", stringPrice = "5400", imageName = "predator", type = ProductType.PET),
    Products(name = "Fearless", stringPrice = "5000", imageName = "fearless", type = ProductType.PET),
    Products(name = "Eva water (Big)", stringPrice =  "3900", imageName = "eva", type = ProductType.PET),
    Products(name = "Eva water (75cl)", stringPrice = "2900", imageName = "eva", type = ProductType.PET),
    Products(name = "Rex water (75cl)", stringPrice = "2900", type = ProductType.PET),
    Products(name = "zenee water", stringPrice = "1700", type = ProductType.PET),
    Products(name = "Aquafina", stringPrice = "2400", imageName = "aquafina", type = ProductType.PET),
    Products(name = "Nutri Milk", stringPrice = "6400", imageName = "nutri_milk", type = ProductType.PET),
    Products(name = "Nutri Choco", stringPrice = "7000", imageName = "nutri_choco", type = ProductType.PET),
    Products(name = "Nutri Yo", stringPrice = "7000", imageName = "nutri_yo", type = ProductType.PET),
    Products(name = "Pop cola (big)", stringPrice = "3600", imageName = "pop_cola", type = ProductType.PET),
    Products(name = "Pop cola (small)", stringPrice = "2600", imageName = "pop_cola", type = ProductType.PET),
    Products(name = "Pepsi", stringPrice = "4500", imageName = "pepsi", type = ProductType.PET),
)
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/ProductsPage.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.ProductSplashScreen
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.uidesigns.cards.ProductCard
import com.guvnoh.boma.viewmodels.ProductsViewModel
import com.guvnoh.boma.viewmodels.ReceiptViewmodel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsPage(
    navController: NavController,
    paddingValues: PaddingValues,
    vm: ProductsViewModel,
    receiptViewmodel: ReceiptViewmodel
) {

    var search: Boolean by rememberSaveable { mutableStateOf(false) }
    var searchEntry by rememberSaveable { mutableStateOf("") }
    val soldProducts by vm.soldProducts.collectAsState()
    val customerName by vm.customerName
    val productList by vm.products.collectAsState()
    val grandTotal = soldProducts.sumOf { it.intTotal?:0 }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    //vm.confirmSoldToday(productList)
    //sendFullsDataToDB()

    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .imePadding()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        "New Order",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    )
                },
                actions = {
                    IconButton(
                        onClick = { search = !search },
                        ) {
                        if (!search) Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    if (search){
                        OutlinedTextField(
                            value = searchEntry,
                            onValueChange = {
                                    entry ->
                                searchEntry = entry
                            },
                            label = { Text("Search products...") },
                            modifier = Modifier
                                .padding(start = 8.dp, bottom = 5.dp)
                                .width(200.dp)
                        )
                    }

                }
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 4.dp,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Clear Button
                    OutlinedButton(
                        onClick = {
                            if (searchEntry!="") {
                                search = !search
                                searchEntry = ""
                            }
                            //search text field is replaced by search icon
                            vm.clearTotals()
                            vm.clearName()
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear")
                        Spacer(Modifier.width(6.dp))
                        Text("Clear")
                    }

                    // Grand Total
                    if (grandTotal > 0) {
                        Text(
                            nairaFormat(grandTotal),
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.ExtraBold
                            ),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    // Done Button
                    Button(
                        onClick = {

                            searchEntry = ""
                            navController.navigate(Screen.Receipt.route)
                            val receipt = vm.generateReceipt()
                            receiptViewmodel.setCurrentReceipt(receipt)

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Icon(Icons.Filled.Done, contentDescription = "Done")
                        Spacer(Modifier.width(6.dp))
                        Text("Done")
                    }
                }
            }
        }
    ) { innerPadding ->
        var showSplash by remember { mutableStateOf(true) }
        if (showSplash){
            ProductSplashScreen(
                modifier = Modifier,
                list = productList.toMutableList(),
                onTimeOut = {showSplash = false}
            )
        }else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Customer Name
                OutlinedTextField(
                    value = customerName,
                    onValueChange = {
                        vm.setCustomerName(it)
                                    },
                    label = { Text("Customer Name") },
                    leadingIcon = { Icon(Icons.Filled.AccountCircle, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                // Product List
                if (!search) {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        val bottlesDisplay: MutableList<Products> = mutableListOf()
                        val  unsortedBottles = productList.filter {
                                it.type == ProductType.BOTTLE }
                        unsortedBottles.forEach {
                                bottlesDisplay.add(it)
                        }

                        val petsDisplay: MutableList<Products> = mutableListOf()
                        val  unsortedPets = productList.filter {
                            it.type == ProductType.PET }
                        unsortedPets.forEach {
                            petsDisplay.add(it)
                        }
                        val cansDisplay: MutableList<Products> = mutableListOf()
                        val  unsortedCans = productList.filter {
                            it.type == ProductType.CAN }
                        unsortedCans.forEach {
                            cansDisplay.add(it)
                        }



                        val coca_colaGroup = getDisplayGroup(bottlesDisplay,EmptyCompany.COCA_COLA)

                        stickyHeader {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .background(color = Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Coca_cola",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        items(coca_colaGroup.sortedBy {it.name}){ product ->

                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }

                        val heroGroup = getDisplayGroup(bottlesDisplay, EmptyCompany.HERO)

                        stickyHeader {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .background(color = Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "International Breweries",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            }
                        }
                        items(heroGroup.sortedBy { it.name }) { product ->

                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }

                        val nblGroup =  getDisplayGroup(bottlesDisplay, EmptyCompany.NBL)
                        stickyHeader {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .background(color = Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = "Nigerian Breweries",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            }
                        }
                        items(nblGroup.sortedBy { it.name }) { product ->

                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }

                        val guinnessGroup = getDisplayGroup(bottlesDisplay, EmptyCompany.GUINNESS)
                        stickyHeader {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .background(color = Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = "Guinness",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                )

                            }
                        }
                        items(guinnessGroup.sortedBy { it.name }) { product ->
                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }

                        //pets
                        stickyHeader {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .background(color = Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Pets",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            }
                        }
                        items(petsDisplay.sortedBy { it.name }) { product ->

                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }


                        //cans
                        stickyHeader {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .background(color = Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Cans",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.ExtraBold,
                                    )
                            }
                        }
                        items(cansDisplay.sortedBy { it.name }) { product ->

                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }
                    }
                } else {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        val newList = mutableListOf<Products>()
                        productList.forEach {
                            if (it.name?.lowercase()?.contains(searchEntry) == true) {
                                newList.add(it)
                            }
                        }
                        items(newList.sortedBy { it.name}) { product ->
                            ProductCard(
                                product = product,
                                viewModel = vm,
                            )
                        }
                    }
                }
            }
        }
    }
}


fun getDisplayGroup(list: List<Products>, emptyCompany: EmptyCompany): List<Products>{
    val group = mutableListOf<Products>()
    list.forEach {
        if (it.type == ProductType.BOTTLE && it.empties?.company == emptyCompany)
            group.add(it)
    }

    return group

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowProducts() {
   // ProductsPage(rememberNavController(), PaddingValues(), viewModel())
}
```

## File: app/src/main/java/com/guvnoh/boma/uidesigns/screens/Receipt.kt
```kotlin
package com.guvnoh.boma.uidesigns.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.database.DatabaseReference
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.getTime
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.functions.captureScreen
import com.guvnoh.boma.functions.saveBitmapToGallery
import com.guvnoh.boma.functions.sendRecord
import com.guvnoh.boma.functions.vibratePhone
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.repositories.ProductsRepository
import com.guvnoh.boma.repositories.StockRepository
import com.guvnoh.boma.viewmodels.ProductsViewModel
import com.guvnoh.boma.viewmodels.ReceiptViewmodel
import com.guvnoh.boma.viewmodels.StockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptPage( stockViewModel: StockViewModel, receiptViewmodel: ReceiptViewmodel) {
    val context = LocalContext.current
    val receipt by receiptViewmodel.receipt.collectAsState()

    var activeRepo = "warehouse"



//    val grandTotal = receipt?.let {
//        it.soldProducts?.sumOf {
//            product -> product.intTotal?:0
//        }?.let {
//            productIntTotal -> nairaFormat(productIntTotal)
//        }
//    }
    val view = LocalView.current
    val setRepo = remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Receipt", style = MaterialTheme.typography.titleLarge) }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                //copy button
                Button(onClick = {
                    val nonNullReceipt = receipt?:Receipt()
                    receiptViewmodel.copy(nonNullReceipt, context)
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Copy")
                    Spacer(Modifier.width(6.dp))
                    Text("Copy")
                }
                //screenshot button
                Button(onClick = {
                    vibratePhone(context, 100L)
                    saveBitmapToGallery(context, captureScreen(view))
                }) {
                    Icon(Icons.Filled.Share, contentDescription = "Screenshot")
                    Spacer(Modifier.width(6.dp))
                    Text("Screenshot")
                }
                //save button
                Button(
                    onClick = {
                        //trigger set repo alert dialog
                        setRepo.value = true
                        //productsViewModel.(soldProducts)
                        receiptViewmodel.saveSale(
                            receipt?.soldProducts!!,
                            stockViewModel,
                            activeRepo)
                        receipt?.let { sendRecord(it) }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Icon(Icons.Filled.CheckCircle, contentDescription = "Save")
                    Spacer(Modifier.width(6.dp))
                    Text("Save")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header Info

            Text("${receipt?.customerName}", style = MaterialTheme.typography.titleMedium)
            Text("Receipt No. ${receipt?.id}", style = MaterialTheme.typography.bodyMedium)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text("Date: ${receipt?.date}", style = MaterialTheme.typography.bodyMedium)
                Text("Time: ${getTime()}", style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(Modifier.height(16.dp))

            // Products List
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                receipt?.let {
                    items(it.soldProducts?: emptyList()) { soldProduct ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            //qty of item sold (display)
                            Text(
                                soldProduct.receiptQuantity?:"0",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            //name of item sold (display)
                            Text(
                                soldProduct.product?.name?:"unknown",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(nairaFormat(soldProduct.intTotal?:0), fontWeight = FontWeight.Bold)
                        }
                        HorizontalDivider()
                    }
                }
            }

            // Total Section
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Grand Total", style = MaterialTheme.typography.titleMedium)
                Text(
                    nairaFormat(receiptViewmodel.getGrandTotal()),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }
        if (setRepo.value){
            RepoAlertDialog(
                alert = setRepo,
                soldProducts = receipt?.soldProducts?: emptyList(),
                onSave = {activeRepo = it},
                context = context,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoAlertDialog(
    context: Context,
    alert: MutableState<Boolean>,
    soldProducts: List<SoldProduct>,
    onSave: (store: String)-> Unit,
){
    BasicAlertDialog(
        onDismissRequest = {alert.value = false},
        properties = DialogProperties(dismissOnClickOutside = true, dismissOnBackPress = true)
    ) {
        Surface(
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation,
        ){
            Column (
                modifier = Modifier.padding(24.dp)
            ){
                Text(
                    text = "Save sale?",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Choose stock to sell from",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = {
                        onSave("headOffice")
                        soldProducts.forEach { soldProduct ->

                            StockRepository().sellProduct(
                                productId = soldProduct.product?.id ?: "no id found for sold product",
                                soldQty = soldProduct.doubleQuantity ?: 0.0,
                                store = "headOffice"
                            )
                        }
                        alert.value = false
                        Toast.makeText(context, "Head Office Sale recorded!", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "HeadOffice")
                    }

                    TextButton(onClick = {
                        onSave("warehouse")
                        soldProducts.forEach { soldProduct ->

                            StockRepository().sellProduct(
                                soldProduct.product?.id?:"no id found for sold product",
                                soldProduct.doubleQuantity?:0.0,
                                store = "warehouse"
                            )
                        }
                        alert.value = false
                        Toast.makeText(context, "Warehouse Sale recorded!", Toast.LENGTH_SHORT).show()
                    }){
                        Text(text = "Warehouse")
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ReceiptPagePreview() {
    val stockvm : StockViewModel = viewModel()
    val rvm : ReceiptViewmodel = viewModel()
    ReceiptPage(
        stockvm,
        rvm
    )
}
```
