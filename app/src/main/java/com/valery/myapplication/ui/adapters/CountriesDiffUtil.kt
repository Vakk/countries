package com.valery.myapplication.ui.adapters

import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.ui.base.adapter.BaseDiffUtilCallback

class CountriesDiffUtil : BaseDiffUtilCallback<CountryModel>() {
    override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
        return oldItem.name == newItem.name
    }
}