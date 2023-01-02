package com.didexcodes.sensors.feature_accelerometersensor

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.didexcodes.sensors.navigation.HandleSensorScreenOnBackPressed
import kotlin.math.abs

@Composable
fun AccelerometerSensorScreen(
    navController: NavController,
    viewModel: AccelerometerSensorViewModel = hiltViewModel(),
) {
    val upDownColor = if (viewModel.upDown > 0) Color.Green else Color.Red
    val leftRightColor = if (viewModel.leftRight > 0) Color.Green else Color.Red
    val isEvenLevel = viewModel.evenLevel

    HandleSensorScreenOnBackPressed(
        stopListening = { viewModel.sensorStopListening() },
        toGoBack = viewModel.goBack,
        navigateUp = { navController.navigateUp() }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        if (isEvenLevel) {
            Text(
                text = "Balanced",
                color = Color.DarkGray,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        } else {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessVeryLow
                        )
                    )
                    .size(
                        width = 100.dp + abs(viewModel.width).dp,
                        height = 100.dp + abs(viewModel.height).dp
                    )
                    .background(Color.DarkGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "up/down: ${viewModel.upDown}", color = upDownColor)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "left/right: ${viewModel.leftRight}", color = leftRightColor)
            }
        }
    }
}