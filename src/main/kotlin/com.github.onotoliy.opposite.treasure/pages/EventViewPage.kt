package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Event
import com.github.onotoliy.opposite.treasure.components.MTypographyVariant
import com.github.onotoliy.opposite.treasure.components.buttonLink
import com.github.onotoliy.opposite.treasure.components.fieldRow
import com.github.onotoliy.opposite.treasure.components.mTypography
import com.github.onotoliy.opposite.treasure.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.EventsService
import com.github.onotoliy.opposite.treasure.utils.toReadableDateString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

interface EventViewPageProps : RProps {
    var scope: CoroutineScope
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
        buttonLink(RoutePath.EVENT_PAGE + "${props.uuid}/edit", "Изменить")
        buttonLink(RoutePath.EVENT_PAGE, "Назад")

        shadowContainer {
            mTypography("Мероприятие", MTypographyVariant.h6)
            fieldRow("Название", props.event.name)
            fieldRow("Взнос с одного человека", props.event.contribution)
            fieldRow("Общая сумма", props.event.total)
            fieldRow("Дата создания", props.event.creationDate.toReadableDateString())
            fieldRow("Сдать до", props.event.deadline.toReadableDateString())
        }
    }
}