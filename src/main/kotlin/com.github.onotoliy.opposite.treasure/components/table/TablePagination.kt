package com.github.onotoliy.opposite.treasure.components.table

import com.github.onotoliy.opposite.treasure.components.MButtonBaseProps
import com.github.onotoliy.opposite.treasure.components.MIconButtonProps
import com.github.onotoliy.opposite.treasure.components.createStyled
import com.github.onotoliy.opposite.treasure.components.setStyledPropsAndRunHandler
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/TablePagination")
private external val tablePaginationModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val tablePaginationComponent: RComponent<MTablePaginationProps, RState> = tablePaginationModule.default

interface MTablePaginationProps : MButtonBaseProps {
    @JsName("actions")
    var actions: String
    var backIconButtonProps: MIconButtonProps
    var count: Int
    var labelDisplayedRows: (meta: MTablePaginationMeta) -> String
    var labelRowsPerPage: String
    var nextIconButtonProps: MIconButtonProps
    var onChangePage: (event: Event, page: Int) -> Unit
    var onChangeRowsPerPage: (event: Event) -> Unit
    var page: Int
    var rowsPerPage: Int
    var rowsPerPageOptions: Array<Int>
    @JsName("selectProps")
    var selectProps: RProps
}

interface MTablePaginationMeta {
    val from: Int
    val to: Int
    val page: Int
    val count: Int
}

fun RBuilder.mTablePagination(
    actions: String? = null,
    backIconButtonProps: MIconButtonProps? = null,
    component: String? = "div",
    count: Int? = null,
    labelDisplayedRows: ((meta: MTablePaginationMeta) -> String)? = null,
    labelRowsPerPage: String? = null,
    nextIconButtonProps: MIconButtonProps? = null,
    onChangePage: ((event: Event, page: Int) -> Unit)? = null,
    onChangeRowsPerPage: ((event: Event) -> Unit)? = null,
    page: Int? = null,
    rowsPerPage: Int? = null,
    rowsPerPageOptions: Array<Int>? = null,
    selectProps: RProps? = null,

    className: String? = null,
    handler: StyledHandler<MTablePaginationProps>? = null
) = createStyled(tablePaginationComponent) {
    actions?.let { attrs.actions = it }
    backIconButtonProps?.let { attrs.backIconButtonProps = it }
    component?.let { attrs.component = it }
    count?.let { attrs.count = it }
    labelDisplayedRows?.let { attrs.labelDisplayedRows = it }
    labelRowsPerPage?.let { attrs.labelRowsPerPage = it }
    nextIconButtonProps?.let { attrs.nextIconButtonProps = it }
    onChangePage?.let { attrs.onChangePage = it }
    onChangeRowsPerPage?.let { attrs.onChangeRowsPerPage = it }
    page?.let { attrs.page = it }
    rowsPerPage?.let { attrs.rowsPerPage = it }
    rowsPerPageOptions?.let { attrs.rowsPerPageOptions = it }
    selectProps?.let { attrs.selectProps = it }

    setStyledPropsAndRunHandler(className, handler)
}
