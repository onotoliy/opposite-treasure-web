package com.github.onotoliy.kotlinx.materialui.list

import com.github.onotoliy.kotlinx.materialui.button.MButtonBaseProps
import com.github.onotoliy.kotlinx.materialui.createStyled
import com.github.onotoliy.kotlinx.materialui.mDivider
import com.github.onotoliy.kotlinx.materialui.setStyledPropsAndRunHandler
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.StyledHandler

@JsModule("@material-ui/core/List")
private external val listModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val listComponent: RComponent<MListProps, RState> = listModule.default

interface MListProps : MButtonBaseProps {
    var dense: Boolean
    var disablePadding: Boolean
    var subheader: ReactElement
}

fun RBuilder.mList(
    dense: Boolean = false,
    disablePadding: Boolean = false,
    subheader: ReactElement? = null,
    component: String = "ul",

    className: String? = null,
    handler: StyledHandler<MListProps>? = null
) = createStyled(listComponent) {
    attrs.component = component
    attrs.dense = dense
    attrs.disablePadding = disablePadding
    subheader?.let { attrs.subheader = subheader }

    setStyledPropsAndRunHandler(className, handler)
}

fun RBuilder.mList(
    subheader: String,
    addHeadDivider: Boolean = false,
    dense: Boolean = false,
    disablePadding: Boolean = false,
    component: String = "ul",

    className: String? = null,
    handler: StyledHandler<MListProps>? = null
) = createStyled(listComponent) {
    attrs.component = component
    attrs.dense = dense
    attrs.disablePadding = disablePadding

    @Suppress("UnsafeCastFromDynamic")
    attrs.subheader = mListSubheader(subheader, addAsChild = false)

    if (addHeadDivider) {
        childList.add(mDivider(addAsChild = false))
    }

    setStyledPropsAndRunHandler(className, handler)
}
