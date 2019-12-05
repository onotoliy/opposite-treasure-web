package com.github.onotoliy.kotlinx.materialui

import react.RBuilder

fun RBuilder.pageHeaderTitle(title: String) {
    mTypography(title, MTypographyVariant.h4, color = MTypographyColor.primary)
}

fun RBuilder.blockTitle(title: String) {
    mTypography(title, MTypographyVariant.h6, color = MTypographyColor.primary)
}

fun RBuilder.sectionTitle(title: String) {
    mTypography(title, color = MTypographyColor.primary)
}

fun RBuilder.sectionListTitle(title: String) {
    mTypography(title, color = MTypographyColor.primary)
}
