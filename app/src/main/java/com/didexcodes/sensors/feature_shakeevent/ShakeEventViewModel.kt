package com.didexcodes.sensors.feature_shakeevent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.didexcodes.sensors.core.AccelerometerSensor
import com.didexcodes.sensors.core.MeasurableSensor
import com.didexcodes.sensors.core.SensorBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.sqrt

@HiltViewModel
class ShakeEventViewModel @Inject constructor(accelerometerSensor: AccelerometerSensor) :
    SensorBaseViewModel() {
    override var sensor: MeasurableSensor = accelerometerSensor
    var backgroundColor by mutableStateOf(Color.Green)
    var accelerationValue by mutableStateOf(0f)

    init {
        sensor.startListening()
        sensor.setOnSensorValuesChangedListener { values ->
            val xAccl = values[0]
            val yAccl = values[1]
            val zAccl = values[2]

            accelerationValue = abs(xAccl) + abs(yAccl) + abs(zAccl)

            backgroundColor = if (accelerationValue > 22) {
                Color.Red
            } else {
                Color.Green
            }
        }
    }
}