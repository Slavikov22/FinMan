package com.finman.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.finman.R
import com.finman.presenter.LoginPresenter
import com.finman.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.auth_bg.*

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
        tvSignUp.setOnClickListener { presenter.onSignUpClick() }
        btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onDestroy() {
        backgroundAnimator.cancel()
        super.onDestroy()
    }

    override fun openSignUpScreen() {
        val intent = Intent(this, SignUpActivity::class.java)
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