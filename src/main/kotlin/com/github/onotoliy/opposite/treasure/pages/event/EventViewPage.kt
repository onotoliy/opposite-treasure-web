package com.github.onotoliy.opposite.treasure.pages.event

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.kotlinx.components.*
import com.github.onotoliy.kotlinx.components.styled.flexRow
import com.github.onotoliy.kotlinx.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.event.EventsService
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsApi
import com.github.onotoliy.kotlinx.toSimpleDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.FlexDirection
import kotlinx.css.flexDirection
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
}

class EventViewPage : RComponent<EventViewPageProps, RState>() {
    override fun componentDidMount() {
        props.scope.launch {
            EventsService.loadEvent(uuid = props.uuid)
        }
    }

    override fun RBuilder.render() {
        flexRow {
            css.flexDirection = FlexDirection.rowReverse
            mButton("Удалить", color = MColor.secondary, onClick = {
                props.scope.launch {
                    TransactionsApi.delete(props.uuid)
                }
                props.history.push(RoutePath.EVENT_PAGE)
            })
            buttonLink(RoutePath.EVENT_PAGE + "${props.uuid}/edit", "Изменить")
            buttonLink(RoutePath.EVENT_PAGE, "Назад")
        }

        shadowContainer {
            mTypography("Мероприятие", MTypographyVariant.h6)
            fieldRow("Название", props.event.name)
            fieldRow("Взнос с одного человека", props.event.contribution)
            fieldRow("Общая сумма", props.event.total)
            fieldRow("Дата создания", props.event.creationDate.toSimpleDate())
            fieldRow("Сдать до", props.event.deadline.toSimpleDate())
        }
    }
}