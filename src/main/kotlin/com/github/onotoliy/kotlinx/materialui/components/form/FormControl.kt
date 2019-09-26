package com.github.onotoliy.kotlinx.materialui.components.form

import com.github.onotoliy.kotlinx.materialui.components.MMargin
import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import com.github.onotoliy.kotlinx.materialui.components.toHyphenCase
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/FormControl")
private external val formControlModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val formControlComponent: RComponent<MFormControlProps, RState> = formControlModule.default

@Suppress("EnumEntryName")
enum class MFormControlVariant {
    standard, outlined, filled
}

/**
 * Div and FieldSet seem to be the most used values for this prop, so we shall enum these... if you need something
 * else, you will have to use the attrs directly.
 */
@Suppress("EnumEntryName")
enum class MFormControlComponent {
    div, fieldSet;

    override fun toString(): String {
        return super.toString().toHyphenCase()
    }
}

interface MFormControlProps : StyledProps {
    var component: String
    var disabled: Boolean
    var error: Boolean
    var fullWidth: Boolean
    var margin: String?
    var required: Boolean
    var variant: String
}

fun RBuilder.mFormControl(
    component: MFormControlComponent = MFormControlComponent.div,
    disabled: Boolean = false,
    error: Boolean = false,
    fullWidth: Boolean = false,
    margin: MMargin? = null,
    required: Boolean = false,
    variant: MFormControlVariant = MFormControlVariant.standard,
    className: String? = null,
    handler: StyledHandler<MFormControlProps>? = null
) = createStyled(formControlComponent) {
    attrs.component = component.toString()
    attrs.disabled = disabled
    attrs.error = error
    attrs.fullWidth = fullWidth
    margin?.let { attrs.margin = margin.toString() }
    attrs.required = required
    attrs.variant = variant.toString()

    setStyledPropsAndRunHandler(className, handler)
}
