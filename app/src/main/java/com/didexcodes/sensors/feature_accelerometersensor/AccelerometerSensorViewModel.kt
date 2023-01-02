package com.didexcodes.sensors.feature_accelerometersensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.didexcodes.sensors.core.AccelerometerSensor
import com.didexcodes.sensors.core.MeasurableSensor
import com.didexcodes.sensors.core.SensorBaseViewModel
import com.didexcodes.sensors.formatTwoDecimals
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccelerometerSensorViewModel @Inject constructor(accelerometerSensor: AccelerometerSensor) :
    SensorBaseViewModel() {
    var upDown by mutableStateOf(0f)
    var leftRight by mutableStateOf(0f)
    var width by mutableStateOf(0f)
    var height by mutableStateOf(0f)
    var evenLevel by mutableStateOf(false)
    override var sensor: MeasurableSensor = accelerometerSensor

    init {
        sensor.startListening()
        sensor.setOnSensorValuesChangedListener { values ->
            leftRight = formatTwoDecimals((values[0]))
            upDown = formatTwoDecimals((values[1]))
            width = leftRight * 30
            height = upDown * 30
            evenLevel = kotlin.math.abs(upDown) < 0.17 && kotlin.math.abs(leftRight) < 0.17
        }
    }
}