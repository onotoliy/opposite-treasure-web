package com.github.onotoliy.opposite.treasure.components

import com.github.onotoliy.opposite.treasure.components.dialog.mDialog
import com.github.onotoliy.opposite.treasure.components.dialog.mDialogActions
import com.github.onotoliy.opposite.treasure.components.dialog.mDialogContent
import react.RBuilder

fun RBuilder.confirmDialog(
    isOpen: Boolean,
    message: String = "Вы уверены?",
    onConfirm: () -> Unit = {},
    onCancel: () -> Unit = {}
) = mDialog(isOpen) {
    mDialogContent {
        mTypography(message)
    }
    mDialogActions {
        mButton("Да", onClick = { onConfirm() })
        mButton("Нет", onClick = { onCancel() })
    }
}