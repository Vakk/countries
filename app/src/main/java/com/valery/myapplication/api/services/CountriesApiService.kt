package com.valery.myapplication.api.services

import com.valery.myapplication.api.beans.CountryBean
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesApiService {
    @GET("v2/all")
    fun getAllCountries(): Single<List<CountryBean>>

    @GET("v2/alpha")
    fun getCountries(@Query("codes") codes: List<String>): Single<List<CountryBean>>
}