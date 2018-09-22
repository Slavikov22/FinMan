package com.finman.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.finman.R
import com.finman.presenter.LoginPresenter

class LoginActivity : BaseActivityView() {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun getLayoutResID(): Int = R.layout.activity_login

    override fun setupView(savedInstanceState: Bundle?) {

    }
}