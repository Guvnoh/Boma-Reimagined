package com.guvnoh.boma.uidesigns

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
import com.guvnoh.boma.databasePrices
import com.guvnoh.boma.models.Product
import com.guvnoh.boma.models.BomaViewModel
import kotlinx.coroutines.launch
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.guvnoh.boma.R
import com.guvnoh.boma.formatters.nairaFormat
import com.guvnoh.boma.getImage
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalWearMaterialApi::class)
@Composable
fun SwipeableProductCard(
    product: Product,
    vm: BomaViewModel,
    navController: NavController
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
        AlertDialogg(
            onDelete = { databasePrices.child(product.name).removeValue() },
            product = product,
            alert = alert,
            navController = navController
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogg(
    onDelete: (Product) -> Unit,
    product: Product,
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
    product: Product
) {

    val context = LocalContext.current
    val resId =
        if (getImage(context,product.imageName)!=0) {
            getImage(context,product.imageName)
        }else R.drawable.bottle

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
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = nairaFormat(product.stringPrice.toInt()),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}
