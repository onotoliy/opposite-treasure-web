package com.github.onotoliy.kotlinx.materialui

import com.github.onotoliy.kotlinx.materialui.design.flexRow
import kotlinx.css.*
import react.RBuilder

fun RBuilder.fieldRow(
    label: String,
    value: String? = "",
    labelBasis: String = "300px"
) {
    flexRow {
        css.padding(8.px, 0.px)
        mTypography(label, color = MTypographyColor.textSecondary) {
            css.flex(0.0, 0.0, FlexBasis(labelBasis))
        }
        mTypography(if (!value.isNullOrBlank()) value else "—")
    }
}
