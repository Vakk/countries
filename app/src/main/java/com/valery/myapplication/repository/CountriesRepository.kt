package com.valery.myapplication.repository

import com.valery.myapplication.model.CountryModel

interface CountriesRepository : Repository<CountryModel>

class CouuntriesRepositoryImpl : BaseRepositoryImpl<CountryModel>(), CountriesRepository