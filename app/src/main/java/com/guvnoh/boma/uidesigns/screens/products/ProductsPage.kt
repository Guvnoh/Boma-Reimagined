package com.guvnoh.boma.uidesigns.screens.products

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guvnoh.boma.database.FirebaseRefs
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.models.EmptyCompany
import com.guvnoh.boma.models.ProductSplashScreen
import com.guvnoh.boma.models.ProductType
import com.guvnoh.boma.models.Screen
import com.guvnoh.boma.ui.theme.BomaDimens
import com.guvnoh.boma.ui.theme.BomaColors
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
    var search by rememberSaveable { mutableStateOf(false) }
    var searchEntry by rememberSaveable { mutableStateOf("") }
    val soldProducts by vm.soldProducts.collectAsState()
    val customerName by vm.customerName
    val productList by vm.products.collectAsState()
    val grandTotal = soldProducts.sumOf { it.intTotal ?: 0 }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var expanded by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()

    val bottlesDisplay = productList.filter { it.type == ProductType.BOTTLE }
    val petsDisplay = productList.filter { it.type == ProductType.PET }
    val cansDisplay = productList.filter { it.type == ProductType.CAN }

    val cocacolaGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.COCA_COLA }
    val heroGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.HERO }
    val nblGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.NBL }
    val guinnessGroup = bottlesDisplay.filter { it.empties?.company == EmptyCompany.GUINNESS }

    val filteredProducts = if (searchEntry.isNotEmpty()) {
        productList.filter { it.name?.contains(searchEntry, ignoreCase = true) == true }
    } else null

    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PremiumTopBar(
                selectedStore = vm.selectedStore.value,
                onStoreChange = { store ->
                    vm.setSelectedStore(store)
                    vm.observeProducts(FirebaseRefs.Products)
                },
                search = search,
                onSearchToggle = { search = !search },
                searchEntry = searchEntry,
                onSearchChange = { searchEntry = it },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            PremiumBottomBar(
                grandTotal = grandTotal,
                onClear = {
                    if (searchEntry.isNotEmpty()) {
                        search = false
                        searchEntry = ""
                    }
                    vm.clearTotals()
                    vm.clearName()
                },
                onDone = {
                    searchEntry = ""
                    navController.navigate(Screen.Receipt.route)
                    val receipt = vm.generateReceipt()
                    receiptViewmodel.setCurrentReceipt(receipt)
                },
                isEnabled = grandTotal > 0
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        var showSplash by remember { mutableStateOf(true) }

        if (showSplash) {
            ProductSplashScreen(
                modifier = Modifier.padding(innerPadding),
                list = productList.toMutableList(),
                onTimeOut = { showSplash = false }
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Customer Name Input
                CustomerNameInput(
                    customerName = customerName,
                    onNameChange = { vm.setCustomerName(it) }
                )

                // Product List
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(
                        horizontal = BomaDimens.spacingMd,
                        vertical = BomaDimens.spacingSm
                    ),
                    verticalArrangement = Arrangement.spacedBy(BomaDimens.spacingMd)
                ) {
                    if (filteredProducts != null) {
                        item {
                            Text(
                                text = "${filteredProducts.size} results",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(horizontal = BomaDimens.spacingSm)
                            )
                        }
                        items(filteredProducts.sortedBy { it.name }) { product ->
                            val soldProduct = soldProducts.find { it.product?.id == product.id }
                            ProductCard(product, vm, soldProduct)
                        }
                    } else {
                        // Coca-Cola
                        if (cocacolaGroup.isNotEmpty()) {
                            item { SectionHeader("Coca-Cola", BomaColors.cocaCola, cocacolaGroup.size) }
                            items(cocacolaGroup.sortedBy { it.name }) { product ->
                                ProductCard(product, vm, soldProducts.find { it.product?.id == product.id })
                            }
                        }

                        // Hero
                        if (heroGroup.isNotEmpty()) {
                            item { SectionHeader("Hero", BomaColors.hero, heroGroup.size) }
                            items(heroGroup.sortedBy { it.name }) { product ->
                                ProductCard(product, vm, soldProducts.find { it.product?.id == product.id })
                            }
                        }

                        // NBL
                        if (nblGroup.isNotEmpty()) {
                            item { SectionHeader("Nigerian Breweries", BomaColors.nbl, nblGroup.size) }
                            items(nblGroup.sortedBy { it.name }) { product ->
                                ProductCard(product, vm, soldProducts.find { it.product?.id == product.id })
                            }
                        }

                        // Guinness
                        if (guinnessGroup.isNotEmpty()) {
                            item { SectionHeader("Guinness", BomaColors.guinness, guinnessGroup.size) }
                            items(guinnessGroup.sortedBy { it.name }) { product ->
                                ProductCard(product, vm, soldProducts.find { it.product?.id == product.id })
                            }
                        }

                        // PET Bottles
                        if (petsDisplay.isNotEmpty()) {
                            item { SectionHeader("PET Bottles", BomaColors.pets, petsDisplay.size) }
                            items(petsDisplay.sortedBy { it.name }) { product ->
                                ProductCard(product, vm, soldProducts.find { it.product?.id == product.id })
                            }
                        }

                        item { Spacer(Modifier.height(BomaDimens.spacingXl)) }

                        // Cans
                        if (cansDisplay.isNotEmpty()) {
                            item { SectionHeader("Cans", BomaColors.cans, cansDisplay.size) }
                            items(cansDisplay.sortedBy { it.name }) { product ->
                                ProductCard(product, vm, soldProducts.find { it.product?.id == product.id })
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PremiumTopBar(
    selectedStore: Store,
    onStoreChange: (Store) -> Unit,
    search: Boolean,
    onSearchToggle: () -> Unit,
    searchEntry: String,
    onSearchChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    val storeName = selectedStore.name.lowercase().replace("_", " ").replaceFirstChar { it.uppercase() }

    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { onExpandedChange(true) }
            ) {
                Text(storeName, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
                Icon(
                    if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { onExpandedChange(false) },
                    modifier = Modifier.padding(8.dp)) {
                    Store.entries.forEach { store ->
                        if (store == selectedStore){
                            Row (
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                                )
                                DropdownMenuItem(
                                    text = { Text(
                                        store.name.lowercase().replace("_", " ").replaceFirstChar { it.uppercase() },
                                        color = MaterialTheme.colorScheme.onSecondaryContainer) },
                                    onClick = { onExpandedChange(false); onStoreChange(store) },
                                    //leadingIcon = if (store == selectedStore) {{ Icon(Icons.Default., null, tint = MaterialTheme.colorScheme.primary) }} else null
                                )
                            }
                        }else{
                            DropdownMenuItem(
                                text = { Text(store.name.lowercase().replace("_", " ").replaceFirstChar { it.uppercase() }) },
                                onClick = { onExpandedChange(false); onStoreChange(store) },
                                //leadingIcon = if (store == selectedStore) {{ Icon(Icons.Default., null, tint = MaterialTheme.colorScheme.primary) }} else null
                            )
                        }
                    }
                }
            }
        },
        actions = {
            if (search) {
                OutlinedTextField(
                    value = searchEntry,
                    onValueChange = onSearchChange,
                    placeholder = { Text("Search...") },
                    trailingIcon = { IconButton(onClick = { onSearchChange(""); onSearchToggle() }) { Icon(Icons.Default.Close, "Close") } },
                    singleLine = true,
                    modifier = Modifier.width(200.dp).padding(end = 8.dp),
                    shape = RoundedCornerShape(12.dp)
                )
            } else {
                IconButton(onClick = onSearchToggle) { Icon(Icons.Outlined.Search, "Search") }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

@Composable
private fun CustomerNameInput(customerName: String, onNameChange: (String) -> Unit) {
    OutlinedTextField(
        value = customerName,
        onValueChange = onNameChange,
        placeholder = { Text("Customer name", color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)) },
        leadingIcon = { Icon(Icons.Outlined.Person, null, tint = MaterialTheme.colorScheme.primary) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
        )
    )
}

@Composable
private fun SectionHeader(title: String, color: Color, count: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 8.dp, start = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(Modifier.size(4.dp, 24.dp).clip(RoundedCornerShape(2.dp)).background(color))
        Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Surface(shape = CircleShape, color = color.copy(alpha = 0.1f)) {
            Text(count.toString(), style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.SemiBold, color = color, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
        }
    }
}

@Composable
private fun PremiumBottomBar(grandTotal: Int, onClear: () -> Unit, onDone: () -> Unit, isEnabled: Boolean) {
    Surface(modifier = Modifier.fillMaxWidth(), shadowElevation = 8.dp, color = MaterialTheme.colorScheme.surface) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onClear, shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error)) {
                Icon(Icons.Outlined.Clear, null, Modifier.size(18.dp))
                Spacer(Modifier.width(6.dp))
                Text("Clear")
            }

            AnimatedVisibility(visible = grandTotal > 0, enter = fadeIn() + scaleIn(), exit = fadeOut() + scaleOut()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Total", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(nairaFormat(grandTotal), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                }
            }

            Button(onClick = onDone, enabled = isEnabled, shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) {
                Text("Checkout")
                Spacer(Modifier.width(6.dp))
                Icon(Icons.AutoMirrored.Outlined.ArrowForward, null, Modifier.size(18.dp))
            }
        }
    }
}