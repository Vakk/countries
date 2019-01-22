package com.valery.myapplication.ui.countries

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.valery.myapplication.R
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.ui.base.adapter.AdapterClickListener
import com.valery.myapplication.ui.base.adapter.BaseRecyclerAdapter
import com.valery.myapplication.ui.base.adapter.BaseViewHolder

class CountriesAdapter(listener: AdapterClickListener<CountryModel>) :
    BaseRecyclerAdapter<CountryModel, CountriesAdapter.ViewHolder>(listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BaseViewHolder.prepareView(R.layout.item_country, parent), this)
    }

    class ViewHolder(itemView: View, listener: AdapterClickListener<CountryModel>) :
        BaseViewHolder<CountryModel>(itemView, listener) {

        private val tvCountryName: TextView = itemView.findViewById(R.id.tvCountryName)

        init {
            setClickListeners(itemView)
        }

        override fun onBind(item: CountryModel, payload: Bundle?) {
            tvCountryName.text = item.name
        }
    }
}