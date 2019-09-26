package com.github.onotoliy.kotlinx.components

import com.github.onotoliy.kotlinx.RequestMeta
import com.github.onotoliy.kotlinx.components.table.mTablePagination
import react.RBuilder

fun RBuilder.tablePagination(
    meta: RequestMeta,
    onChangePage: (Int) -> Unit = {},
    onChangeRowsPerPage: (Int) -> Unit = {}
) {
    mTablePagination(
            count = meta.total,
            page = meta.start / meta.size,
            rowsPerPage = meta.size,
            onChangePage = { _, page -> onChangePage(page * meta.size) },
            onChangeRowsPerPage = { e ->
                val size = e.targetValue as Int
                onChangeRowsPerPage(size)
            },
            labelRowsPerPage = "Показывать",
            labelDisplayedRows = { tableMeta -> "${tableMeta.from}-${tableMeta.to} из ${tableMeta.count}" }
    )
}