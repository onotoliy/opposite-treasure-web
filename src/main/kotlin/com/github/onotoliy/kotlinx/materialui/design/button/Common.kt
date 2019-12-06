package com.github.onotoliy.kotlinx.materialui.design.button

import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.svg.*
import com.github.onotoliy.kotlinx.materialui.design.svg.adIconEdit
import kotlinx.html.BUTTON
import react.RBuilder
import styled.StyledDOMBuilder

fun RBuilder.adButtonAdd(
    label: String = "Добавить",
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonText(label, icon = adIconPlus) {
        builder()
    }
}

fun RBuilder.adButtonBack(
    label: String = "Назад",
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonText(label, color = ADColor.DarkSky, icon = adIconSmallBackArrow, width = "100px") {
        builder()
    }
}

fun RBuilder.adButtonCancel(builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    adButton("Отмена", type = ADButtonType.RainStroke) {
        builder()
    }
}

fun RBuilder.adButtonEdit(
    label: String = "Изменить",
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonText(label, color = ADColor.FreshApple, icon = adIconEdit, width = "100px") {
        builder()
    }
}

fun RBuilder.adButtonImport(builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}) {
    adButtonIcon(adIconUpload, ADColor.DarkSky) {
        builder()
    }
}

fun RBuilder.adButtonDelete(
    label: String = "Удалить",
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButtonText(label, color = ADColor.Tomato, icon = adIconClose, width = "100px") {
        builder()
    }
}

fun RBuilder.adButtonSave(
    label: String = "Сохранить",
    disabled: Boolean = false,
    width: String? = null,
    size: ADButtonSize = ADButtonSize.Normal,
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    adButton(label, size = size, icon = adIconOkStatus, disabled = disabled, width = width) {
        builder()
    }
}

fun RBuilder.adButtonSearch(
    iconButton: Boolean = true,
    color: ADColor = ADColor.GrayCloud,
    label: String = "Найти",
    builder: StyledDOMBuilder<BUTTON>.() -> Unit = {}
) {
    if (iconButton) {
        adButtonIcon(adIconSearchSmall, color) {
            builder()
        }
    } else {
        adButtonText(label, color, adIconSearchSmall) {
            builder()
        }
    }
}
