package com.valery.myapplication.ui.main

import android.support.design.widget.Snackbar
import android.view.View
import com.valery.myapplication.R
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.ui.base.activity.BaseActivity
import com.valery.myapplication.ui.borders.BordersFragment
import com.valery.myapplication.ui.countries.CountriesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView, ProgressController,
        MessageController {

    override val layoutId: Int = R.layout.activity_main

    override val containerId: Int = R.id.flContent

    override fun onLoadInitialContent() {
        openCountriesList()
    }

    override fun openCountriesList() {
        replaceFragment(CountriesFragment.newInstance())
    }

    override fun openBorders(countryModel: CountryModel, sharedViews: Array<View>) {
        replaceFragment(
                BordersFragment.newInstance(countryModel),
                forceUpdateFragment = true,
                sharedViews = sharedViews
        ) // this screen will ignore stack, so user can open a lot of countries and memory will clear.
    }

    override fun changeProgressViewStatus(isVisible: Boolean) {

    }

    override fun showMessage(message: String) {
        Snackbar.make(flContent, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(messageId: Int) {
        showMessage(getString(messageId))
    }
}
