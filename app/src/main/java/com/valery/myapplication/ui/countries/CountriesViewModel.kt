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
    private var query: String = ""

    init {
        daggerManager.sessionComponent?.inject(this)
    }

    fun init() {
        loadCountries()
    }

    fun loadCountries() {
        showLoader()
        countriesProvider.getAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { countries = it.toMutableList() }
            .doOnSuccess { search(query) }
            .subscribe(onSuccess, onError)
            .addTo(disposableBag)
    }

    fun search(query: String) {
        this.query = query
        Single.fromCallable {
            if (!query.isEmpty()) {
                countries.filter {
                    it.name.toLowerCase().contains(query.toLowerCase())
                            || it.nativeName.toLowerCase().contains(query.toLowerCase())
                }
            } else {
                countries
            }
        }.map { it.take(100) } // optimization of output. Here cna be to much of results, so we will take only some elements.
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .doOnSuccess {
                onCountriesLoaded.value = it
            }
            .subscribe(onSuccess, onError)
            .addTo(disposableBag)
    }

}