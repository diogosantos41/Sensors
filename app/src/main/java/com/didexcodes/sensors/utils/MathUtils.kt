package com.didexcodes.sensors

import kotlin.math.roundToInt

fun formatTwoDecimals(number: Float): Float {
    return ((number * 100.0).roundToInt() / 100.0).toFloat()
}