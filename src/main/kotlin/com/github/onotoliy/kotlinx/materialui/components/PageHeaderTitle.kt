package com.github.onotoliy.kotlinx.materialui.components

import kotlinx.css.padding
import kotlinx.css.px
import react.RBuilder

fun RBuilder.pageHeaderTitle(title: String) {
    mTypography(title, MTypographyVariant.h4, color = MTypographyColor.primary) {
        css.padding(16.px)
    }
}