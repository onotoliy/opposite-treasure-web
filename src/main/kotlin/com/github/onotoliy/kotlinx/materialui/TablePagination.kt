package com.github.onotoliy.kotlinx.materialui

import com.github.onotoliy.kotlinx.RequestMeta
import com.github.onotoliy.kotlinx.materialui.table.mTablePagination
import com.github.onotoliy.opposite.data.page.Meta
import react.RBuilder

fun RBuilder.tablePagination(
    meta: RequestMeta,
    onChangePage: (Int) -> Unit = {},
    onChangeRowsPerPage: (Int) -> Unit = {},
    rowsPerPageOptions: Array<Int>? = null
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
            labelRowsPerPage = "Показывать по",
//            labelDisplayedRows = { from, to, count -> "$from-$to из $count" },
            rowsPerPageOptions = rowsPerPageOptions
    )
}

fun RBuilder.tablePagination(
    meta: Meta,
    onChangePage: (Int) -> Unit = {},
    onChangeRowsPerPage: (Int) -> Unit = {},
    rowsPerPageOptions: Array<Int>? = null,
    labelRowsPerPage: String = "Показывать по"
) {
    mTablePagination(
            count = meta.total,
            page = meta.paging.start / meta.paging.size,
            rowsPerPage = meta.paging.size,
            onChangePage = { _, page -> onChangePage(page * meta.paging.size) },
            onChangeRowsPerPage = { e ->
                val size = e.targetValue as Int
                onChangeRowsPerPage(size)
            },
            labelRowsPerPage = labelRowsPerPage,
//            labelDisplayedRows = { from, to, count -> "$from-$to из $count" },
            rowsPerPageOptions = rowsPerPageOptions
    )
}
