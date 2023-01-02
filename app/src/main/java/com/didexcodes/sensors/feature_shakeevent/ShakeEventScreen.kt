package com.didexcodes.sensors.feature_shakeevent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.didexcodes.sensors.navigation.HandleSensorScreenOnBackPressed

@Composable
fun ShakeEventScreen(
    navController: NavController,
    viewModel: ShakeEventViewModel = hiltViewModel(),
) {

    var backgroundColor = viewModel.backgroundColor

    HandleSensorScreenOnBackPressed(
        stopListening = { viewModel.sensorStopListening() },
        toGoBack = viewModel.goBack,
        navigateUp = { navController.navigateUp() }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Shake the Phone!",
                color = Color.DarkGray,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
            Text(text = "Acceleration: ${viewModel.accelerationValue}")
        }
    }
}