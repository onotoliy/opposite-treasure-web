package com.github.onotoliy.kotlinx.materialui.dialog

import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.StyledProps

@JsModule("@material-ui/core/DialogActions")
private external val dialogActionsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val dialogActionsComponent: RComponent<MDialogActionsProps, RState> = dialogActionsModule.default

interface MDialogActionsProps : StyledProps {
    var disableSpacing: Boolean
}

fun RBuilder.mDialogActions(
    disableSpacing: Boolean = false,
    className: String? = null,
    handler: StyledHandler<MDialogActionsProps>
) = createStyled(dialogActionsComponent) {
    attrs.disableSpacing = disableSpacing
    setStyledPropsAndRunHandler(className, handler)
}
