package com.valery.myapplication.converters

interface Converter<IN: Any, OUT: Any> {
    fun convert(input: IN?): OUT?

    fun convert(inputs: List<IN>): List<OUT>
}

abstract class BaseConverterImpl<IN: Any, OUT: Any> : Converter<IN, OUT> {
    override fun convert(inputs: List<IN>): List<OUT> {
        return inputs.mapNotNull { convert(it) }
    }
}