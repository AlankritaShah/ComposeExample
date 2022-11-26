package com.alankrita.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.sp
import com.alankrita.composeexample.ui.TipCalculator
import com.alankrita.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    TipCalculator().TipTimeScreenPreview()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeExampleTheme {
//        Greeting("Android")
//    }
//}




//@Preview(showBackground = true)
//@Composable
//fun DiceRollerApp() {
//    DiceRoller(
//        Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//    )
//}

//only image

//@Composable
//fun DiceRoller(modifier: Modifier) {
//    Image(
//        painter = painterResource(id = R.drawable.dice_1),
//        contentDescription = "1",
//        modifier = modifier.padding(5.dp)
//    )
//}


//only button

//@Composable
//fun DiceRoller(modifier: Modifier) {
//    Button(onClick = {}, modifier = modifier) {
//        Text(text = "Roll")
//    }
//}




//Image and button

//@Composable
//fun DiceRoller(modifier: Modifier) {
//    Image(
//        painter = painterResource(id = R.drawable.dice_1),
//        contentDescription = "1"
//    )
//    Button(onClick = {}) {
//        Text(text = "Roll")
//    }
//}




//column

//@Composable
//fun DiceRoller(modifier: Modifier) {
//    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//        Image(
//            painter = painterResource(id = R.drawable.dice_2),
//            contentDescription = "1"
//        )
//        Spacer(modifier = Modifier.padding(50.dp))
//        Button(onClick = {}) {
//            Text(text = "Roll the dice", fontSize = 40.sp)
//        }
//    }
//}


//final

//@Composable
//fun DiceRoller(modifier: Modifier) {
//    var result = 1 //store whatever is the result we get on rolling teh dice
//    val imageResource = when (result) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//
//    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//        Image(
//            painter = painterResource(id = imageResource),
//            contentDescription = result.toString()
//        )
//        Spacer(modifier = Modifier.padding(24.dp))
//        Button(onClick = {
//            result = (1..6).random()
//        }) {
//            Text(text = "Roll")
//        }
//    }
//}


//final with remember

//@Composable
//fun DiceRoller(modifier: Modifier) {
//    var result by remember{
//        mutableStateOf(1)
//    }
//    val imageResource = when (result) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//
//    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//        Image(
//            painter = painterResource(id = imageResource),
//            contentDescription = result.toString()
//        )
//        Spacer(modifier = Modifier.padding(24.dp))
//        Button(onClick = {
//            result = (1..6).random()
//        }) {
//            Text(text = "Roll")
//        }
//    }
//}

