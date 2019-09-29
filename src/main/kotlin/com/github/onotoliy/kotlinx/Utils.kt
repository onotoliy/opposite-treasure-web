package com.github.onotoliy.kotlinx

import com.github.onotoliy.opposite.data.page.Page
import kotlinx.serialization.Serializable
import kotlin.browser.window
import kotlin.js.Date
import kotlin.math.floor
import kotlin.random.Random

fun uuid(): String {
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

fun parseJWT(token: String): Any {
    return JSON.parse(window.atob(token.split('.')[1]))
}

fun now(): String = Date().toISOString().substring(0, 10)

fun String.fromISO(): String = Date(this).toISOString().substring(0, 10)

fun String.toISO() = Date(this).toISOString()

fun String.toSimpleDate(): String {
    val date = Date(this)
    val day = "0${date.getDate()}".takeLast(2)
    val month = "0${date.getMonth() + 1}".takeLast(2)
    return "$day.$month.${date.getFullYear()}"
}

@Serializable
data class Config(
    val apiBase: String = ""
)

data class RequestMeta(
    val total: Int = 0,
    val start: Int = 0,
    val size: Int = 10
)

data class ReqListResult<T>(
    val data: Array<T> = emptyArray(),
    val meta: RequestMeta = RequestMeta()
)

fun <T> Page<T>.toReqListResult() = ReqListResult(
        context.toTypedArray(),
        RequestMeta(
                meta.total,
                meta.paging.start,
                meta.paging.size
        )
)