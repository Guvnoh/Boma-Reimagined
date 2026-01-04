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
