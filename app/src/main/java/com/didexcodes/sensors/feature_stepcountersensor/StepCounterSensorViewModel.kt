package com.didexcodes.sensors.feature_stepcountersensor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.didexcodes.sensors.core.MeasurableSensor
import com.didexcodes.sensors.core.SensorBaseViewModel
import com.didexcodes.sensors.core.StepCounterSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StepCounterSensorViewModel @Inject constructor(stepCounterSensor: StepCounterSensor) :
    SensorBaseViewModel() {

    var stepsCount by mutableStateOf(0)
    override var sensor: MeasurableSensor = stepCounterSensor

    init {
        stepCounterSensor.startListening()
        stepCounterSensor.setOnSensorValuesChangedListener { values ->
            stepsCount = values[0].toInt()
        }
    }
}