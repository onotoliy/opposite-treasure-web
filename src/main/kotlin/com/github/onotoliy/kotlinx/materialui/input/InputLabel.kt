package com.github.onotoliy.kotlinx.materialui.input

import com.github.onotoliy.kotlinx.materialui.EnumPropToString
import com.github.onotoliy.kotlinx.materialui.EnumPropToStringNullable
import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.form.MFormControlVariant
import com.github.onotoliy.kotlinx.materialui.form.MFormLabelProps
import com.github.onotoliy.kotlinx.materialui.form.MLabelMargin
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/InputLabel")
private external val inputLabelModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val inputLabelComponent: RComponent<MInputLabelProps, RState> = inputLabelModule.default

interface MInputLabelProps : MFormLabelProps {
    var disableAnimation: Boolean
    var shrink: Boolean
}
var MInputLabelProps.margin by EnumPropToStringNullable(MLabelMargin.values())
var MInputLabelProps.variant by EnumPropToString(MFormControlVariant.values())

fun RBuilder.mInputLabel(
    caption: String,
    htmlFor: String? = null,
    required: Boolean? = null,
    disabled: Boolean? = null,
    error: Boolean? = null,
    focused: Boolean? = null,
    variant: MFormControlVariant = MFormControlVariant.standard,
    shrink: Boolean? = null,
    disableAnimation: Boolean = false,
    margin: MLabelMargin? = null,
    component: String? = null,

    className: String? = null,
    handler: StyledHandler<MInputLabelProps>? = null
) = createStyled(inputLabelComponent) {
    component?.let { attrs.component = it }
    disabled?.let { attrs.disabled = it }
    attrs.disableAnimation = disableAnimation
    htmlFor?.let { attrs.htmlFor = it }
    error?.let { attrs.error = it }
    focused?.let { attrs.focused = it }
    margin?.let { attrs.margin = it }
    required?.let { attrs.required = it }
    shrink?.let {
        // The input label acts strange if it is set to false, best not to set it
        // TODO: Perhaps look at the Material UI source and make a fix
        if (it) {
            attrs.shrink = it
        }
    }
    attrs.variant = variant

    childList.add(caption)
    setStyledPropsAndRunHandler(className, handler)
}
