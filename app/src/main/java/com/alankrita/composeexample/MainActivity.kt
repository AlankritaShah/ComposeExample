package com.alankrita.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alankrita.composeexample.ui.DiceRoller
import com.alankrita.composeexample.ui.Lemonade
import com.alankrita.composeexample.ui.Lemonade2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lemonade().LemonadeApp()
        }
    }
}