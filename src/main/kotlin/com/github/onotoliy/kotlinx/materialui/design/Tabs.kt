package com.github.onotoliy.kotlinx.materialui.design

import com.github.onotoliy.kotlinx.materialui.*
import kotlinx.css.*
import org.w3c.dom.events.Event
import react.RBuilder
import styled.StyledHandler
import styled.css

// Обертка стилями для Material UI Tabs
enum class ADTabsSize(val height: Int, val fontSize: Int) {
    Large(34, 18),
    Medium(28, 16),
    Small(22, 12)
}

fun RBuilder.adTabs(
    value: Any = false,
    onChange: (event: Event, indexValue: Any) -> Unit,
    size: ADTabsSize = ADTabsSize.Large,
    margin: String = "0 0 16px 0",
    handler: StyledHandler<MTabsProps>
) {
    mTabs(
            value,
            onChange = onChange,
            textColor = MTabTextColor.primary,
            indicatorColor = MTabIndicatorColor.primary
    ) {
        css {
            specific {
                minHeight = 0.px
                height = size.height.px
                this.margin = margin
            }
        }
        handler()
    }
}

fun RBuilder.adTab(
    label: String,
    value: Any,
    size: ADTabsSize = ADTabsSize.Large
) {
    mTab(label, value) {
        css {
            specific {
                minHeight = 0.px
                textTransform = TextTransform.none
                minWidth = 0.px
                paddingBottom = 0.px
                paddingTop = 0.px

                fontSize = size.fontSize.px
                height = size.height.px
                color = ADColor.GrayCloud.hex()
            }
        }
    }
}
