
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.database.bomaStock
import com.guvnoh.boma.formatters.getDate
import com.guvnoh.boma.formatters.getTime
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.BomaViewModel
import com.guvnoh.boma.models.EmptiesStock
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.FullsStock
import com.guvnoh.boma.models.NoOfBottles
import com.guvnoh.boma.models.ProductSplashScreen
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.models.SoldProduct
import com.guvnoh.boma.models.brandData
import com.guvnoh.boma.navigation.Screen
import com.guvnoh.boma.uidesigns.cards.ProductCard

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsPage(
    navController: NavController,
    paddingValues: PaddingValues,
    vm: BomaViewModel
) {

    var search: Boolean by rememberSaveable { mutableStateOf(false) }
    var searchEntry by rememberSaveable { mutableStateOf("") }
    val soldProducts by vm.soldProducts.collectAsState()
    val customerName by vm.customerName
    val productList by vm.products.collectAsState()
    val grandTotal = soldProducts.sumOf { it.intTotal?:0 }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior( )

    vm.confirmSoldToday(productList)
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
                            generateReceipt(vm,soldProducts)
                            vm.setCurrentReceipt(generateReceipt(vm,soldProducts))

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
                        vm.updateCustomerName(it)
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
                        val bottlesDisplay: MutableList<Product> = mutableListOf()
                        val  unsortedBottles = productList.filter {
                                it.type == ProductType.BOTTLE }
                        unsortedBottles.forEach {
                                bottlesDisplay.add(it)
                        }

                        val petsDisplay: MutableList<Product> = mutableListOf()
                        val  unsortedPets = productList.filter {
                            it.type == ProductType.PET }
                        unsortedPets.forEach {
                            petsDisplay.add(it)
                        }
                        val cansDisplay: MutableList<Product> = mutableListOf()
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
                                    .background(color = Color.White)
                            ) {
                                Text("Coca_cola")
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
                                    .background(color = Color.White)
                            ) {
                                Text("International Breweries")
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
                                    .background(color = Color.White)
                            ) {

                                Text("Nigerian Breweries")
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
                                    .background(color = Color.White)
                            ) {

                                Text("Guinness")

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
                                    .background(color = Color.White)
                            ) {
                                Text("Pets")
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
                                    .background(color = Color.White)
                            ) {
                                Text("Cans")
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
                        val newList = mutableListOf<Product>()
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

fun sendFullsDataToDB(){
    val list = brandData

    list.forEach {
        val random1 = (20..800).random()
        val random2 = (20..800).random()
        bomaStock.child("Fulls")
            .child(it.name?:"unknown")
            .setValue(it)
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun generateReceipt(vm: BomaViewModel, soldProducts: List<SoldProduct>): Receipt{
    val customerName by vm.customerName
    val validSoldProducts = soldProducts.filter { (it.intTotal?:0)>0 }
    //val productList by vm.products.collectAsState()
    val grandTotal = validSoldProducts.sumOf { it.intTotal?:0 }
    val date = getDate()
    val time = getTime()
    val receipt = Receipt(
        soldProducts = validSoldProducts,
        customerName = customerName,
        date = date,
        grandTotal = grandTotal.toString()
    )
    return receipt
}

fun getDisplayGroup(list: List<Product>, emptyCompany: EmptyCompany): List<Product>{
    val group = mutableListOf<Product>()
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
    ProductsPage(rememberNavController(), PaddingValues(), viewModel())
}
