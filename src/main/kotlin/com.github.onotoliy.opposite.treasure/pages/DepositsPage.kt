package com.github.onotoliy.opposite.treasure.pages

import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.treasure.components.table.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.github.onotoliy.opposite.treasure.models.ReqListResult
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposits.DepositsService

interface DepositsPageProps : RProps {
    var scope: CoroutineScope
    var deposits: ReqListResult<Deposit>
}

class DepositsPage : RComponent<DepositsPageProps, RState>() {
    override fun componentDidMount() {
        props.scope.launch { DepositsService.loadDeposits() }
    }

    override fun RBuilder.render() {
        mTable {
            mTableHead {
                mTableRow {
                    mTableCell {
                        +"ФИО"
                    }
                    mTableCell {
                        +"Депозит"
                    }
                }
            }
            mTableBody {
                props.deposits.data.mapIndexed { _, deposit ->
                    mTableRow {
                        mTableCell {
                            routeLink(RoutePath.DEPOSIT_PAGE + deposit.uuid, className = "router-link") {
                                +deposit.person.name
                            }
                        }
                        mTableCell {
                            +(deposit.deposit)
                        }
                    }
                }
            }
        }
    }
}