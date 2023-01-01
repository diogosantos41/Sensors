package com.didexcodes.sensors.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.didexcodes.sensors.feature_accelerometersensor.AccelerometerSensorScreen
import com.didexcodes.sensors.feature_lightsensor.LightSensorScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.DashboardScreen.route)
    {
        composable(route = Destination.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }
        composable(route = Destination.LightSensorScreen.route) {
            LightSensorScreen()
        }
        composable(route = Destination.AccelerometerSensorScreen.route) {
            AccelerometerSensorScreen()
        }
        composable(route = Destination.ProximitySensorScreen.route) {
        }

    }
}