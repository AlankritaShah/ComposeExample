package com.alankrita.composeexample.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alankrita.composeexample.ui.theme.ComposeExampleTheme
import com.alankrita.composeexample.R

class Unit1 {

    //Business Card
    @Composable
    fun BusinessCard() {
        Column(modifier = Modifier.fillMaxSize()) {
            BusinessCardTop(modifier = Modifier.weight(3F))
            BusinessCardBottom(modifier = Modifier.weight(2F))
        }
    }

    @Composable
    fun BusinessCardTop(modifier: Modifier) {
        val image = painterResource(id = R.drawable.ic_launcher_background)
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = image,
                contentDescription = "All tasks done",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)

            )
            Text(
                text = "Alankrita",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(0.dp, 24.dp, 0.dp, 8.dp)
            )
            Text(
                text = "Hi From Alankrita",
                fontSize = 16.sp
            )
        }
    }

    @Composable
    fun BusinessCardBottom(modifier: Modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            BusinessCardBottomRow("contact@gmail.com")
            BusinessCardBottomRow("contact@gmail.com")
            BusinessCardBottomRow("contact@gmail.com")
        }
    }

    @Composable
    fun BusinessCardBottomRow(contact: String) {
        val image = painterResource(id = R.drawable.ic_launcher_background)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp, 2.dp, 20.dp, 2.dp)
        ) {
            Image(
                painter = image,
                contentDescription = contact,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(5.dp)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(
                contact,
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BusinessCardPreview() {
        ComposeExampleTheme {
            BusinessCard()
        }
    }

    //Compose Quadrant
    @Composable
    fun ComposeQuadrants() {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(Modifier.weight(1F)) {
                ComposeQuadrant(
                    color = Color.Green,
                    head = "Text composable",
                    body = "Displays text and follows Material Design guidelines.",
                    modifier = Modifier.weight(1f)
                )
                ComposeQuadrant(
                    color = Color.Yellow,
                    head = "Image composable",
                    body = "Creates a composable that lays out and draws a given Painter class object.",
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.weight(1F)) {
                ComposeQuadrant(
                    color = Color.Cyan,
                    head = "Row composable",
                    body = "A layout composable that places its children in a horizontal sequence.",
                    modifier = Modifier.weight(1f)
                )
                ComposeQuadrant(
                    color = Color.LightGray,
                    head = "Column composable",
                    body = "A layout composable that places its children in a vertical sequence.",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    fun ComposeQuadrant(color: Color, head: String, body: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .background(color)
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = head,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
            )
            Text(
                text = body,
                textAlign = TextAlign.Justify,
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ComposeQuadrantPreview() {
        ComposeExampleTheme {
            ComposeQuadrants()
        }
    }


    //Task Manager
    @Composable
    fun TaskManager(head: String, body: String) {
        val image = painterResource(id = R.drawable.ic_launcher_background)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "All tasks done",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)

            )
            Text(
                text = head,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(0.dp, 24.dp, 0.dp, 8.dp)
            )
            Text(
                text = body,
                fontSize = 16.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TaskManagerPreview() {
        ComposeExampleTheme {
            TaskManager(
                "All tasks completed",
                "Nice work!"
            )
        }
    }


    //Compose Article
    @Composable
    fun ComposeArticleImage(head: String, body1: String, body2: String) {
        val image = painterResource(id = R.drawable.ic_launcher_background)
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = image,
                contentDescription = "Jetpack Compose Article",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            ComposeArticleText(head, body1, body2)
        }
    }

    @Composable
    fun ComposeArticleText(head: String, body1: String, body2: String) {
        Column {
            Text(
                text = head,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
            )
            Text(
                text = body1,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp)
            )
            Text(
                text = body2,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 16.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ComposeArticlePreview() {
        ComposeExampleTheme {
            ComposeArticleImage(
                "Jetpack Compose tutorial",
                "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
            )
        }
    }

    //BirthdayGreetingCard
    @Composable
    fun BirthdayGreetingWithImage(message: String, from: String) {
        val image = painterResource(id = R.drawable.ic_launcher_background)
        Box {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            BirthdayGreetingWithText(message, from)
        }
    }

    @Composable
    fun BirthdayGreetingWithText(message: String, from: String) {
        Surface(color = Color.Magenta) {
            Column {
                Text(
                    text = message,
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(10.dp)
                )
                Text(
                    text = from,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(10.dp)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BirthdayGreetingWithImagePreview() {
        ComposeExampleTheme {
            BirthdayGreetingWithImage("Happy Birthday Alankrita!", "From, Alankrita")
        }
    }
}