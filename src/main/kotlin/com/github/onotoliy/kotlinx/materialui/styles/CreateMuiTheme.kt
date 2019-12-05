package com.github.onotoliy.kotlinx.materialui.styles

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.ADFontFamily
import kotlin.js.json
import kotlinext.js.jsObject
import react.RProps

// @JsModule("@material-ui/core/styles/themeListener")
// private external val themeListener: dynamic

/**
 * ts2kt types with tweaks from material-ui/styles/createMuiTheme
 */
external interface ThemeOptions {
    var shape: ShapeOptions
    var breakpoints: Breakpoints
    var direction: dynamic /* String /* "ltr" */ | String /* "rtl" */ */ get() = definedExternally; set(value) = definedExternally
    var mixins: dynamic
    var overrides: dynamic
    var palette: PaletteOptions? get() = definedExternally; set(value) = definedExternally
    var props: RProps
    var shadows: dynamic
    var spacing: dynamic
    var transitions: TransitionsOptions? get() = definedExternally; set(value) = definedExternally
//    var typography: dynamic /* TypographyOptions | (palette: Palette) -> TypographyOptions */ get() = definedExternally; set(value) = definedExternally
    var typography: TypographyOptions? get() = definedExternally; set(value) = definedExternally
    var zIndex: dynamic
}

external interface Theme {
    var shape: ShapeOptions
    var breakpoints: Breakpoints
    var direction: dynamic /* String /* "ltr" */ | String /* "rtl" */ */
    var mixins: Mixins
    var overrides: dynamic
    var palette: Palette
    var props: RProps
    var shadows: dynamic
    var spacing: Spacing
    var transitions: Transitions
    var typography: Typography
    var zIndex: ZIndex
}

@JsModule("@material-ui/core/styles/createMuiTheme")
private external val createMuiThemeModule: dynamic

@Suppress("UnsafeCastFromDynamic")
fun createMuiTheme(themeOptions: ThemeOptions? = null, typographyWarningsOff: Boolean = true): Theme {

    // We shall just use default (i.e. blank) options if none are provided
    val ourThemeOptions = themeOptions ?: jsObject { }

    if (typographyWarningsOff) {
        // Material UI 3.3.2 (or a bit earlier) has depreciated some typography enums. We do the following
        // so we don't get any warning messages even when using the new enums.
        if (ourThemeOptions.typography == undefined) {
            ourThemeOptions.typography = jsObject { }
        }

        ourThemeOptions.typography?.useNextVariants = true
    }

    // theme customizing
    ourThemeOptions.typography?.fontFamily = ADFontFamily
    ourThemeOptions.palette = jsObject {
        primary = jsObject<PaletteColor> {
            main = ADColor.FreshApple.hex
        }
        error = jsObject<PaletteColor> {
            main = ADColor.Tomato.hex
        }
    }
    ourThemeOptions.overrides = themeOverrides
    return createMuiThemeModule.default(ourThemeOptions)
}

private val themeOverrides = json(
        "MuiInputBase" to json(
                "input" to json(
                        "height" to "22px",
                        "color" to ADColor.DarkSky.hex,
                        "lineHeight" to "140%"
                ),
                // adInputDual select
                "multiline" to json(
                        "&\$marginDense" to json(
                                "paddingTop" to "7px",
                                "paddingBottom" to "7px"
                        )
                )
        ),
        "MuiOutlinedInput" to json(
                "inputMarginDense" to json(
                        "paddingTop" to "13px",
                        "paddingBottom" to "13px",
                        "paddingRight" to "12px",
                        "paddingLeft" to "12px"
                ),
                "multiline" to json(
                        "padding" to "12px",
                        "&\$marginDense" to json(
                            "paddingTop" to "13px",
                            "paddingBottom" to "13px"
                        )
                ),
                "notchedOutline" to json(
                        "borderColor" to ADColor.DarkRain.hex
                )
        ),
        "MuiInputLabel" to json(
                "outlined" to json(
                        "&\$marginDense" to json(
                                "transform" to "translate(14px, 15px) scale(1)"
                        )
                )
        ),
        "MuiFormLabel" to json(
                "root" to json(
                        "color" to ADColor.DarkRain.hex
                )
        ),
        "MuiSelect" to json(
                "icon" to json(
                        "color" to "#A4B0BD"
//                        "right" to "12px"
                )
        ),
        "MuiTableCell" to json(
                "root" to json(
                        "&:last-child" to json(
                                "paddingRight" to "0"
                        )
                )
        )
)
