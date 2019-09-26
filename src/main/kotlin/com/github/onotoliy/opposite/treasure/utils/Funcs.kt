package com.github.onotoliy.opposite.treasure.utils

import kotlin.math.floor
import kotlin.random.Random

object Funcs {
    fun createUUID(): String {
        val s = CharArray(36)
        val hexDigits = "0123456789abcdef"
        for (i in 0..35) {
            val rv = floor(Random.nextDouble() * 0x10).toInt()
            s[i] = hexDigits.subSequence(rv, rv + 1)[0]
        }
        s[8] = '-'
        s[13] = '-'
        s[18] = '-'
        s[23] = '-'
        return String(s)
    }
}