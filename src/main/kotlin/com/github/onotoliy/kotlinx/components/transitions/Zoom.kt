package com.github.onotoliy.kotlinx.components.transitions

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/Zoom")
private external val zoomModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val zoomComponent: RComponent<MZoomProps, RState> = zoomModule.default

external interface MZoomProps : MTransitionProps

fun RBuilder.mZoom(
    show: Boolean = false,
    timeout: TransitionTimeout? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MZoomProps>? = null
) = createStyled(zoomComponent, addAsChild) {
    attrs.show = show
    timeout?.let { attrs.timeout = timeout.value() }

    setStyledPropsAndRunHandler(className, handler)
}
