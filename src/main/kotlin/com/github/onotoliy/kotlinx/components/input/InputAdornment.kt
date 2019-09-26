package com.github.onotoliy.kotlinx.components.input

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.form.MFormControlVariant
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/InputAdornment")
private external val inputAdornmentDefault: dynamic

@Suppress("UnsafeCastFromDynamic")
private val inputAdornmentComponent: RComponent<MInputAdornmentProps, RState> = inputAdornmentDefault.default

@Suppress("EnumEntryName")
enum class MInputAdornmentPosition {
    start, end
}

interface MInputAdornmentProps : StyledProps {
    var disablePointerEvents: Boolean
    var disableTypography: Boolean
    var position: String
    var variant: String
}

fun RBuilder.mInputAdornment(
    position: MInputAdornmentPosition = MInputAdornmentPosition.start,
    disablePointerEvents: Boolean = false,
    disableTypography: Boolean = false,
    variant: MFormControlVariant? = null,

    className: String? = null,

    handler: StyledHandler<MInputAdornmentProps>? = null
) = createStyled(inputAdornmentComponent, false) {
    attrs.disablePointerEvents = disablePointerEvents
    attrs.disableTypography = disableTypography
    attrs.position = position.toString().toLowerCase()
    variant?.let { attrs.variant = it.toString() }

    setStyledPropsAndRunHandler(className, handler)
}
