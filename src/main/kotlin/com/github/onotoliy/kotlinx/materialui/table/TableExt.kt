package com.github.onotoliy.kotlinx.materialui.table

import com.github.onotoliy.kotlinx.materialui.EnumPropToString
import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import kotlinx.css.marginBottom
import kotlinx.css.px
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps
import styled.css

@JsModule("@material-ui/core/Table")
private external val tableModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val tableComponent: RComponent<MTableProps, RState> = tableModule.default

interface MTableProps : StyledProps {
    var component: String

    /**
     * Material UI docs say this does not work with IE 11
     */
    var stickyHeader: Boolean
}
var MTableProps.padding by EnumPropToString(MTableCellPadding.values())
var MTableProps.size by EnumPropToString(MTableCellSize.values())

fun RBuilder.mTable(
    component: String = "table",

    className: String? = null,
    handler: StyledHandler<MTableProps>? = null
) = createStyled(tableComponent) {
    css {
        marginBottom = 12.px
    }

    attrs.component = component
    setStyledPropsAndRunHandler(className, handler)
}
