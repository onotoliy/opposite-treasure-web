package com.github.onotoliy.kotlinx.materialui

import com.github.onotoliy.kotlinx.materialui.design.button.adButtonAdd
import com.github.onotoliy.kotlinx.materialui.menu.mMenu
import com.github.onotoliy.kotlinx.materialui.menu.mMenuItem
import kotlinx.html.js.onClickFunction
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import react.*
import react.dom.div

interface ButtonDropdownProps : RProps {
    var label: String
    var menuOptions: List<ButtonDropdownMenuOptions>
    var disabled: Boolean
}

class ButtonDropdownState : RState {
    var anchorElement: Node? = null
}

class ButtonDropdownMenuOptions(
    val label: String,
    val onClick: () -> Unit
)

class ButtonDropdown : RComponent<ButtonDropdownProps, ButtonDropdownState>() {
    init {
        state = ButtonDropdownState()
    }

    private fun openMenu(event: Event) {
        val element = event.currentTarget.asDynamic() as? Node
        setState {
            anchorElement = element
        }
    }

    private fun closeMenu() {
        setState {
            anchorElement = null
        }
    }

    override fun RBuilder.render() {
        div {
            adButtonAdd(props.label) {
                attrs.onClickFunction = { openMenu(it) }
            }
            mMenu(
                    open = state.anchorElement != null,
                    anchorElement = state.anchorElement,
                    onClose = { _, _ -> closeMenu() }
            ) {
                props.menuOptions.map { option ->
                    mMenuItem(
                            option.label,
                            onClick = {
                                option.onClick()
                                closeMenu()
                            }
                    )
                }
            }
        }
    }
}

fun RBuilder.buttonDropdown(
    label: String = "",
    menuOptions: List<ButtonDropdownMenuOptions> = emptyList(),
    disabled: Boolean = false
) = child(ButtonDropdown::class) {
    attrs.label = label
    attrs.menuOptions = menuOptions
    attrs.disabled = disabled
}
