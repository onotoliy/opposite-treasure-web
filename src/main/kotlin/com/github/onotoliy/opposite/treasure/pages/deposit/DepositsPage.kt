package com.github.onotoliy.opposite.treasure.pages.deposit

import com.github.onotoliy.kotlinx.ReqListResult
import com.github.onotoliy.kotlinx.materialui.table.*
import com.github.onotoliy.kotlinx.services.Configuration
import com.github.onotoliy.opposite.data.Deposit
import com.github.onotoliy.opposite.treasure.routes.RoutePath
import com.github.onotoliy.opposite.treasure.services.deposit.DepositsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink

interface DepositsPageProps : RProps {
    var scope: CoroutineScope
    var deposits: ReqListResult<Deposit>
}

class DepositsPage : RComponent<DepositsPageProps, RState>() {
    override fun componentDidMount() {
        Configuration.scope.launch { DepositsService.loadDeposits() }
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
