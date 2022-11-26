package com.alankrita.composeexample.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.*
import kotlin.math.ceil

class TipCalculatorCustom {
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
        //bill amount entered
        var amountInput by remember {
            mutableStateOf("")
        }
        val amount = amountInput.toDoubleOrNull() ?: 0.0

        //tip entered in percent
        var tipInput by remember {
            mutableStateOf("")
        }
        val tipPercent = tipInput.toDoubleOrNull() ?: 0.0

        //round up switch
        var roundUpInput by remember {
            mutableStateOf(false)
        }

        val tip = calculateTip(amount, tipPercent, roundUpInput)

        val focusManager = LocalFocusManager.current
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
            EditTextField(
                label = "Bill Amount",
                value = amountInput,
                onValueChange = { amountInput = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                })
            )
            EditTextField(
                label = "Tip (%)",
                value = tipInput,
                onValueChange = { tipInput = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                })
            )
            RoundTheTipRow(roundUp = roundUpInput, onRoundUpChange = { roundUpInput = it })
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Tip Amount: $tip",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun EditTextField(
        label: String,
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        keyboardOptions: KeyboardOptions,
        keyboardActions: KeyboardActions
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            label = {
                Text(
                    text = label
                )
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true
        )
    }

    @Composable
    fun RoundTheTipRow(
        roundUp: Boolean,
        onRoundUpChange: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Round up tip?"
            )
            Switch(
                checked = roundUp,
                onCheckedChange = onRoundUpChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                colors = SwitchDefaults.colors(uncheckedThumbColor = Color.DarkGray)
            )
        }
    }

    private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
        var tip = (tipPercent / 100) * amount
        if (roundUp) tip = ceil(tip)
        return NumberFormat.getCurrencyInstance(Locale.ROOT).format(tip)
    }
}