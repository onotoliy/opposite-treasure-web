package com.github.onotoliy.kotlinx.materialui.components.dialog

import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/DialogContent")
private external val dialogContentModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val dialogContentComponent: RComponent<StyledProps, RState> = dialogContentModule.default

fun RBuilder.mDialogContent(
    className: String? = null,
    handler: StyledHandler<StyledProps>
) = createStyled(dialogContentComponent) {

    setStyledPropsAndRunHandler(className, handler)
}
