package com.alankrita.composeexample.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.*

class TipCalculator {
    @Preview(showBackground = true)
    @Composable
    fun TipTimeScreenPreview() {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            TipTimeScreen()
        }
    }

    @Composable
    fun TipTimeScreen() {
        var amountInput by remember {
            mutableStateOf("")
        }
        val amount = amountInput.toDoubleOrNull() ?: 0.0
        val tip = calculateTip(amount)
        Column(
            modifier = Modifier.padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calculate Tip",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditTextField(value = amountInput, onValueChange = { amountInput = it })
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Tip Amount: $tip",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun EditTextField(value: String, onValueChange: (String) -> Unit) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Bill Amount"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
    }

    fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
        val tip = (tipPercent / 100) * amount
        return NumberFormat.getCurrencyInstance(Locale.ROOT).format(tip)
    }
}