package com.finman.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.finman.R
import com.finman.adapter.CurrencyAdapter
import com.finman.presenter.SignUpPresenter
import com.finman.view.SignUpView
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.auth_bg.*

class SignUpActivity : BaseActivityView(), SignUpView {

    companion object {
        const val SCALE = 1.05f
        const val SCALE_DURATION = 3000L
    }

    @InjectPresenter
    lateinit var presenter: SignUpPresenter

    private lateinit var backgroundAnimator: ObjectAnimator

    override fun getLayoutResID(): Int = R.layout.activity_sign_up

    override fun setupView(savedInstanceState: Bundle?) {
        initBackgroundAnimation()
        spinnerCurrency.adapter = CurrencyAdapter(this)
        tvSignIn.setOnClickListener { presenter.onSignInClick() }
    }

    override fun onDestroy() {
        backgroundAnimator.cancel()
        super.onDestroy()
    }

    override fun openSignInScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
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