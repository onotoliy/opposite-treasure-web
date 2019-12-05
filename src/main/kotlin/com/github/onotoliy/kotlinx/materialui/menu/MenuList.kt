package com.github.onotoliy.kotlinx.materialui.menu

import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.list.MListProps
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler

@JsModule("@material-ui/core/MenuList")
private external val menuListModule: dynamic
private val menuList: RComponent<MMenuListProps, RState> = menuListModule.default

interface MMenuListProps : MListProps {
    var disableListWrap: Boolean
}

/**
 * Includes the props from ListItem
 */
fun RBuilder.mMenuList(
    dense: Boolean = false,
    disablePadding: Boolean = false,
    subheader: ReactElement? = null,
    component: String = "ul",
    disableListWrap: Boolean = false,

    className: String? = null,
    handler: StyledHandler<MMenuListProps>? = null
) = createStyled(menuList) {

    attrs.component = component
    attrs.dense = dense
    attrs.disableListWrap = disableListWrap
    attrs.disablePadding = disablePadding
    subheader?.let { attrs.subheader = subheader }

    setStyledPropsAndRunHandler(className, handler)
}
