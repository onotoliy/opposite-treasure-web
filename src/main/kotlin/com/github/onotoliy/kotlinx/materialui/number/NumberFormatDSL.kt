package com.github.onotoliy.kotlinx.materialui.number

import com.github.onotoliy.kotlinx.materialui.input.inputComponent
import react.RBuilder
import react.RHandler

fun RBuilder.numberFormat(handler: RHandler<NumberFormatProps>) = child(NumberFormat::class, handler)

fun RBuilder.numberFormatInput(
    value: String,
    onValueChange: (NumberFormatOnChangeValues) -> Unit = {},
    thousandSeparator: String = "",
    decimalScale: Int = 0,
    allowLeadingZeros: Boolean = true,
    allowNegative: Boolean = false,
    error: Boolean = false,
    className: String = "",
    handler: RHandler<NumberFormatProps> = {},
    format: String? = null,
    mask: String? = null,
    isNumericString: Boolean? = true
) {
    numberFormat {
        attrs.value = value
        attrs.onValueChange = onValueChange
        attrs.thousandSeparator = thousandSeparator
        attrs.decimalScale = decimalScale
        attrs.allowLeadingZeros = allowLeadingZeros
        attrs.allowNegative = allowNegative
        attrs.customInput = inputComponent
        attrs.format = format
        attrs.mask = mask
        attrs.isNumericString = isNumericString

        attrs.error = error
        attrs.className = className
        handler()
    }
}
