package com.valery.myapplication.api.beans

import com.fasterxml.jackson.annotation.JsonProperty

class CountryBean(
    @JsonProperty("name")
    val name: String
)