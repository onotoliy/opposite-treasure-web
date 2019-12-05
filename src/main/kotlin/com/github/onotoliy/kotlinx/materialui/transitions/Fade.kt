package com.github.onotoliy.kotlinx.materialui.transitions

import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/Fade")
private external val fadeModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val fadeComponent: RComponent<MFadeProps, RState> = fadeModule.default

external interface MFadeProps : MTransitionProps
var MFadeProps.timeout by TransitionDurationDelegate()

fun RBuilder.mFade(
    show: Boolean = false,
    timeout: TransitionDuration? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MFadeProps>? = null
) = createStyled(fadeComponent, addAsChild) {
    attrs.show = show
    timeout?.let { attrs.timeout = it }

    setStyledPropsAndRunHandler(className, handler)
}
