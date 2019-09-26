package com.github.onotoliy.opposite.treasure

import com.github.onotoliy.kotlinx.components.MTypographyColor
import com.github.onotoliy.kotlinx.components.mTypography
import com.github.onotoliy.kotlinx.components.styled.flexRow
import kotlinx.css.FlexBasis
import kotlinx.css.flexBasis
import kotlinx.css.padding
import kotlinx.css.px
import react.RBuilder
import react.router.dom.routeLink

fun RBuilder.fieldRowLink(label: String, url: String, name: String? = "") {
    flexRow {
        css.padding(8.px, 0.px)
        mTypography(color = MTypographyColor.textSecondary) {
            css.flexBasis = FlexBasis("300px")
            +label
        }
        routeLink(url, className = "router-link") {
            +(if (!name.isNullOrBlank()) name else "—")
        }
    }
}