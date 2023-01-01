package com.didexcodes.sensors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.didexcodes.sensors.navigation.Navigation
import com.didexcodes.sensors.ui.theme.SensorsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorsTheme {
                Navigation()
            }
        }
    }
}