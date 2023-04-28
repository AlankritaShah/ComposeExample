package com.alankrita.composeexample.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val titleId: Int, val count: Int, @DrawableRes val imageId: Int)