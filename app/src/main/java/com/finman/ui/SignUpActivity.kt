package com.finman.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.finman.R
import com.finman.presenter.SignUpPresenter
import com.finman.view.SignUpView

class SignUpActivity : BaseActivityView(), SignUpView {

    @InjectPresenter
    lateinit var presenter: SignUpPresenter

    override fun getLayoutResID(): Int = R.layout.activity_sign_up

    override fun setupView(savedInstanceState: Bundle?) {

    }
}