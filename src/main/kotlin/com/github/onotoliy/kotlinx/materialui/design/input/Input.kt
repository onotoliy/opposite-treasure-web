package com.github.onotoliy.kotlinx.materialui.design.input

import com.github.onotoliy.kotlinx.materialui.design.ADBoxShadowEasy
import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.ADFontFamily
import com.github.onotoliy.kotlinx.materialui.design.hex
import kotlinx.css.*
import kotlinx.css.properties.border
import react.RBuilder
import styled.INPUTBuilder
import styled.css
import styled.styledInput

fun RBuilder.adInput(
    builder: INPUTBuilder
) {
    styledInput {
        css {
            height = 20.px
            padding(8.px, 12.px)
            backgroundColor = ADColor.Fog.hex()
            borderRadius = 4.px
            border = "0"
            fontFamily = ADFontFamily
            fontWeight = FontWeight.bold
            fontSize = 14.px
            outline = Outline.none

            focus {
                backgroundColor = Color.white
                border(1.px, BorderStyle.solid, ADColor.CleanRain.hex())
                boxShadow += ADBoxShadowEasy
            }
        }
        builder()
    }
}
