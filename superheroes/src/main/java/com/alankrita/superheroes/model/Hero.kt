package com.alankrita.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(@StringRes val nameResId: Int, @StringRes val descriptionResId: Int, @DrawableRes val imageResId: Int)
