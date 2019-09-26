package com.github.onotoliy.kotlinx.materialui.components.list

import com.github.onotoliy.kotlinx.materialui.components.MButtonBaseProps
import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.mIcon
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler

@JsModule("@material-ui/core/ListItemIcon")
private external val listItemIconModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val listItemIconComponent: RComponent<MButtonBaseProps, RState> = listItemIconModule.default

fun RBuilder.mListItemIcon(
    iconName: String? = null,
    className: String? = null,
    handler: StyledHandler<MButtonBaseProps>? = null
) = createStyled(listItemIconComponent) {
    iconName?.let { mIcon(iconName) }
    setStyledPropsAndRunHandler(className, handler)
}
