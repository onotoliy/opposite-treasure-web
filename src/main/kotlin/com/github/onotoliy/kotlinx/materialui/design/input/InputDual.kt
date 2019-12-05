package com.github.onotoliy.kotlinx.materialui.design.input

import com.github.onotoliy.kotlinx.materialui.MTextFieldProps
import com.github.onotoliy.kotlinx.materialui.design.ADColor
import com.github.onotoliy.kotlinx.materialui.design.flexRow
import com.github.onotoliy.kotlinx.materialui.design.hex
import com.github.onotoliy.kotlinx.materialui.form.MFormControlVariant
import com.github.onotoliy.kotlinx.materialui.mTextField
import com.github.onotoliy.kotlinx.materialui.mTextFieldSelect
import kotlinx.css.*
import kotlinx.css.properties.borderLeft
import react.RBuilder
import react.RHandler
import styled.DIVBuilder
import styled.css

fun RBuilder.adInputDual(
    textHandler: RHandler<MTextFieldProps> = {},
    selectHandler: RHandler<MTextFieldProps> = {},
    selectWidth: String = "76px",
    builder: DIVBuilder = {}
) {
    flexRow {
        css {
            position = Position.relative
        }
        val selectWidthLD = LinearDimension(selectWidth)

        mTextField(fullWidth = true) {
            css {
                child("div") {
                    child("input") {
                        paddingRight = 13.px + selectWidthLD
                    }
                }
            }
            textHandler()
        }

        mTextFieldSelect(
                value = "none",
                variant = MFormControlVariant.standard
        ) {
            css {
                specific {
                    position = Position.absolute
                    right = 0.px
                    top = 0.px
                    width = selectWidthLD
                }
                child("div") {
                    paddingLeft = 8.px
                    marginTop = 6.px
                    marginBottom = 6.px
                    borderLeft((0.67).px, BorderStyle.solid, ADColor.CleanRain.hex())
                }
            }
            selectHandler()
        }
        builder()
    }
}
