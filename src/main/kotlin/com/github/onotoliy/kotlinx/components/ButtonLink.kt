package com.github.onotoliy.kotlinx.components

import react.RBuilder
import react.router.dom.routeLink

fun RBuilder.buttonLink(
    to: String,
    text: String,
    variant: MButtonVariant = MButtonVariant.outlined
) = routeLink(to, className = "router-link") {
    mButton(text, true, variant = variant, component = "span", tabIndex = -1)
}