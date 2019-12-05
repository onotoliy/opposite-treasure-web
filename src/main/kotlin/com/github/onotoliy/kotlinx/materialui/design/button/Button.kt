package com.github.onotoliy.kotlinx.materialui.design.button

import com.github.onotoliy.kotlinx.materialui.design.*
import com.github.onotoliy.kotlinx.materialui.design.svg.ADIcon
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVG
import com.github.onotoliy.kotlinx.materialui.design.svg.adSVGWrapper
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.html.BUTTON
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css

enum class ADButtonType(
    val backgroundColor: ADColor,
    val textColor: ADColor,
    val borderColor: ADColor
) {
    Apple(ADColor.FreshApple, ADColor.White, ADColor.FreshApple),
    AppleStroke(ADColor.White, ADColor.FreshApple, ADColor.FreshApple),
    Rain(ADColor.CleanRain, ADColor.GrayCloud, ADColor.CleanRain),
    RainStroke(ADColor.White, ADColor.GrayCloud, ADColor.CleanRain),
    Tomato(ADColor.Tomato, ADColor.White, ADColor.Tomato),
    TomatoStroke(ADColor.White, ADColor.Tomato, ADColor.Tomato)
}

enum class ADButtonSize(val height: Int) {
    Small(38),
    Normal(48)
}

fun RBuilder.adButton(
    label: String,
    type: ADButtonType = ADButtonType.Apple,
    size: ADButtonSize = ADButtonSize.Small,
    icon: ADIcon? = null,
    disabled: Boolean = false,
    fullWidth: Boolean = false,
    width: String? = null,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonBase(disabled, fullWidth, width) {
        css {
            padding(0.px, 20.px)
            height = size.height.px

            backgroundColor = type.backgroundColor.hex()
            border(1.px, BorderStyle.solid, type.borderColor.hex())
            borderRadius = 4.px

            if (!disabled) {
                val hoverColor = type.backgroundColor.hover()
                hover { backgroundColor = Color(hoverColor) }
                focus { backgroundColor = Color(hoverColor) }
            }
        }

        icon?.let {
            adSVGWrapper {
                adSVG(it, type.textColor)
            }
        }
        when (size) {
            ADButtonSize.Small -> adSubtitleB(color = type.textColor) { +label }
            ADButtonSize.Normal -> adBodyR(16, color = type.textColor) { +label }
        }

        builder()
    }
}
