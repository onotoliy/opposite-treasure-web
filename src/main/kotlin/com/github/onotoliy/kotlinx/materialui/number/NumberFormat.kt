@file:JsModule("react-number-format")

package com.github.onotoliy.kotlinx.materialui.number

import react.Component
import react.RProps
import react.RState
import react.ReactElement

@JsName("default")
external class NumberFormat : Component<NumberFormatProps, RState> {
    override fun render(): ReactElement?
}

external interface NumberFormatProps : RProps {
    var value: Any?
    var onValueChange: (NumberFormatOnChangeValues) -> Unit
    var thousandSeparator: String
    var decimalScale: Int
    var allowLeadingZeros: Boolean
    var allowNegative: Boolean
    var customInput: Any
    var isNumericString: Boolean?
    var format: String?
    var mask: String?

    var error: Boolean
    var className: String
}

external interface NumberFormatOnChangeValues {
    val formattedValue: String
    val value: String
    val floatValue: Double
}
