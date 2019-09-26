package com.github.onotoliy.kotlinx.materialui.components.card

import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/Card")
private external val cardModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val cardComponent: RComponent<MCardProps, RState> = cardModule.default

interface MCardProps : StyledProps {
    var raised: Boolean
}

fun RBuilder.mCard(
    raised: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MCardProps>? = null
) = createStyled(cardComponent) {
    attrs.raised = raised

    setStyledPropsAndRunHandler(className, handler)
}
