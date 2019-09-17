package com.github.onotoliy.opposite.treasure.components

import com.github.onotoliy.opposite.treasure.components.form.MFormControlProps
import com.github.onotoliy.opposite.treasure.components.form.MFormControlVariant
import kotlinx.html.InputType
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/TextField")
private external val textFieldDefault: dynamic

@Suppress("UnsafeCastFromDynamic")
private val textFieldComponent: RComponent<MTextFieldProps, RState> = textFieldDefault.default

@Suppress("EnumEntryName")
enum class MTextFieldMargin {
    none, dense, normal
}

interface MTextFieldProps : MFormControlProps {
    var autoComplete: String
    var autoFocus: Boolean
    var defaultValue: String

    @JsName("FormHelperTextProps")
    var formHelperTextProps: RProps

    var helperText: String
    var id: String

    @JsName("InputLabelProps")
    var inputLabelProps: RProps

    @JsName("InputProps")
    var inputProps: RProps

    //    var inputRef	func		Use that property to pass a ref callback to the native input component.

    var label: String

    @JsName("inputProps")
    var nativeInputProps: RProps

    var multiline: Boolean
    var name: String
    var onChange: (event: Event) -> Unit
    var placeholder: String
    var rows: Int
    var rowsMax: Int
    var select: Boolean
    var onKeyDown: (event: KeyboardEvent) -> Unit

    @JsName("SelectProps")
    var selectProps: dynamic

    var type: String
    var value: String
}

fun RBuilder.mTextField(
    label: String,
    value: String? = null,
    helperText: String? = null,
    defaultValue: String? = null,
    placeholder: String? = null,
    variant: MFormControlVariant = MFormControlVariant.outlined,
    onChange: ((event: Event) -> Unit)? = null,
    type: InputType = InputType.text,
    required: Boolean = false,
    disabled: Boolean = false,
    error: Boolean = false,
    autoFocus: Boolean = false,
    fullWidth: Boolean = false,
    onKeyDown: ((event: KeyboardEvent) -> Unit)? = null,

    inputLabelProps: RProps? = null,
    inputProps: RProps? = null,
    nativeInputProps: RProps? = null,
    formHelperTextProps: RProps? = null,

    margin: MTextFieldMargin = MTextFieldMargin.dense,

    autoComplete: String? = null,
    id: String? = null,
    name: String? = null,

    className: String? = null,
    handler: StyledHandler<MTextFieldProps>? = null
) = createStyled(textFieldComponent) {
    autoComplete?.let { attrs.autoComplete = it }
    attrs.autoFocus = autoFocus
    defaultValue?.let { attrs.defaultValue = defaultValue }
    attrs.disabled = disabled
    attrs.error = error
    formHelperTextProps?.let { attrs.formHelperTextProps = formHelperTextProps }
    attrs.fullWidth = fullWidth
    helperText?.let { attrs.helperText = helperText }
    id?.let { attrs.id = it }
    inputLabelProps?.let { attrs.inputLabelProps = inputLabelProps }
    inputProps?.let { attrs.inputProps = inputProps }
    nativeInputProps?.let { attrs.nativeInputProps = nativeInputProps }
    attrs.label = label
    attrs.margin = margin.toString()
    attrs.multiline = false
    name?.let { attrs.name = it }
    onChange?.let { attrs.onChange = onChange }
    placeholder?.let { attrs.placeholder = placeholder }
    attrs.required = required
    attrs.select = false
    attrs.type = type.toString()
    value?.let { attrs.value = value }
    attrs.variant = variant.toString()
    onKeyDown?.let { attrs.onKeyDown = onKeyDown }

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.mTextFieldMultiLine(
    label: String,
    value: String? = null,
    helperText: String? = null,
    defaultValue: String? = null,
    placeholder: String? = null,
    variant: MFormControlVariant = MFormControlVariant.outlined,
    onChange: ((event: Event) -> Unit)? = null,
    required: Boolean = false,
    disabled: Boolean = false,
    error: Boolean = false,
    autoFocus: Boolean = false,
    fullWidth: Boolean = false,

    inputLabelProps: RProps? = null,
    inputProps: RProps? = null,
    nativeInputProps: RProps? = null,
    formHelperTextProps: RProps? = null,

    margin: MTextFieldMargin = MTextFieldMargin.dense,
    rows: Int? = null,
    rowsMax: Int? = null,

    id: String? = null,
    name: String? = null,

    className: String? = null,
    handler: StyledHandler<MTextFieldProps>? = null
) = createStyled(textFieldComponent) {
    attrs.autoFocus = autoFocus
    defaultValue?.let { attrs.defaultValue = defaultValue }
    attrs.disabled = disabled
    attrs.error = error
    formHelperTextProps?.let { attrs.formHelperTextProps = formHelperTextProps }
    attrs.fullWidth = fullWidth
    helperText?.let { attrs.helperText = helperText }
    id?.let { attrs.id = it }
    inputLabelProps?.let { attrs.inputLabelProps = inputLabelProps }
    inputProps?.let { attrs.inputProps = inputProps }
    nativeInputProps?.let { attrs.nativeInputProps = nativeInputProps }
    attrs.label = label
    attrs.margin = margin.toString()
    attrs.multiline = true
    name?.let { attrs.name = it }
    onChange?.let { attrs.onChange = onChange }
    placeholder?.let { attrs.placeholder = placeholder }
    attrs.required = required
    rows?.let { attrs.rows = rows }
    rowsMax?.let { attrs.rowsMax = rowsMax }
    attrs.select = false
    attrs.type = InputType.text.toString()
    value?.let { attrs.value = value }
    attrs.variant = variant.toString()

    setStyledPropsAndRunHandler(className, handler)
}

/**
 * I don't know why there is a test field select when there is a select... but here you go...
 */
fun RBuilder.mTextFieldSelect(
    label: String,
    value: String? = null,
    helperText: String? = null,
    defaultValue: String? = null,
    placeholder: String? = null,
    variant: MFormControlVariant = MFormControlVariant.outlined,
    onChange: ((event: Event) -> Unit)? = null,
    required: Boolean = false,
    disabled: Boolean = false,
    error: Boolean = false,
    autoFocus: Boolean = false,
    fullWidth: Boolean = false,
    multiline: Boolean = false,

    inputLabelProps: RProps? = null,
    inputProps: RProps? = null,
    nativeInputProps: RProps? = null,
    formHelperTextProps: RProps? = null,
    selectProps: RProps? = null,

    margin: MTextFieldMargin = MTextFieldMargin.dense,

    autoComplete: String? = null,
    id: String? = null,
    name: String? = null,

    className: String? = null,
    handler: StyledHandler<MTextFieldProps>? = null
) = createStyled(textFieldComponent) {
    autoComplete?.let { attrs.autoComplete = it }
    attrs.autoFocus = autoFocus
    defaultValue?.let { attrs.defaultValue = defaultValue }
    attrs.disabled = disabled
    attrs.error = error
    formHelperTextProps?.let { attrs.formHelperTextProps = formHelperTextProps }
    attrs.fullWidth = fullWidth
    helperText?.let { attrs.helperText = helperText }
    id?.let { attrs.id = it }
    inputLabelProps?.let { attrs.inputLabelProps = inputLabelProps }
    inputProps?.let { attrs.inputProps = inputProps }
    nativeInputProps?.let { attrs.nativeInputProps = nativeInputProps }
    attrs.label = label
    attrs.margin = margin.toString()
    attrs.multiline = true
    name?.let { attrs.name = it }
    onChange?.let { attrs.onChange = onChange }
    placeholder?.let { attrs.placeholder = placeholder }
    attrs.required = required
    attrs.select = true
    selectProps?.let { attrs.selectProps = selectProps }
    attrs.type = InputType.text.toString()
    value?.let { attrs.value = value }
    attrs.variant = variant.toString()

    attrs.multiline = multiline

    setStyledPropsAndRunHandler(className, handler)
}

/**
 * In case you want access to all fields (remember you can always add attrs anyway)... here it is.
 */
fun RBuilder.mTextFieldFull(
    label: String,
    value: String? = null,
    helperText: String? = null,
    defaultValue: String? = null,
    placeholder: String? = null,
    variant: MFormControlVariant = MFormControlVariant.standard,
    onChange: ((event: Event) -> Unit)? = null,
    type: InputType = InputType.text,
    required: Boolean = false,
    disabled: Boolean = false,
    error: Boolean = false,
    autoFocus: Boolean = false,
    fullWidth: Boolean = false,
    select: Boolean = false,

    inputLabelProps: RProps? = null,
    inputProps: RProps? = null,
    nativeInputProps: RProps? = null,
    formHelperTextProps: RProps? = null,
    selectProps: RProps? = null,

    margin: MTextFieldMargin = MTextFieldMargin.normal,
    multiline: Boolean = false,
    rows: Int? = null,
    rowsMax: Int? = null,

    autoComplete: String? = null,
    id: String? = null,
    name: String? = null,

    className: String? = null,
    handler: StyledHandler<MTextFieldProps>? = null
) = createStyled(textFieldComponent) {
    autoComplete?.let { attrs.autoComplete = it }
    attrs.autoFocus = autoFocus
    defaultValue?.let { attrs.defaultValue = defaultValue }
    attrs.disabled = disabled
    attrs.error = error
    formHelperTextProps?.let { attrs.formHelperTextProps = formHelperTextProps }
    attrs.fullWidth = fullWidth
    helperText?.let { attrs.helperText = helperText }
    id?.let { attrs.id = it }
    inputLabelProps?.let { attrs.inputLabelProps = inputLabelProps }
    inputProps?.let { attrs.inputProps = inputProps }
    nativeInputProps?.let { attrs.nativeInputProps = nativeInputProps }
    attrs.label = label
    attrs.margin = margin.toString()
    attrs.multiline = multiline
    name?.let { attrs.name = it }
    onChange?.let { attrs.onChange = onChange }
    placeholder?.let { attrs.placeholder = placeholder }
    attrs.required = required
    rows?.let { attrs.rows = rows }
    rowsMax?.let { attrs.rowsMax = rowsMax }
    attrs.select = select
    selectProps?.let { attrs.selectProps = selectProps }
    attrs.type = type.toString()
    value?.let { attrs.value = value }
    attrs.variant = variant.toString()
    setStyledPropsAndRunHandler(className, handler)
}
