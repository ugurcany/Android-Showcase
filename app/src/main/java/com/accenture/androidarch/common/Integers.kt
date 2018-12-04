@file:JvmName("Integers")

package com.accenture.androidarch.common


fun Int.floorToNearestTen(): Int {
    return (Math.floor(this / 10.0) * 10).toInt()
}

fun Int.to3DigitString(): String {
    return when (this) {
        in 0..9 -> "00" + this.toString()
        in 10..99 -> "0" + this.toString()
        else -> this.toString()
    }
}