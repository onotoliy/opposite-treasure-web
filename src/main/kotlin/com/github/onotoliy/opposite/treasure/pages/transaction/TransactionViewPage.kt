package com.github.onotoliy.opposite.treasure.pages.transaction

import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.kotlinx.components.*
import com.github.onotoliy.kotlinx.components.styled.flexRow
import com.github.onotoliy.kotlinx.components.styled.shadowContainer
import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.treasure.fieldRowLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsApi
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.css.FlexDirection
import kotlinx.css.flexDirection
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.RouteResultHistory

interface TransactionViewPageProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
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
        flexRow {
            css.flexDirection = FlexDirection.rowReverse
            if (Auth.isModifier()) {
                mButton("Удалить", color = MColor.secondary, onClick = {
                    props.scope.launch {
                        TransactionsApi.delete(props.uuid)
                        TransactionsService.loadTransactions()
                    }
                    props.history.push(RoutePath.TRANSACTION_PAGE)
                })
                buttonLink(RoutePath.TRANSACTION_PAGE + "${props.uuid}/edit", "Изменить")
            }
            buttonLink(RoutePath.TRANSACTION_PAGE, "Назад")
        }

        shadowContainer {
            mTypography(props.transaction.type.label, MTypographyVariant.h6)
            fieldRow("Название", props.transaction.name)
            props.transaction.event?.let {
                fieldRowLink("Мероприятие", RoutePath.EVENT_PAGE + it.uuid, it.name)
            }
            props.transaction.person?.let {
                fieldRowLink("Пользователь", RoutePath.DEPOSIT_PAGE + it.uuid, it.name)
            }
            fieldRow("Сумма", props.transaction.cash)
            fieldRow("Дата создания", props.transaction.creationDate.toSimpleDate())
        }
    }
}