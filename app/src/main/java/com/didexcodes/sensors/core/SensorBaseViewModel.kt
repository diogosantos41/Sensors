package com.didexcodes.sensors.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

abstract class SensorBaseViewModel : ViewModel() {
    var goBack by mutableStateOf(false)
    abstract var sensor: MeasurableSensor

    fun sensorStopListening() {
        sensor.stopListening()
        goBack = true
    }
}