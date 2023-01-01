package com.didexcodes.sensors.feature_lightsensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.didexcodes.sensors.core.LightSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class LightSensorViewModel @Inject constructor(lightSensor: LightSensor) : ViewModel() {

    var isDark by mutableStateOf(false)
    var lux by mutableStateOf(0f)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            lux = ((values[0] * 100.0).roundToInt() / 100.0).toFloat()
            isDark = lux < 60f
        }
    }
}