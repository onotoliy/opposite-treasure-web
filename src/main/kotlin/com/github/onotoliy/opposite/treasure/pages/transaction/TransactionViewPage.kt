package com.github.onotoliy.opposite.treasure.pages.transaction

import com.github.onotoliy.kotlinx.keycloak.Auth
import com.github.onotoliy.kotlinx.materialui.*
import com.github.onotoliy.kotlinx.materialui.button.mButtonGroup
import com.github.onotoliy.kotlinx.materialui.design.button.adButtonDelete
import com.github.onotoliy.kotlinx.materialui.design.shadowWrapper
import com.github.onotoliy.kotlinx.materialui.design.svg.adIconEdit
import com.github.onotoliy.kotlinx.materialui.design.svg.adIconSmallBackArrow
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.kotlinx.toSimpleDate
import com.github.onotoliy.opposite.data.Transaction
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsApi
import com.github.onotoliy.opposite.treasure.services.transaction.TransactionsService
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

interface TransactionViewPageProps : RProps {
    var scope: CoroutineScope
    var history: RouteResultHistory
    var uuid: String
    var transaction: Transaction
    var roles: List<String>
}

class TransactionViewPage : RComponent<TransactionViewPageProps, RState>() {
    override fun componentDidMount() {
        Configuration.scope.launch {
            TransactionsService.loadTransaction(uuid = props.uuid)
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
                                TransactionsApi.delete(props.uuid)
                                TransactionsService.loadTransactions()
                            }
                            props.history.push(RoutePath.TRANSACTION_PAGE)
                        }
                    }
                    buttonLinkText(
                            to = RoutePath.TRANSACTION_PAGE + "${props.uuid}/edit",
                            label = "Изменить",
                            icon = adIconEdit,
                            width = "100px")
                }
                buttonLinkText(
                        to = RoutePath.TRANSACTION_PAGE,
                        label = "Удалить",
                        icon = adIconSmallBackArrow,
                        width = "100px")
            }
        }

        shadowWrapper {
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
