package com.didexcodes.sensors.core

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.didexcodes.sensors.core.AndroidSensor

class LightSensor(context: Context) : AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)

class AccelerometerSensor(context: Context) : AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_ACCELEROMETER,
    sensorType = Sensor.TYPE_ACCELEROMETER
)