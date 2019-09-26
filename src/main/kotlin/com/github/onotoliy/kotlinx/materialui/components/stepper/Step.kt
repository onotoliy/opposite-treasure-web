package com.github.onotoliy.kotlinx.materialui.components.stepper

import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/Step")
private external val stepModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val stepComponent: RComponent<MStepProps, RState> = stepModule.default

interface MStepProps : StyledProps {
    var key: String
}

fun RBuilder.mStep(
    key: String? = null,

    className: String? = null,
    handler: StyledHandler<MStepProps>? = null
) = createStyled(stepComponent) {
    key?.let { attrs.key = it }
    setStyledPropsAndRunHandler(className, handler)
}
