package com.github.onotoliy.kotlinx.materialui.card

import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/CardActions")
private external val cardActionsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val cardActionsComponent: RComponent<MCardActionsProps, RState> = cardActionsModule.default

interface MCardActionsProps : StyledProps {
    var disableSpacing: Boolean
}

fun RBuilder.mCardActions(
    disableSpacing: Boolean = false,
    handler: StyledHandler<MCardActionsProps>?
) = createStyled(cardActionsComponent) {
    attrs.disableSpacing = disableSpacing
    setStyledPropsAndRunHandler(null, handler)
}
