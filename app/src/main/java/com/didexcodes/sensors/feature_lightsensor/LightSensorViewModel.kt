package com.didexcodes.sensors.feature_lightsensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.didexcodes.sensors.core.LightSensor
import com.didexcodes.sensors.core.MeasurableSensor
import com.didexcodes.sensors.core.SensorBaseViewModel
import com.didexcodes.sensors.formatTwoDecimals
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LightSensorViewModel @Inject constructor(lightSensor: LightSensor) : SensorBaseViewModel() {

    var isDark by mutableStateOf(false)
    var lux by mutableStateOf(0f)
    override var sensor: MeasurableSensor = lightSensor

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            lux = formatTwoDecimals((values[0]))
            isDark = lux < 60f
        }
    }
}