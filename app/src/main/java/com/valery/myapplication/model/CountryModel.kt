package com.valery.myapplication.model

data class CountryModel(
    var name: String = "",
    var nativeName: String = "",
    var borders: List<String> = emptyList()
)