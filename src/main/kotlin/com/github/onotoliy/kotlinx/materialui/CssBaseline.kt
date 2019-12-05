package com.github.onotoliy.kotlinx.materialui

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

@JsModule("@material-ui/core/CssBaseline")
private external val cssBaselineModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val cssBaselineComponent: RComponent<RProps, RState> = cssBaselineModule.default

fun RBuilder.mCssBaseline() = child(cssBaselineComponent) {}
