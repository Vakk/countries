package com.valery.myapplication.api.beans

import com.fasterxml.jackson.annotation.JsonProperty

data class CountryBean(
    @JsonProperty("name")
    val name: String,

    @JsonProperty("nativeName")
    val nativeName: String = "",

    @JsonProperty("alpha3Code")
    val alphaCode: String = "",

    @JsonProperty("borders")
    val borders: List<String> = emptyList()
)