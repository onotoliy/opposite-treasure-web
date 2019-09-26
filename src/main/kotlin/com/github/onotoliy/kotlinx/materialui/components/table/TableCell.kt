package com.github.onotoliy.kotlinx.materialui.components.table

import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/TableCell")
private external val tableCellModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val TableCellComponent: RComponent<MTableCellProps, RState> = tableCellModule.default

@Suppress("EnumEntryName")
enum class MTableCellPadding {
    default, checkbox, dense, none
}

@Suppress("EnumEntryName")
enum class MTableCellSortDirection {
    asc, desc, False;

    override fun toString(): String {
        return super.toString().toLowerCase()
    }
}

@Suppress("EnumEntryName")
enum class MTableCellAlign {
    inherit, left, center, right, justify
}

@Suppress("EnumEntryName")
enum class MTableCellVariant {
    head, body, footer
}

interface MTableCellProps : StyledProps {
    var colSpan: Int
    var component: String
    var key: Any
    var align: String
    var padding: String
    var scope: String
    var sortDirection: Any
    var variant: String
}

fun RBuilder.mTableCell(
    key: Any? = null,
    variant: MTableCellVariant = MTableCellVariant.body,
    sortDirection: MTableCellSortDirection = MTableCellSortDirection.False,
    align: MTableCellAlign = MTableCellAlign.inherit,
    padding: MTableCellPadding = MTableCellPadding.default,
    colSpan: Int? = null,
    component: String? = null,
    scope: String? = null,

    className: String? = null,
    handler: StyledHandler<MTableCellProps>? = null
) = createStyled(TableCellComponent) {
    attrs.align = align.toString()
    colSpan?.let { attrs.colSpan = it }
    component?.let { attrs.component = component }
    key?.let { attrs.key = it }
    attrs.padding = padding.toString()
    scope?.let { attrs.scope = it }
    attrs.sortDirection = if (sortDirection == MTableCellSortDirection.False) false else sortDirection.toString()
    attrs.variant = variant.toString()
    setStyledPropsAndRunHandler(className, handler)
}
