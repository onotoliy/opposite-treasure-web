package com.github.onotoliy.kotlinx.components.dialog

import com.github.onotoliy.kotlinx.components.createStyled
import com.github.onotoliy.kotlinx.components.setStyledPropsAndRunHandler
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
//    var disableActionSpacing: Boolean
}

fun RBuilder.mDialogActions(
//    disableActionSpacing: Boolean = false,

    className: String? = null,
    handler: StyledHandler<MDialogActionsProps>
) = createStyled(dialogActionsComponent) {
    //    attrs.disableActionSpacing = disableActionSpacing

    setStyledPropsAndRunHandler(className, handler)
}
