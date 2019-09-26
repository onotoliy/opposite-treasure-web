package com.github.onotoliy.kotlinx.components.transitions

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
import kotlinx.css.LinearDimension
import kotlinx.css.px
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/Collapse")
private external val collapseModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val collapseComponent: RComponent<MCollapseProps, RState> = collapseModule.default

external interface MCollapseProps : MTransitionProps {
    var collapsedHeight: String
    var component: String
}

fun RBuilder.mCollapse(
    show: Boolean = false,
    collapsedHeight: LinearDimension = 0.px,
    component: String = "div",
    timeout: TransitionTimeout? = null,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MCollapseProps>? = null
) = createStyled(collapseComponent, addAsChild) {
    attrs.collapsedHeight = collapsedHeight.toString()
    attrs.component = component
    attrs.show = show
    timeout?.let { attrs.timeout = timeout.value() }

    setStyledPropsAndRunHandler(className, handler)
}
