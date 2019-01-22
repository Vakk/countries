package com.valery.myapplication.ui.countries

import android.arch.lifecycle.MutableLiveData
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.providers.CountriesProvider
import com.valery.myapplication.ui.base.mvvm.viewmodel.BaseDaggerRxViewModel
import com.valery.myapplication.utils.extensions.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountriesViewModel : BaseDaggerRxViewModel() {

    val onCountriesLoaded = MutableLiveData<List<CountryModel>>()

    @Inject
    lateinit var countriesProvider: CountriesProvider

    private var countries: MutableList<CountryModel> = mutableListOf()

    init {
        daggerManager.sessionComponent?.inject(this)
        loadCountries()
    }

    private fun loadCountries() {
        showLoader()
        countriesProvider.getAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { countries = it.toMutableList() }
            .doOnSuccess { onCountriesLoaded.value = it }
            .subscribe(onSuccess, onError)
            .addTo(disposableBag)
    }
}