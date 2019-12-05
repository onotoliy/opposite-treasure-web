package com.github.onotoliy.kotlinx.materialui.expansionpanel

import com.github.onotoliy.kotlinx.materialui.StyledPropsWithCommonAttributes
import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/ExpansionPanel")
private external val expansionPanelModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val expansionPanelComponent: RComponent<MExpansionPanelProps, RState> = expansionPanelModule.default

interface MExpansionPanelProps : StyledPropsWithCommonAttributes {
    var defaultExpanded: Boolean
    var disabled: Boolean
    var expanded: Boolean
    var onChange: (Event, Boolean) -> Unit
}

fun RBuilder.mExpansionPanel(
    expanded: Boolean? = null,
    defaultExpanded: Boolean = false,
    disabled: Boolean = false,
    onChange: ((Event, Boolean) -> Unit)? = null,
    className: String? = null,
    handler: StyledHandler<MExpansionPanelProps>? = null
) = createStyled(expansionPanelComponent) {
    attrs.defaultExpanded = defaultExpanded
    attrs.disabled = disabled
    expanded?.let { attrs.expanded = it }
    onChange?.let { attrs.onChange = it }
    setStyledPropsAndRunHandler(className, handler)
}
