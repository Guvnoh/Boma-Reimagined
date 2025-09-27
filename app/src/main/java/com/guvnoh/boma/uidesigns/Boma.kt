package com.guvnoh.boma.uidesigns

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.guvnoh.boma.navigation.MenuItems
import com.guvnoh.boma.navigation.Navigation
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Boma(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Menu",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                NavigationDrawerItem(
                    label = { Text("Products") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close()}
                        navController.navigate(MenuItems.Products.route)
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Change Price") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close()}
                        navController.navigate(MenuItems.PriceChange.route)
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Records") },
                    selected = false,
                    onClick = {scope.launch { drawerState.close()}}
                )
                NavigationDrawerItem(
                    label = { Text("Add Product") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close()}

                    }
                )
            }
        }
    ) {
        Scaffold (
            topBar = {
                SmallTopAppBar(
                    title = { Text(text = "Boma", style = MaterialTheme.typography.titleLarge) },
                    navigationIcon = {
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } },
                            content = {Icon(Icons.Default.Menu, "")}
                        )
                    }
                )
            }
        ){
            Navigation(it, navController)
        }
    }
}

@Preview
@Composable
fun DrawerPreview(){
    Boma()
}