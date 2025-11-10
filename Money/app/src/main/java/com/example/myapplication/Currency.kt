package com.example.currencyconverter

data class Currency(
    val code: String,     // Mã tiền tệ, ví dụ "USD"
    val name: String,     // Tên tiền tệ, ví dụ "US Dollar"
    val rateToUSD: Double // Tỷ giá quy đổi sang USD
)
