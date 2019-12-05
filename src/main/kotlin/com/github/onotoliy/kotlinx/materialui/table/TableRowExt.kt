package com.github.onotoliy.kotlinx.materialui.table

import com.github.onotoliy.kotlinx.materialui.button.MButtonBaseProps
import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.hex
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import kotlinx.css.*
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.css

@JsModule("@material-ui/core/TableRow")
private external val tableRowModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val tableRowComponent: RComponent<MTableRowProps, RState> = tableRowModule.default

interface MTableRowProps : MButtonBaseProps {
    var hover: Boolean
    var key: Any
    var selected: Boolean
}

fun RBuilder.mTableRow(
    key: Any? = null,
    selected: Boolean = false,
    hover: Boolean = false,
    onClick: ((Event) -> Unit)? = null,
    component: String = "tr",

    className: String? = null,
    handler: StyledHandler<MTableRowProps>? = null
) = createStyled(tableRowComponent) {

    css {
        children("th") {
            padding(12.px, 12.px, 12.px, 0.px)
            color = ADColor.DarkSky.hex()
            fontWeight = FontWeight.bold
        }
        children("td") {
            padding(12.px, 12.px, 12.px, 0.px)
            color = ADColor.GrayCloud.hex()
        }
    }

    key?.let { attrs.key = key }
    attrs.component = component
    attrs.hover = hover
    onClick?.let { attrs.onClick = it }
    attrs.selected = selected

    setStyledPropsAndRunHandler(className, handler)
}
