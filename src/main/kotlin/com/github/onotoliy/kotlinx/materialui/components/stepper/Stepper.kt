package com.github.onotoliy.kotlinx.materialui.components.stepper

import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/Stepper")
private external val stepperModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val stepperComponent: RComponent<MStepperProps, RState> = stepperModule.default

interface MStepperProps : StyledProps {
    var activeStep: Int
    var nonLinear: Boolean
    var orientation: String
}

@Suppress("EnumEntryName")
enum class MStepperOrientation {
    horizontal, vertical
}

fun RBuilder.mStepper(
    activeStep: Int,
    nonLinear: Boolean = false,
    orientation: MStepperOrientation = MStepperOrientation.horizontal,

    className: String? = null,
    handler: StyledHandler<MStepperProps>? = null
) = createStyled(stepperComponent) {
    attrs.activeStep = activeStep
    attrs.nonLinear = nonLinear
    attrs.orientation = orientation.toString()

    setStyledPropsAndRunHandler(className, handler)
}