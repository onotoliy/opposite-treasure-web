package com.github.onotoliy.opposite.treasure.routes

import com.github.onotoliy.opposite.treasure.pages.deposit.depositViewPageContainer
import com.github.onotoliy.opposite.treasure.pages.deposit.depositsPageContainer
import com.github.onotoliy.opposite.treasure.pages.event.eventEditPageContainer
import com.github.onotoliy.opposite.treasure.pages.event.eventViewPageContainer
import com.github.onotoliy.opposite.treasure.pages.event.eventsPageContainer
import com.github.onotoliy.opposite.treasure.pages.profile.profilePageContainer
import com.github.onotoliy.opposite.treasure.pages.transaction.transactionEditPageContainer
import com.github.onotoliy.opposite.treasure.pages.transaction.transactionViewPageContainer
import com.github.onotoliy.opposite.treasure.pages.transaction.transactionsPageContainer
import kotlinx.coroutines.CoroutineScope
import react.RBuilder
import react.RProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

interface ParamsProps : RProps {
    var param1: String
}

fun RBuilder.routes(scope: CoroutineScope) = switch {
    // Profile
    route<RProps>(RoutePath.PROFILE_PAGE, exact = true) { props ->
        profilePageContainer {
            attrs.scope = scope
            attrs.history = props.history
        }
    }
    // Deposits
    route<RProps>(RoutePath.DEPOSIT_PAGE, exact = true) { props ->
        depositsPageContainer {
            attrs.scope = scope
            attrs.history = props.history
        }
    }
    route<ParamsProps>(RoutePath.DEPOSIT_PAGE + ":param1", exact = true) { props ->
        val person = props.match.params.param1
        depositViewPageContainer {
            attrs.scope = scope
            attrs.history = props.history
            attrs.person = person
        }
    }

    // Events
    route<RProps>(RoutePath.EVENT_PAGE, exact = true) { props ->
        eventsPageContainer {
            attrs.scope = scope
            attrs.history = props.history
        }
    }
    route<ParamsProps>(RoutePath.EVENT_PAGE + ":param1", exact = true) { props ->
        val uuid = props.match.params.param1
        eventViewPageContainer {
            attrs.scope = scope
            attrs.history = props.history
            attrs.uuid = uuid
        }
    }
    route<ParamsProps>(RoutePath.EVENT_PAGE + ":param1/edit") { props ->
        val uuid = props.match.params.param1
        eventEditPageContainer {
            attrs.scope = scope
            attrs.history = props.history
            attrs.uuid = uuid
        }
    }

    // Transactions
    route<RProps>(RoutePath.TRANSACTION_PAGE, exact = true) { props ->
        transactionsPageContainer {
            attrs.scope = scope
            attrs.history = props.history
        }
    }
    route<ParamsProps>(RoutePath.TRANSACTION_PAGE + ":param1", exact = true) { props ->
        val uuid = props.match.params.param1
        transactionViewPageContainer {
            attrs.scope = scope
            attrs.history = props.history
            attrs.uuid = uuid
        }
    }
    route<ParamsProps>(RoutePath.TRANSACTION_PAGE + ":param1/edit") { props ->
        val uuid = props.match.params.param1
        transactionEditPageContainer {
            attrs.scope = scope
            attrs.history = props.history
            attrs.uuid = uuid
        }
    }

    redirect("/", RoutePath.DEPOSIT_PAGE)
}