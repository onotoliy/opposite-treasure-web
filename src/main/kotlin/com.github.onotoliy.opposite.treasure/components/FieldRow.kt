package com.github.onotoliy.opposite.treasure.components

import com.github.onotoliy.opposite.treasure.components.styled.flexRow
import kotlinx.css.FlexBasis
import kotlinx.css.flexBasis
import kotlinx.css.padding
import kotlinx.css.px
import react.RBuilder

fun RBuilder.fieldRow(label: String, value: String? = "") {
    flexRow {
        css.padding(8.px, 0.px)
        mTypography(color = MTypographyColor.textSecondary) {
            css.flexBasis = FlexBasis("300px")
            +label
        }
        mTypography {
            +(if (!value.isNullOrBlank()) value else "—")
        }
    }
}