package com.github.onotoliy.opposite.treasure.utils

import com.github.onotoliy.opposite.data.page.Page
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import com.github.onotoliy.opposite.treasure.models.RequestMeta
import com.github.onotoliy.opposite.treasure.models.RequestStatus

fun <T> Page<T>.toReqListResult(status: RequestStatus) = ReqListResult(
        context.toTypedArray(),
        RequestMeta(
                meta.total,
                meta.paging.start,
                meta.paging.size
        ),
        status
)