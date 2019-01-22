package com.valery.myapplication.ui.borders

import android.arch.lifecycle.MutableLiveData
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.providers.CountriesProvider
import com.valery.myapplication.ui.base.mvvm.viewmodel.BaseDaggerRxViewModel
import com.valery.myapplication.utils.extensions.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BordersViewModel : BaseDaggerRxViewModel() {

    val onCountriesLoaded = MutableLiveData<List<CountryModel>>()
    val onCountryInfoReady = MutableLiveData<CountryModel>()

    @Inject
    lateinit var countriesProvider: CountriesProvider

    private var countries: MutableList<CountryModel> = mutableListOf()

    init {
        daggerManager.sessionComponent?.inject(this)
    }

    fun init(country: CountryModel) {
        onCountryInfoReady.value = country
        loadCountries(country)
    }

    fun loadCountries(country: CountryModel) {
        showLoader()
        countriesProvider.getBordersOf(country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { countries = it.toMutableList() }
            .doOnSuccess { onCountriesLoaded.value = it }
            .subscribe(onSuccess, onError)
            .addTo(disposableBag)
    }

}