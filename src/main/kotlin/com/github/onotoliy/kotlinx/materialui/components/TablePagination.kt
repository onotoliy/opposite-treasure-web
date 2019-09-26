package com.github.onotoliy.kotlinx.materialui.components

import com.github.onotoliy.kotlinx.materialui.components.table.mTablePagination
import com.github.onotoliy.opposite.treasure.models.RequestMeta
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