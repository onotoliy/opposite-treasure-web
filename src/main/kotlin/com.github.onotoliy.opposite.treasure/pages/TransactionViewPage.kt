package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.treasure.components.MTypographyVariant
import com.github.onotoliy.opposite.treasure.components.buttonLink
import com.github.onotoliy.opposite.treasure.components.fieldRow
import com.github.onotoliy.opposite.treasure.components.mTypography
import com.github.onotoliy.opposite.treasure.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.fieldRowLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

interface TransactionViewPageProps : RProps {
    var scope: CoroutineScope
    var uuid: String
    var transaction: Transaction
}

class TransactionViewPage : RComponent<TransactionViewPageProps, RState>() {
    override fun componentDidMount() {
        props.scope.launch {
            TransactionsService.loadTransaction(uuid = props.uuid)
        }
    }

    override fun RBuilder.render() {
        buttonLink(RoutePath.TRANSACTION_PAGE + "${props.uuid}/edit", "Изменить")
        buttonLink(RoutePath.TRANSACTION_PAGE, "Назад")

        shadowContainer {
            mTypography(props.transaction.type.name, MTypographyVariant.h6)
            fieldRow("Название", props.transaction.name)
            props.transaction.event?.let {
                fieldRowLink("Мероприятие", RoutePath.EVENT_PAGE + it.uuid, it.name)
            }
            props.transaction.person?.let {
                fieldRowLink("Пользователь", RoutePath.DEPOSIT_PAGE + it.uuid, it.name)
            }
            fieldRow("Сумма", props.transaction.cash)
            fieldRow("Дата создания", props.transaction.creationDate)
        }
    }
}