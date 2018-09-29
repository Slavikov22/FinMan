package com.finman.view

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface LoginView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openSignUpScreen()
}
