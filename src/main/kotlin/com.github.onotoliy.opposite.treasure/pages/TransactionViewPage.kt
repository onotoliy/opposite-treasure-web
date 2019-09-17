package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.treasure.components.buttonLink
import com.github.onotoliy.opposite.treasure.components.fieldRow
import com.github.onotoliy.opposite.treasure.components.styled.flexColumn
import com.github.onotoliy.opposite.treasure.components.styled.flexRow
import com.github.onotoliy.opposite.treasure.components.styled.shadowContainer
import com.github.onotoliy.opposite.treasure.components.MTypographyVariant
import com.github.onotoliy.opposite.treasure.components.mTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.TransactionsService

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
        shadowContainer {
            mTypography(props.transaction.type.name, MTypographyVariant.h6)
            fieldRow("Название", props.transaction.name)
            props.transaction.event?.let {
                flexRow {
                    flexColumn {
                        +"Мероприятие"
                    }
                    flexColumn {
                        +it.name
                    }
                }
            }
            props.transaction.person?.let {
                flexRow {
                    flexColumn {
                        +"Пользователь"
                    }
                    flexColumn {
                        +it.name
                    }
                }
            }

            fieldRow("Сумма", props.transaction.cash)
            fieldRow("Дата создания", props.transaction.creationDate)
        }

        buttonLink(RoutePath.TRANSACTION_PAGE + "${props.uuid}/edit", "Изменить")
        buttonLink(RoutePath.TRANSACTION_PAGE, "Назад")
    }
}