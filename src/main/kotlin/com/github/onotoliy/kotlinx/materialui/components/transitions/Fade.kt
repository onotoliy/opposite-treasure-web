package com.github.onotoliy.kotlinx.materialui.components.transitions

import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/Fade")
private external val fadeModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val fadeComponent: RComponent<MFadeProps, RState> = fadeModule.default

external interface MFadeProps : MTransitionProps

fun RBuilder.mFade(
    show: Boolean = false,
    timeout: TransitionTimeout? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MFadeProps>? = null
) = createStyled(fadeComponent, addAsChild) {
    attrs.show = show
    timeout?.let { attrs.timeout = timeout.value() }

    setStyledPropsAndRunHandler(className, handler)
}
