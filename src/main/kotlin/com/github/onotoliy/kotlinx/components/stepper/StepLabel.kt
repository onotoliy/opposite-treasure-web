package com.github.onotoliy.kotlinx.components.stepper

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/StepLabel")
private external val stepLabelModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val stepLabelComponent: RComponent<MStepLabelProps, RState> = stepLabelModule.default

interface MStepLabelProps : StyledProps

fun RBuilder.mStepLabel(
    className: String? = null,
    handler: StyledHandler<MStepLabelProps>? = null
) = createStyled(stepLabelComponent) {
    setStyledPropsAndRunHandler(className, handler)
}
