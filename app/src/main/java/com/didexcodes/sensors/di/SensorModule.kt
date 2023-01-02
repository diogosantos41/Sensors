package com.didexcodes.sensors.di

import android.app.Application
import com.didexcodes.sensors.core.AccelerometerSensor
import com.didexcodes.sensors.core.LightSensor
import com.didexcodes.sensors.core.MeasurableSensor
import com.didexcodes.sensors.core.ProximitySensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): LightSensor {
        return LightSensor(app)
    }

    @Provides
    @Singleton
    fun provideAccelerometerSensor(app: Application): AccelerometerSensor {
        return AccelerometerSensor(app)
    }

    @Provides
    @Singleton
    fun provideProximitySensor(app: Application): ProximitySensor {
        return ProximitySensor(app)
    }
}