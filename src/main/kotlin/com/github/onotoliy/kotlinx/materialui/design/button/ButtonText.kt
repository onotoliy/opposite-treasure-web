package com.github.onotoliy.kotlinx.materialui.design.button

import com.github.onotoliy.kotlinx.materialui.design.*
import com.github.onotoliy.kotlinx.materialui.design.svg.ADIcon
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVG
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVGWrapper
import kotlinx.css.*
import kotlinx.html.BUTTON
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css

fun RBuilder.adButtonText(
    label: String,
    color: ADColor = ADColor.FreshApple,
    icon: ADIcon? = null,
    disabled: Boolean = false,
    fullWidth: Boolean = false,
    width: String? = null,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonBase(disabled, fullWidth, width) {
        css {
            padding(0.px, 4.px)
            backgroundColor = ADColor.White.hex()
            border = "0"

            if (!disabled) {
                hover {
                    this.color = Color(color.hover())
                }
            }
        }

        icon?.let {
            adSVGWrapper {
                adSVG(it, color)
            }
        }
        adBodyR(14, color = color) { +label }

        builder()
    }
}
