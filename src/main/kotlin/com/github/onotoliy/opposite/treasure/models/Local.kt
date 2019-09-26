package com.github.onotoliy.opposite.treasure.models

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val apiBase: String = ""
)

enum class RequestStatus {
    PENDING,
    SUCCESS,
    FAILURE
}

data class RequestMeta(
    val total: Int = 0,
    val start: Int = 0,
    val size: Int = 10
)

data class ReqListResult<T>(
    val data: Array<T> = emptyArray(),
    val meta: RequestMeta = RequestMeta(),
    val status: RequestStatus = RequestStatus.SUCCESS
)