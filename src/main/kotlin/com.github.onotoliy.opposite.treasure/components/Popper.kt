package com.github.onotoliy.opposite.treasure.components

import org.w3c.dom.Node
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/Popper")
private external val popperModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val popperComponent: RComponent<MPopperProps, RState> = popperModule.default

interface MPopperProps : StyledProps {
    var open: Boolean
    var anchorEl: Node
}

fun RBuilder.mPopper(
    open: Boolean,
    anchorEl: Node? = null,

    className: String? = null,
    handler: StyledHandler<MPopperProps>? = null
) = createStyled(popperComponent) {
    attrs.open = open
    anchorEl?.let { attrs.anchorEl = anchorEl }

    setStyledPropsAndRunHandler(className, handler)
}
