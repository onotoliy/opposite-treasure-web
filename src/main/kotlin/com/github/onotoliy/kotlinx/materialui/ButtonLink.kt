package com.github.onotoliy.kotlinx.materialui

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.button.ADButtonType
import com.github.onotoliy.kotlinx.materialui.design.button.adButton
import com.github.onotoliy.kotlinx.materialui.design.button.adButtonText
import com.github.onotoliy.kotlinx.materialui.design.svg.ADIcon
import react.RBuilder
import react.router.dom.routeLink

fun RBuilder.buttonLinkText(
    to: String,
    label: String,
    color: ADColor = ADColor.FreshApple,
    icon: ADIcon? = null,
    disabled: Boolean = false,
    fullWidth: Boolean = false,
    width: String = "150px"
) = routeLink(to, className = "router-link") {
    adButtonText(label, width = width, color = color, icon = icon, disabled = disabled, fullWidth = fullWidth)
}

fun RBuilder.buttonLink(
    to: String,
    label: String,
    type: ADButtonType = ADButtonType.Apple,
    icon: ADIcon? = null,
    disabled: Boolean = false,
    fullWidth: Boolean = false,
    width: String = "150px"
) = routeLink(to, className = "router-link") {
    adButton(label, width = width, type = type, icon = icon, disabled = disabled, fullWidth = fullWidth)
}
