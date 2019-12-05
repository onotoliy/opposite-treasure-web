package com.github.onotoliy.kotlinx.materialui

import com.github.onotoliy.kotlinx.materialui.button.mButton
import com.github.onotoliy.kotlinx.materialui.dialog.*
import react.RBuilder

fun RBuilder.confirmDialog(
    isOpen: Boolean,
    message: String = "Вы уверены?",
    onConfirm: () -> Unit = {},
    onCancel: () -> Unit = {},
    title: String = ""
) = mDialog(isOpen) {
    mDialogTitle(title)
    mDialogContent {
        mDialogContentText(message)
    }
    mDialogActions {
        mButton("Да", onClick = { onConfirm() })
        mButton("Нет", onClick = { onCancel() })
    }
}
