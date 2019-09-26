package com.github.onotoliy.kotlinx.materialui.components

import com.github.onotoliy.kotlinx.materialui.components.dialog.mDialog
import com.github.onotoliy.kotlinx.materialui.components.dialog.mDialogActions
import com.github.onotoliy.kotlinx.materialui.components.dialog.mDialogContent
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