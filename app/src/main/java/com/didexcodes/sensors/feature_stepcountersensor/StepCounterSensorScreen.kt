package com.didexcodes.sensors.feature_stepcountersensor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
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

@Composable
fun StepCounterSensorScreen(
    navController: NavController,
    viewModel: StepCounterSensorViewModel = hiltViewModel()
) {
    val stepsCount = viewModel.stepsCount

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
            text = "Steps Count: $stepsCount",
            color = Color.DarkGray,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.stepsCount = 0 }) {
            Text(text = "Reset Steps")
        }
    }
}