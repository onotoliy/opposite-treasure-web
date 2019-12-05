package com.github.onotoliy.kotlinx.materialui.design

import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.SPAN
import react.RBuilder
import styled.*

val COLOR_TYPOGRAPHY_DEFAULT = ADColor.GrayCloud

fun RBuilder.adH1(
    color: ADColor = COLOR_TYPOGRAPHY_DEFAULT,
    margin: String? = null,
    builder: StyledDOMBuilder<H1>.() -> Unit = {}
) {
    styledH1 {
        css {
            fontFamily = ADFontFamily
            fontSize = 32.px
            lineHeight = LineHeight("140%")
            this.color = color.hex()
            margin?.let { this.margin = it }
        }
        builder()
    }
}

fun RBuilder.adH2(
    color: ADColor = ADColor.DarkSky,
    margin: String = "0",
    builder: StyledDOMBuilder<H2>.() -> Unit = {}
) {
    styledH2 {
        css {
            fontFamily = ADFontFamily
            fontSize = 24.px
            lineHeight = LineHeight("140%")
            this.color = color.hex()
            this.margin = margin
        }
        builder()
    }
}

fun RBuilder.adSubtitleB(
    fontSize: Int = 14,
    color: ADColor = ADColor.DarkSky,
    margin: String? = null,
    builder: StyledDOMBuilder<SPAN>.() -> Unit = {}
) {
    styledSpan {
        css {
            fontFamily = ADFontFamily
            fontWeight = FontWeight.bold
            this.fontSize = fontSize.px
            lineHeight = LineHeight("140%")
            this.color = color.hex()
            margin?.let { this.margin = it }
        }
        builder()
    }
}

fun RBuilder.adBodyR(
    fontSize: Int = 14,
    color: ADColor = COLOR_TYPOGRAPHY_DEFAULT,
    margin: String? = null,
    builder: StyledDOMBuilder<SPAN>.() -> Unit = {}
) {
    styledSpan {
        css {
            fontFamily = ADFontFamily
            this.fontSize = fontSize.px
            lineHeight = LineHeight("140%")
            this.color = color.hex()
            margin?.let { this.margin = it }
        }
        builder()
    }
}

fun RBuilder.adSmallBody(
    color: ADColor = COLOR_TYPOGRAPHY_DEFAULT,
    margin: String? = null,
    builder: StyledDOMBuilder<SPAN>.() -> Unit = {}
) {
    styledSpan {
        css {
            fontFamily = ADFontFamily
            fontSize = 12.px
            lineHeight = LineHeight("120%")
            this.color = color.hex()
            margin?.let { this.margin = it }
        }
        builder()
    }
}

fun RBuilder.adNotice(
    color: ADColor = COLOR_TYPOGRAPHY_DEFAULT,
    margin: String? = null,
    builder: StyledDOMBuilder<SPAN>.() -> Unit = {}
) {
    styledSpan {
        css {
            fontFamily = ADFontFamily
            fontSize = 10.px
            lineHeight = LineHeight("120%")
            this.color = color.hex()
            margin?.let { this.margin = it }
        }
        builder()
    }
}
