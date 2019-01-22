package com.valery.myapplication.ui.countries

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.valery.myapplication.R
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.ui.base.adapter.AdapterClickListener
import com.valery.myapplication.ui.base.mvvm.BaseMvvmFragment
import kotlinx.android.synthetic.main.fragment_countries.*

class CountriesFragment : BaseMvvmFragment<CountriesViewModel>(CountriesViewModel::class.java),
    AdapterClickListener<CountryModel> {

    companion object {
        fun newInstance(): CountriesFragment {
            return CountriesFragment()
        }
    }

    override val layoutId: Int = R.layout.fragment_countries

    private val adapter: CountriesAdapter by lazy { CountriesAdapter(this) }

    override fun onPrepareObservers() {
        super.onPrepareObservers()
        viewModel.onCountriesLoaded.observe(Observer {
            it?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareList()
    }

    fun prepareList() {
        rvContent.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        rvContent.adapter = adapter
    }

    override fun onClick(view: View, item: CountryModel) {

    }
}