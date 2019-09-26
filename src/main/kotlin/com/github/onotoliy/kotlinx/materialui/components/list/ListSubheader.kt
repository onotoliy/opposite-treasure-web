package com.github.onotoliy.kotlinx.materialui.components.list

import com.github.onotoliy.kotlinx.materialui.components.MButtonBaseProps
import com.github.onotoliy.kotlinx.materialui.components.createStyled
import com.github.onotoliy.kotlinx.materialui.components.setStyledPropsAndRunHandler
import com.github.onotoliy.kotlinx.materialui.components.spacingUnits
import kotlinx.css.lineHeight
import kotlinx.css.padding
import kotlinx.css.properties.LineHeight
import react.RBuilder
import react.RComponent
import react.RState
import styled.StyledHandler
import styled.css

@JsModule("@material-ui/core/ListSubheader")
private external val listSubheaderModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val listSubheaderComponent: RComponent<MListSubheaderProps, RState> = listSubheaderModule.default

@Suppress("EnumEntryName")
enum class MListSubheaderColor {
    default, primary, inherit
}

interface MListSubheaderProps : MButtonBaseProps {
    var color: String
    var disableGutters: Boolean
    var disableSticky: Boolean
    var inset: Boolean
}

/**
 * A list sub-appHeader which allows you to pass a string to use for the heading.
 */
fun RBuilder.mListSubheader(
    heading: String,
    color: MListSubheaderColor = MListSubheaderColor.default,
    component: String? = null,
    disableGutters: Boolean = false,
    disableSticky: Boolean = false,
    inset: Boolean = false,
    compact: Boolean = false,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MListSubheaderProps>? = null
) = createStyled(listSubheaderComponent, addAsChild) {
    attrs.color = color.toString()
    component?.let { attrs.component = component }
    attrs.disableGutters = disableGutters
    attrs.disableSticky = disableSticky
    attrs.inset = inset

    childList.add(heading)

    if (compact) {
        css {
            lineHeight = LineHeight("1em")
            padding(vertical = 1.spacingUnits)
        }
    }

    setStyledPropsAndRunHandler(className, handler)
}

/**
 * The 'standard' list sub-appHeader... you need to create a child item for the heading.
 */
fun RBuilder.mListSubheader(
    color: MListSubheaderColor = MListSubheaderColor.default,
    component: String? = null,
    disableGutters: Boolean = false,
    disableSticky: Boolean = false,
    inset: Boolean = false,

    addAsChild: Boolean = true,
    className: String? = null,
    handler: StyledHandler<MListSubheaderProps>? = null
) = createStyled(listSubheaderComponent, addAsChild) {
    attrs.color = color.toString()
    component?.let { attrs.component = component }
    attrs.disableGutters = disableGutters
    attrs.disableSticky = disableSticky
    attrs.inset = inset

    setStyledPropsAndRunHandler(className, handler)
}
