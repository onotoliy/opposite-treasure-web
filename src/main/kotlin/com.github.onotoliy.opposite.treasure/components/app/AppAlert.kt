package com.github.onotoliy.opposite.treasure.components.app

import com.github.onotoliy.opposite.treasure.components.controls.base.smallDeleteButton
import com.github.onotoliy.opposite.treasure.components.MTypographyColor
import com.github.onotoliy.opposite.treasure.components.mTypography
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.css.properties.boxShadow
import react.RBuilder
import com.github.onotoliy.opposite.treasure.services.system.SystemService
import styled.css
import styled.styledDiv

fun RBuilder.appAlert(message: String) {
    styledDiv {
        css {
            display = if (message.isNotBlank()) Display.flex else Display.none
            justifyContent = JustifyContent.center
            alignItems = Align.center
            position = Position.fixed
            zIndex = 1300 // more than header
            width = 50.pct
            top = 15.px
            left = 25.pct
            right = 25.pct
            height = 30.px
            border(1.px, BorderStyle.solid, Color.red)
            borderRadius = 6.px
            boxShadow(Color("#267DCE").withAlpha(0.15), 0.px, 5.px, 10.px, 0.px)
            overflow = Overflow.hidden
            paddingLeft = 15.px
        }
        mTypography(message, color = MTypographyColor.secondary)
        smallDeleteButton({ SystemService.setAlert("") })
    }
}
