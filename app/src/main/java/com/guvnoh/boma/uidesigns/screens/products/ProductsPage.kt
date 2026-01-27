
package com.guvnoh.boma.uidesigns.screens.products

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import com.guvnoh.boma.R
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.ProductSplashScreen
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Products
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.uidesigns.screens.receipt.ReceiptViewmodel
import com.guvnoh.boma.uidesigns.screens.stock.Store

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
    val grandTotal = soldProducts.sumOf { it.intTotal ?: 0 }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var expanded by remember { mutableStateOf(false) }
    //val selectedStore by vm.selectedStore

    val bottlesDisplay = productList.filter { it.type == ProductType.BOTTLE }
    val petsDisplay = productList.filter { it.type == ProductType.PET }

    val  cansDisplay = productList.filter { it.type == ProductType.CAN }

    val cocacolaGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.COCA_COLA}
    val heroGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.HERO}
    val nblGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.NBL}
    val guinnessGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.GUINNESS}
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
                    val storeName = vm.selectedStore.value.name.lowercase().replace("_"," ").replaceFirstChar { it.uppercase() }
                    Text("$storeName  ⇅"
                        ,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = LocalIndication.current,
                        ){expanded = true}
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {expanded = false},
                    ) {
                        Store.entries.forEach { store ->
                            val storeNameText = store.name.lowercase().replace("_"," ").replaceFirstChar { it.uppercase() }
                            DropdownMenuItem(
                                text = { Text(storeNameText) },
                                onClick = {
                                    expanded = !expanded
                                    vm.setSelectedStore(store)
                                    vm.observeProducts(FirebaseRefs.Products)
                                }
                            )
                        }
                    }


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

                        // products are separated based on types e.g pets, cans etc
                        // bottle products are further separated based on companies i.e nbl, hero, etc

                        //COCACOLA GROUP
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

                        //COCACOLA GROUP
                        items(cocacolaGroup.sortedBy {it.name}, key = {it.id!!}){ product ->
                            val soldProduct = soldProducts.find { it.product?.id == product.id }

                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
                                viewModel = vm,
                            )
                        }

                        // HERO GROUP
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
                        // HERO GROUP
                        items(heroGroup.sortedBy { it.name }) { product ->
                            val soldProduct = soldProducts.find { it.product?.id == product.id }

                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
                                viewModel = vm,
                            )
                        }

                        //NBL GROUP
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
                        //NBL GROUP
                        items(nblGroup.sortedBy { it.name }) { product ->
                            val soldProduct = soldProducts.find { it.product?.id == product.id }

                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
                                viewModel = vm,
                            )
                        }

                        //GUINNESS GROUP
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
                        //GUINNESS GROUP
                        items(guinnessGroup.sortedBy { it.name }) { product ->
                            val soldProduct = soldProducts.find { it.product?.id == product.id }

                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
                                viewModel = vm,
                            )
                        }

                        //PETS
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
                        //PETS
                        items(petsDisplay.sortedBy { it.name }) { product ->

                            val soldProduct = soldProducts.find { it.product?.id == product.id }

                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
                                viewModel = vm,
                            )
                        }

                        //CANS
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

                        //CANS
                        items(cansDisplay.sortedBy { it.name }) { product ->

                            val soldProduct = soldProducts.find { it.product?.id == product.id }
//                            val bottleImage = R.drawable.bottle
//                            val canImage = R.drawable.can_image
//                            if (product.image == bottleImage)product.image = canImage
                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
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
                            val soldProduct = soldProducts.find { it.product?.id == product.id }
                            ProductCard(
                                product = product,
                                soldProduct = soldProduct,
                                viewModel = vm,
                            )
                        }
                    }
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ShowProducts() {
   // ProductsPage(rememberNavController(), PaddingValues(), viewModel())
}
