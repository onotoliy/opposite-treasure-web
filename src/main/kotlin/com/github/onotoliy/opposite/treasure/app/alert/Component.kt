package com.github.onotoliy.opposite.treasure.app.alert

import com.github.onotoliy.kotlinx.materialui.MTypographyColor
import com.github.onotoliy.kotlinx.materialui.button.smallDeleteButton
import com.github.onotoliy.kotlinx.materialui.mTypography
import com.github.onotoliy.opposite.treasure.services.system.SystemService
import kotlinx.css.Display
import kotlinx.css.display
import react.RBuilder

fun RBuilder.appAlertComponent(message: String) {
    appAlertWrapper {
        css.display = if (message.isNotBlank()) Display.flex else Display.none
        mTypography(message, color = MTypographyColor.secondary)
        smallDeleteButton({ SystemService.setAlert("") })
    }
}
