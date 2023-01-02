package com.didexcodes.sensors.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.didexcodes.sensors.feature_accelerometersensor.AccelerometerSensorScreen
import com.didexcodes.sensors.feature_lightsensor.LightSensorScreen
import com.didexcodes.sensors.feature_proximitysensor.ProximitySensorScreen
import com.didexcodes.sensors.feature_shakeevent.ShakeEventScreen
import com.didexcodes.sensors.feature_stepcountersensor.StepCounterSensorScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.DashboardScreen.route)
    {
        composable(route = Destination.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }
        composable(route = Destination.LightSensorScreen.route) {
            LightSensorScreen(navController)
        }
        composable(route = Destination.AccelerometerSensorScreen.route) {
            AccelerometerSensorScreen(navController)
        }
        composable(route = Destination.ShakeEventScreen.route) {
            ShakeEventScreen(navController)
        }
        composable(route = Destination.ProximitySensorScreen.route) {
            ProximitySensorScreen(navController)
        }
        composable(route = Destination.StepCounterSensorScreen.route) {
            StepCounterSensorScreen(navController)
        }
    }
}