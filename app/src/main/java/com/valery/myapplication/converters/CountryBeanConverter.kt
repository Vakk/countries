package com.valery.myapplication.converters

import com.valery.myapplication.api.beans.CountryBean
import com.valery.myapplication.model.CountryModel

interface CountryBeanConverter : Converter<CountryBean, CountryModel>

class CountryBeanCnverterImpl : BaseConverterImpl<CountryBean, CountryModel>(),
    Converter<CountryBean, CountryModel> {

    override fun convert(input: CountryBean?): CountryModel? {
        return input?.name?.let { CountryModel(it) }
    }

}