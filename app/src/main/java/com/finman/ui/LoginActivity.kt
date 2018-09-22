package com.finman.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.finman.R
import com.finman.presenter.LoginPresenter
import com.finman.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivityView(), LoginView {

    companion object {
        const val SCALE = 1.05f
        const val SCALE_DURATION = 3000L
    }

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    private lateinit var backgroundAnimator: ObjectAnimator

    override fun getLayoutResID(): Int = R.layout.activity_login

    override fun setupView(savedInstanceState: Bundle?) {
        initBackgroundAnimation()
    }

    override fun onDestroy() {
        backgroundAnimator.cancel()
        super.onDestroy()
    }

    private fun initBackgroundAnimation() {
        backgroundAnimator = ObjectAnimator.ofPropertyValuesHolder(
                ivTopBackground,
                PropertyValuesHolder.ofFloat(View.SCALE_X, SCALE),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, SCALE)
        ).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
            duration = SCALE_DURATION
            start()
        }
    }
}