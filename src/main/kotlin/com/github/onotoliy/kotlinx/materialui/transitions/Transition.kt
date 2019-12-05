package com.github.onotoliy.kotlinx.materialui.transitions

import kotlin.reflect.KClass
import react.RComponent
import react.RState
import styled.StyledProps

/**
 * We reference the show (or 'in' in the Material UI docs) prop in some generic transition situations, for example
 * see TestMenus and TestSnackbar
 */
external interface MTransitionProps : StyledProps {
    @JsName("in")
    var show: Boolean
}

typealias TransitionComponent = KClass<out RComponent<MTransitionProps, RState>>
