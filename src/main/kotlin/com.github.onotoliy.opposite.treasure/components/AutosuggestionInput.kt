package com.github.onotoliy.opposite.treasure.components

import kotlinx.css.Position
import kotlinx.css.position
import org.w3c.dom.events.Event
import react.*
import styled.styledDiv

interface AutosuggestionInputProps<T> : RProps {
    var label: String
    var inputValue: String
    var onInputChange: (String) -> Unit
    var options: List<T>
    var optionText: (T) -> String
    var onOptionSelect: (T) -> Unit
}

class AutosuggestionInputState : RState {
    var isOpen = false
//    var anchorElement: Node? = null
}

class AutosuggestionInput<T> : RComponent<AutosuggestionInputProps<T>, AutosuggestionInputState>() {
    init {
        state = AutosuggestionInputState()
    }

    private fun handleInputChange(event: Event) {
        val value = event.targetInputValue
//        val anchor = event.currentTarget
        props.onInputChange(value)
        setState {
            isOpen = true
//            anchorElement = anchor as Node
        }
    }

    private fun handleOptionSelect(option: T) {
        props.onOptionSelect(option)
        closeMenu()
    }

    private fun closeMenu() {
        setState {
            isOpen = false
//            anchorElement = null
        }
    }

    override fun RBuilder.render() {
        styledDiv {
            css.position = Position.relative
            mTextField(props.label, props.inputValue, onChange = { e -> handleInputChange(e) }, fullWidth = true)
            if (state.isOpen && props.options.isNotEmpty()) {
                mPaper(square = true) {
                    //                    css {
//                        position = Position.absolute
//                        zIndex = 1
//                        left = 0.px
//                        right = 0.px
//                    }
                    props.options.map { option ->
                        mMenuItem(props.optionText(option), onClick = { handleOptionSelect(option) })
                    }
                }
            }
//            mPopper(state.isOpen && props.options.isNotEmpty(), state.anchorElement) {
//                mPaper(square = true) {
//                    props.options.map { option ->
//                        mMenuItem(props.optionText(option), onClick = { handleOptionSelect(option) })
//                    }
//                }
//            }
//            mMenu(state.isOpen && props.options.isNotEmpty(), state.anchorElement) {
//                props.options.map { option ->
//                    mMenuItem(props.optionText(option), onClick = { handleOptionSelect(option) })
//                }
//            }
        }
    }
}

fun <T> RBuilder.autosuggestionInput(
    label: String = "",
    inputValue: String = "",
    onInputChange: (String) -> Unit = {},
    options: List<T> = emptyList(),
    optionText: (T) -> String = { "Placeholder" },
    onOptionSelect: (T) -> Unit = {}
) = child((AutosuggestionInput<T>())::class) {
    attrs.label = label
    attrs.inputValue = inputValue
    attrs.onInputChange = onInputChange
    attrs.options = options
    attrs.optionText = optionText
    attrs.onOptionSelect = onOptionSelect
}