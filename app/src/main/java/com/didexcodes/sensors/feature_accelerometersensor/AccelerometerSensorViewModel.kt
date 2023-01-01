package com.didexcodes.sensors.feature_accelerometersensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.didexcodes.sensors.core.AccelerometerSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccelerometerSensorViewModel @Inject constructor(accelerometerSensor: AccelerometerSensor) :
    ViewModel() {
    var upDown by mutableStateOf(0f)
    var leftRight by mutableStateOf(0f)
    var width by mutableStateOf(0f)
    var height by mutableStateOf(0f)

    init {
        accelerometerSensor.startListening()
        accelerometerSensor.setOnSensorValuesChangedListener { values ->
            leftRight = values[0]
            upDown = values[1]
            width = leftRight * 30
            height = upDown * 30
        }
    }
}