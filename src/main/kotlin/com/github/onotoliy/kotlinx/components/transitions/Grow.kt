package com.github.onotoliy.kotlinx.components.transitions

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/Grow")
private external val growModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val growComponent: RComponent<MGrowProps, RState> = growModule.default

external interface MGrowProps : MTransitionProps

fun RBuilder.mGrow(
    show: Boolean = false,
    timeout: TransitionTimeout? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MGrowProps>? = null
) = createStyled(growComponent, addAsChild) {
    attrs.show = show
    timeout?.let { attrs.timeout = timeout.value() }

    setStyledPropsAndRunHandler(className, handler)
}
