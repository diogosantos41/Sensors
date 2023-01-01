package com.didexcodes.sensors.feature_lightsensor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LightSensorScreen(
    viewModel: LightSensorViewModel = hiltViewModel()
) {
    val isDark = viewModel.isDark
    val textColor = if (isDark) Color.White else Color.DarkGray
    val backgroundColor = if (isDark) Color.DarkGray else Color.White
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isDark) {
                "It's Dark!"
            } else {
                "It's Bright!"
            },
            color = textColor,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Current Lux Value: ${viewModel.lux}",
            color = textColor
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Above 60: Bright / Below 60: Dark",
            color = textColor
        )
    }
}