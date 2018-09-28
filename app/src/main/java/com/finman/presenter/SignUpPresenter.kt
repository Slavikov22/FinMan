package com.finman.presenter

import com.arellomobile.mvp.InjectViewState
import com.finman.view.SignUpView

@InjectViewState
class SignUpPresenter : BasePresenter<SignUpView>() {

    fun onSignInClick() {
        viewState.openSignInScreen()
    }
}
