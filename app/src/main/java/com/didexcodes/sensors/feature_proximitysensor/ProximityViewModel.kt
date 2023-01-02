package com.didexcodes.sensors.feature_proximitysensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.didexcodes.sensors.core.MeasurableSensor
import com.didexcodes.sensors.core.ProximitySensor
import com.didexcodes.sensors.core.SensorBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProximityViewModel @Inject constructor(proximitySensor: ProximitySensor) :
    SensorBaseViewModel() {

    var isCloseToPhone by mutableStateOf(false)
    override var sensor: MeasurableSensor = proximitySensor

    init {
        sensor.startListening()
        sensor.setOnSensorValuesChangedListener { values ->
            isCloseToPhone = values[0].toInt() == 0
        }
    }
}