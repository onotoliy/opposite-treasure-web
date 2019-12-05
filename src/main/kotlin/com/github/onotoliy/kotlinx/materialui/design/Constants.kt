package com.github.onotoliy.kotlinx.materialui.design

import kotlinx.css.properties.BoxShadow
import kotlinx.css.px
import kotlinx.css.rgba

const val ADFontFamily = "'Lato', sans-serif"

// вычет паддинга
const val ADContentWidth375 = "335px"
// const val ADContentWidth504 = "464px"
const val ADContentWidth504 = "504px"

val ADBoxShadowEasy = BoxShadow(false, 0.px, 2.px, 8.px, 0.px, rgba(0, 0, 0, 0.1))

enum class ADColor(val hex: String) {
    DarkSky("#2D3133"),
    GrayCloud("#697079"),
    FreshApple("#19993C"),
    LightCloud("#C6C6C7"),
    DarkRain("#A4B0BD"),
    CleanRain("#D4DCE4"),
    Fog("#F8F8F8"),
    Sunny("#FFD20D"),
    Tomato("#D32B44"),
    BlueSky("#0770E3"),

    White("#FFFFFF"),
    Black("#000000")
}

fun ADColor.hover() = when (this) {
    ADColor.DarkSky -> "#576373"
    ADColor.GrayCloud -> "#576373"
    ADColor.FreshApple -> "#008A50"
    ADColor.LightCloud -> "#C6C6C7"
    ADColor.DarkRain -> "#A4B0BD"
    ADColor.CleanRain -> "#C7D0DA"
    ADColor.Fog -> "#F8F8F8"
    ADColor.Sunny -> "#FFD20D"
    ADColor.Tomato -> "#BD0854"
    ADColor.BlueSky -> "#005BBF"
    ADColor.White -> "#FFFFFF"
    ADColor.Black -> "#000000"
}

enum class ADLayoutSize {
    WIDTH375,
    WIDTH504
}
