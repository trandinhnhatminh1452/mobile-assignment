package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterApp()
        }
    }
}

@Composable
fun CurrencyConverterApp() {
    var fromAmount by remember { mutableStateOf("") }
    var toAmount by remember { mutableStateOf("") }

    var fromCurrency by remember { mutableStateOf(CurrencyConverter.currencies[0]) }
    var toCurrency by remember { mutableStateOf(CurrencyConverter.currencies[1]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // From TextField
        TextField(
            value = fromAmount,
            onValueChange = { value ->
                fromAmount = value
                val amount = value.toDoubleOrNull() ?: 0.0
                toAmount = CurrencyConverter.convert(amount, fromCurrency, toCurrency).toString()
            },
            label = { Text("From Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        // From Currency Dropdown
        CurrencyDropdown(selectedCurrency = fromCurrency, onCurrencySelected = {
            fromCurrency = it
            val amount = fromAmount.toDoubleOrNull() ?: 0.0
            toAmount = CurrencyConverter.convert(amount, fromCurrency, toCurrency).toString()
        })

        // To TextField
        TextField(
            value = toAmount,
            onValueChange = { value ->
                toAmount = value
                val amount = value.toDoubleOrNull() ?: 0.0
                fromAmount = CurrencyConverter.convert(amount, toCurrency, fromCurrency).toString()
            },
            label = { Text("To Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        // To Currency Dropdown
        CurrencyDropdown(selectedCurrency = toCurrency, onCurrencySelected = {
            toCurrency = it
            val amount = fromAmount.toDoubleOrNull() ?: 0.0
            toAmount = CurrencyConverter.convert(amount, fromCurrency, toCurrency).toString()
        })
    }
}

@Composable
fun CurrencyDropdown(
    selectedCurrency: Currency,
    onCurrencySelected: (Currency) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val currencies = CurrencyConverter.currencies

    Box(modifier = Modifier.fillMaxWidth()) {
        // TextField hiển thị currency
        TextField(
            value = selectedCurrency.code,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            currencies.forEach { currency ->
                DropdownMenuItem(
                    text = { Text(currency.code) },
                    onClick = {
                        onCurrencySelected(currency)
                        expanded = false
                    }
                )
            }
        }
    }
}
