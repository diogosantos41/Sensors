package com.didexcodes.sensors.navigation

sealed class Destination(val route: String) {
    object DashboardScreen: Destination(route = "DashboardScreen")
    object LightSensorScreen: Destination(route = "LightSensorScreen")
    object AccelerometerSensorScreen: Destination(route = "AccelerometerSensorScreen")
    object ProximitySensorScreen: Destination(route = "ProximitySensorScreen")
}