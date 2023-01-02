package com.didexcodes.sensors.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .padding(10.dp)
    ) {
        Item(
            title = "Light Sensor",
            subtitle = "Measures the ambient light level (illumination) in lux.",
            onClick = { navController.navigate(Destination.LightSensorScreen.route) })
        Spacer(modifier = Modifier.height(10.dp))
        Item(
            title = "Accelerometer Sensor",
            subtitle = "Measures the acceleration force in m/s2 that is applied to a device on all three physical axes (x, y, and z), including the force of gravity.",
            onClick = { navController.navigate(Destination.AccelerometerSensorScreen.route) })
        Spacer(modifier = Modifier.height(10.dp))
        Item(
            title = "Shake Event",
            subtitle = "Detect shake events using the Accelerometer Sensor",
            onClick = { navController.navigate(Destination.ShakeEventScreen.route) })
        Spacer(modifier = Modifier.height(10.dp))
        Item(
            title = "Proximity Sensor",
            subtitle = "Measures the proximity of an object in cm relative to the view screen of a device.",
            onClick = { navController.navigate(Destination.ProximitySensorScreen.route) })
        Spacer(modifier = Modifier.height(10.dp))
        Item(
            title = "Step Counter Sensor",
            subtitle = "Provides the number of steps taken by the user",
            onClick = { navController.navigate(Destination.StepCounterSensorScreen.route) })
    }
}

@Composable
fun Item(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        backgroundColor = Color.White,
        elevation = 4.dp,
        contentColor = Color.Black
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                Text(text = title, fontWeight = FontWeight.ExtraBold)
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            IconButton(onClick = onClick, modifier = Modifier.align(Alignment.CenterVertically)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "More")
            }
        }
    }
}