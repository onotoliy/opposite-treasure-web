package com.github.onotoliy.opposite.treasure.pages.event

import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.materialui.*
import com.github.onotoliy.kotlinx.materialui.button.mButtonGroup
import com.github.onotoliy.kotlinx.materialui.design.button.adButtonDelete
import com.github.onotoliy.kotlinx.materialui.design.shadowWrapper
import com.github.onotoliy.kotlinx.materialui.design.svg.adIconEdit
import com.github.onotoliy.kotlinx.materialui.design.svg.adIconSmallBackArrow
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsApi
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.FlexDirection
import kotlinx.css.flexDirection
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.RouteResultHistory

interface EventViewPageProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
    var event: Event
    var roles: List<String>
}

class EventViewPage : RComponent<EventViewPageProps, RState>() {
    override fun componentDidMount() {
        Configuration.scope.launch {
            EventsService.loadEvent(uuid = props.uuid)
        }
    }

    override fun RBuilder.render() {
        shadowWrapper {
            css.flexDirection = FlexDirection.rowReverse
            mButtonGroup {
                if (Auth.isModifier(props.roles)) {
                    adButtonDelete {
                        attrs.onClickFunction = {
                            Configuration.scope.launch {
                                EventsApi.delete(props.uuid)
                                EventsService.loadEvents()
                            }
                            props.history.push(RoutePath.EVENT_PAGE)
                        }
                    }
                    buttonLinkText(
                            to = RoutePath.EVENT_PAGE + "${props.uuid}/edit",
                            label = "Изменить",
                            icon = adIconEdit,
                            width = "100px")
                }
                buttonLinkText(
                        to = RoutePath.EVENT_PAGE,
                        label = "Удалить",
                        icon = adIconSmallBackArrow,
                        width = "100px")
            }
        }

        shadowWrapper {
            mTypography("Мероприятие", MTypographyVariant.h6)
            fieldRow("Название", props.event.name)
            fieldRow("Взнос с одного человека", props.event.contribution)
            fieldRow("Общая сумма", props.event.total)
            fieldRow("Дата создания", props.event.creationDate.toSimpleDate())
            fieldRow("Сдать до", props.event.deadline.toSimpleDate())
        }
    }
}
