package com.github.onotoliy.opposite.treasure.components.stepper

import com.github.onotoliy.opposite.treasure.components.createStyled
import com.github.onotoliy.opposite.treasure.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/StepButton")
private external val stepButtonModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val stepButtonComponent: RComponent<MStepButtonProps, RState> = stepButtonModule.default

interface MStepButtonProps : StyledProps {
    var onClick: () -> Unit
    var completed: Boolean
}

fun RBuilder.mStepButton(
    onClick: () -> Unit = {},
    completed: Boolean = false,

    className: String? = null,
    handler: StyledHandler<MStepButtonProps>? = null
) = createStyled(stepButtonComponent) {
    attrs.onClick = onClick
    attrs.completed = completed

    setStyledPropsAndRunHandler(className, handler)
}
