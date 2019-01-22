package com.valery.myapplication.ui.countries

import android.arch.lifecycle.MutableLiveData
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.providers.CountriesProvider
import com.valery.myapplication.ui.base.mvvm.viewmodel.BaseDaggerRxViewModel
import com.valery.myapplication.utils.extensions.addTo
import io.reactivex.Single
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
    }

    /**
     * Use this init call if you want to load all countries.
     */
    fun init() {
        loadCountries()
    }

    /**
     * Use this init call if you want to load borders for country.
     */
    fun init(country: CountryModel) {
        loadCountries(country)
    }

    fun loadCountries(country: CountryModel? = null) {
        showLoader()
        getCountriesSingle(country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { countries = it.toMutableList() }
            .doOnSuccess { onCountriesLoaded.value = it }
            .subscribe(onSuccess, onError)
            .addTo(disposableBag)
    }

    private fun getCountriesSingle(country: CountryModel?): Single<List<CountryModel>> {
        return if (country == null) {
            countriesProvider.getAllCountries()
        } else {
            countriesProvider.getBordersOf(country)
        }
    }
}