package com.alankrita.composeexample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alankrita.composeexample.ui.theme.ComposeExampleTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.alankrita.composeexample.R

class Lemonade2 {

    sealed class LemonadeResource(val imageId: Int, val description: String, val text: String) {
        object TREE : LemonadeResource(
            R.drawable.lemon_tree,
            "Lemon Tree",
            "Tap the lemon tree to select a lemon"
        )

        object SQUEEZE : LemonadeResource(
            R.drawable.lemon_squeeze,
            "Lemon",
            "Keep tapping the lemon to squeeze it"
        )

        object DRINK : LemonadeResource(
            R.drawable.lemon_drink,
            "Glass of lemonade",
            "Tap the lemonade to drink it"
        )

        object RESTART : LemonadeResource(
            R.drawable.lemon_restart,
            "Empty glass",
            "Tap the empty glass to start again"
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun LemonadeApp() {
        LemonadeWithImageAndText(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }

    @Composable
    fun LemonadeWithImageAndText(modifier: Modifier) {
        var result: LemonadeResource by remember {
            mutableStateOf(LemonadeResource.TREE)
        }

        var squeezeCount by remember {
            mutableStateOf(0)
        }

        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = result.text)
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = result.imageId),
                contentDescription = result.description,
                modifier = Modifier.clickable {
                    when(result){
                        LemonadeResource.TREE -> {
                            result = LemonadeResource.SQUEEZE
                            squeezeCount = (2..4).random()
                        }
                        LemonadeResource.SQUEEZE -> {
                            if(squeezeCount > 0)
                                squeezeCount--
                            else result = LemonadeResource.DRINK
                        }
                        LemonadeResource.DRINK -> {
                            result = LemonadeResource.RESTART
                        }
                        LemonadeResource.RESTART -> {
                            result = LemonadeResource.TREE
                        }
                    }
                }
            )
        }
    }
}