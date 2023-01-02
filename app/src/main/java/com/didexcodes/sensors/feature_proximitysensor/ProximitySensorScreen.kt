package com.didexcodes.sensors.feature_proximitysensor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
fun ProximitySensorScreen(
    navController: NavController,
    viewModel: ProximityViewModel = hiltViewModel()
) {
    val isCloseToPhone = viewModel.isCloseToPhone

    HandleSensorScreenOnBackPressed(
        stopListening = { viewModel.sensorStopListening() },
        toGoBack = viewModel.goBack,
        navigateUp = { navController.navigateUp() }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isCloseToPhone) {
                "Close to Phone"
            } else {
                "Away from Phone"
            },
            color = Color.DarkGray,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold
        )
    }
}