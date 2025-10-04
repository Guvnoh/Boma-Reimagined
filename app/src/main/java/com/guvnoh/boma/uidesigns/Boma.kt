//package com.guvnoh.boma.uidesigns
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material.icons.filled.AddCircle
//import androidx.compose.material.icons.filled.Create
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import androidx.navigation.compose.rememberNavController
//import com.guvnoh.boma.R
//import com.guvnoh.boma.navigation.Screen
//import com.guvnoh.boma.navigation.Navigation
//import kotlinx.coroutines.launch
//
//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Boma() {
//    val navController = rememberNavController()
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet(
//                modifier = Modifier.fillMaxHeight()
//            ) {
//                // Drawer Header
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color(0xFF4CAF50))
//                        .padding(20.dp),
//                    contentAlignment = Alignment.CenterStart
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally) {
//                        Image(
//                            painter = painterResource(R.drawable.boma_logo),
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier
//                                .clip(CircleShape)
//                                .size(250.dp))
//                    }
//                }
//
//                Spacer(Modifier.height(8.dp))
//
//                // Drawer items
//                NavigationDrawerItem(
//                    label = { Text("Products") },
//                    selected = false,
//                    onClick = {
//                        scope.launch { drawerState.close() }
//                        navController.navigate(Screen.Products.route){
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                inclusive = true
//                            }
//                            launchSingleTop = true
//                        }
//                    },
//                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) }
//                )
//
//                NavigationDrawerItem(
//                    label = { Text("Change Price") },
//                    selected = false,
//                    onClick = {
//                        scope.launch { drawerState.close() }
//                        navController.navigate(Screen.PriceChange.route){
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//                            launchSingleTop = true
//                            restoreState = true
//                        }
//                    },
//                    icon = { Icon(Icons.Default.Create, contentDescription = null) }
//                )
//
//                NavigationDrawerItem(
//                    label = { Text("Records") },
//                    selected = false,
//                    onClick = { scope.launch { drawerState.close() } },
//                    icon = { Icon(Icons.Default.DateRange, contentDescription = null) }
//                )
//
//                NavigationDrawerItem(
//                    label = { Text("Add Product") },
//                    selected = false,
//                    onClick = {
//                        navController.navigate(Screen.AddProduct.route)
//                        scope.launch { drawerState.close() } },
//                    icon = { Icon(Icons.Default.AddCircle, contentDescription = null) }
//                )
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                TopAppBar(title = { Text(text = "Boma") },
//                    navigationIcon = {
//                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
//                            Icon(Icons.Default.Menu, contentDescription = "Menu")
//                        }
//                    }
//                )
//            }
//        ) { innerPadding ->
//            Navigation(innerPadding, navController)
//        }
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun DrawerPreview() {
//    Boma()
//}
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.R
import com.guvnoh.boma.navigation.Screen
import com.guvnoh.boma.navigation.Navigation
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Boma() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                        Text(
                            text = "Quality you can trust!",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                            )
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                // Drawer Items with ripple + hover
                DrawerItem(
                    label = "Products",
                    icon = Icons.Default.ShoppingCart
                ) {
                    scope.launch { drawerState.close() }
                    navController.navigate(Screen.Products.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }

                DrawerItem(
                    label = "Change Price",
                    icon = Icons.Default.Create
                ) {
                    scope.launch { drawerState.close() }
                    navController.navigate(Screen.PriceChange.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

                DrawerItem(
                    label = "Records",
                    icon = Icons.Default.DateRange
                ) {
                    scope.launch { drawerState.close() }
                }

                DrawerItem(
                    label = "Add Product",
                    icon = Icons.Default.AddCircle
                ) {
                    navController.navigate(Screen.AddProduct.route)
                    scope.launch { drawerState.close() }
                }

                DrawerItem(
                    label = "Delete Product",
                    icon = Icons.Default.Delete
                ) {
                    navController.navigate(Screen.DeleteProduct.route)
                    scope.launch { drawerState.close() }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Boma",
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
fun DrawerItem(label: String, icon: ImageVector, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = label, tint = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.width(16.dp))
        Text(
            text = label,
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
