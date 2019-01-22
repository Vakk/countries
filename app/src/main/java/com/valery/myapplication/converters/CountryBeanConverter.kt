package com.valery.myapplication.converters

import com.valery.myapplication.api.beans.CountryBean
import com.valery.myapplication.model.CountryModel

interface CountryBeanConverter : Converter<CountryBean, CountryModel>

class CountryBeanConverterImpl : BaseConverterImpl<CountryBean, CountryModel>(), CountryBeanConverter {

    override fun convert(input: CountryBean?): CountryModel? {
        return CountryModel().apply {
            name = input?.name ?: ""
            nativeName = input?.nativeName ?: ""
            borders = input?.borders ?: emptyList()
        }
    }

}