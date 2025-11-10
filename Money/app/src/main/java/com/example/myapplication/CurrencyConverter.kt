package com.example.myapplication

data class Currency(val code: String, val rateToUSD: Double)

object CurrencyConverter {
    val currencies = listOf(
        Currency("USD", 1.0),
        Currency("EUR", 0.92),
        Currency("JPY", 150.0),
        Currency("VND", 26.3),
        Currency("AUD", 1.44),
        Currency("CAD", 1.34),
        Currency("CHF", 0.92),
        Currency("CNY", 7.22),
        Currency("HKD", 7.85),
        Currency("KRW", 1330.0)
    )

    fun convert(amount: Double, from: Currency, to: Currency): Double {
        val amountInUSD = amount / from.rateToUSD
        return amountInUSD * to.rateToUSD
    }
}
