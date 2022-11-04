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

class Lemonade {

    sealed class LemonadeResource(val imageId: Int, val description: String, val text: String, val nextStep: LemonadeResource) {
        object TREE : LemonadeResource(
            R.drawable.lemon_tree,
            "Lemon Tree",
            "Tap the lemon tree to select a lemon",
            SQUEEZE
        )

        object SQUEEZE : LemonadeResource(
            R.drawable.lemon_squeeze,
            "Lemon",
            "Keep tapping the lemon to squeeze it",
            DRINK
        )

        object DRINK : LemonadeResource(
            R.drawable.lemon_drink,
            "Glass of lemonade",
            "Tap the lemonade to drink it",
            RESTART
        )

        object RESTART : LemonadeResource(
            R.drawable.lemon_restart,
            "Empty glass",
            "Tap the empty glass to start again",
            TREE
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

        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = result.text)
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = result.imageId),
                contentDescription = result.description,
                modifier = Modifier.clickable {
                    result = result.nextStep
                }
            )
        }
    }
}