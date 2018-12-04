@file:JvmName("Strings")

package com.accenture.androidarch.common

import java.util.*


const val BACKSPACE = "<"
const val CLEAR_ALL_DISPLAY = "<<"
const val EMPTY = " "
const val GAP = "-"
const val SPACE = "_"
const val NEW_LINE = "*"
const val CLEAR_ALL_KEY = "!"


fun String.isBackspace(): Boolean {
    return this.equals("<")
}

fun String.isClearAll(): Boolean {
    return this.equals("<<")
}

fun Char.isSpace(): Boolean {
    return this == '_'
}

fun Char.isNewLine(): Boolean {
    return this == '*'
}

fun Char.isGap(): Boolean {
    return this == '-'
}

fun Char.isBackspace(): Boolean {
    return this == '<'
}

fun Char.isClearAll(): Boolean {
    return this == '!'
}

fun Char.toUppercase(): String? {
    return this.toString().toUppercase()
}

fun String?.toUppercase(): String? {
    return this?.toUpperCase(Locale.ENGLISH) ?: ""
}