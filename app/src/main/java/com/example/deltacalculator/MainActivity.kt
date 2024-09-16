package com.example.deltacalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeltaCalculatorForm()
        }
    }
}

@Composable
fun DeltaCalculatorForm() {
    var aValue by remember { mutableStateOf("") }
    var bValue by remember { mutableStateOf("") }
    var cValue by remember { mutableStateOf("") }
    var deltaResult by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Kalkulator Delty", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = aValue,
            onValueChange = { aValue = it },
            label = { Text("Wartość a") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = bValue,
            onValueChange = { bValue = it },
            label = { Text("Wartość b") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = cValue,
            onValueChange = { cValue = it },
            label = { Text("Wartość c") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))



        Button(
            onClick = {
                val a = aValue.toDoubleOrNull()?: 0.0
                val b = bValue.toDoubleOrNull()?: 0.0
                val c = cValue.toDoubleOrNull()?: 0.0
                deltaResult = calculateDelta(a, b, c)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Oblicz deltę")
        }

        Spacer(modifier = Modifier.height(15.dp))


        deltaResult.let {
            Text(text = "Delta wynosi: $it", style = MaterialTheme.typography.bodyLarge)
        }
    }
}



fun calculateDelta(a: Double, b: Double, c: Double): Double {
    return b.pow(2) - 4 * a * c
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DeltaCalculatorForm()
}
