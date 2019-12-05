package com.github.onotoliy.kotlinx.materialui.dialog

import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/DialogContent")
private external val dialogContentModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val dialogContentComponent: RComponent<MDialogContentProps, RState> = dialogContentModule.default

interface MDialogContentProps : StyledProps {
    var dividers: Boolean
}

fun RBuilder.mDialogContent(
    dividers: Boolean = false,
    className: String? = null,
    handler: StyledHandler<MDialogContentProps>
) = createStyled(dialogContentComponent) {
    attrs.dividers = dividers
    setStyledPropsAndRunHandler(className, handler)
}
