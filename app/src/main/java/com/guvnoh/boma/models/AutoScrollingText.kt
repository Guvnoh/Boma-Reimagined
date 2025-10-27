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
                maxLines = 1
            )
        }
    }
    LaunchedEffect (
        textWidth.intValue,
        containerWidth.intValue
    ){
        val textBreadth= textWidth.intValue
        val containerBreadth = containerWidth.intValue
            if (textBreadth <= containerBreadth)return@LaunchedEffect
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