package com.valery.myapplication.api.services

import com.valery.myapplication.api.beans.CountryBean
import io.reactivex.Single
import retrofit2.http.GET

interface CountriesApiService {
    @GET("v2/all")
    fun getAllCountries(): Single<List<CountryBean>>
}