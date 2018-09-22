package com.finman.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.finman.R
import com.finman.presenter.MainPresenter
import com.finman.view.MainView

class MainActivity : BaseActivityView(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun getLayoutResID() = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
    }
}
