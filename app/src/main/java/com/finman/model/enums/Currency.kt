package com.finman.model.enums

import android.support.annotation.DrawableRes
import com.finman.R

enum class Currency {
    USD {
        override fun getDrawableResId(): Int = R.drawable.flag_usa
    },
    EUR {
        override fun getDrawableResId(): Int = R.drawable.flag_europe
    },
    RUB {
        override fun getDrawableResId(): Int = R.drawable.flag_russia
    },
    BYN {
        override fun getDrawableResId(): Int = R.drawable.flag_belarus
    };
    @DrawableRes abstract fun getDrawableResId(): Int
}