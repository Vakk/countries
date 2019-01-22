package com.valery.myapplication.ui.borders

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.valery.myapplication.R
import com.valery.myapplication.model.CountryModel
import com.valery.myapplication.ui.adapters.CountriesAdapter
import com.valery.myapplication.ui.base.DividerItemDecorator
import com.valery.myapplication.ui.base.adapter.AdapterClickListener
import com.valery.myapplication.ui.base.mvvm.BaseMvvmFragment
import com.valery.myapplication.ui.main.MainView
import kotlinx.android.synthetic.main.fragment_borders.*

class BordersFragment : BaseMvvmFragment<BordersViewModel>(BordersViewModel::class.java),
    AdapterClickListener<CountryModel>, View.OnClickListener {

    companion object {
        fun newInstance(bordersFor: CountryModel): BordersFragment {
            return BordersFragment().apply {
                onFirstViewModelInit = {
                    init(bordersFor)
                }
            }
        }
    }

    override val layoutId: Int = R.layout.fragment_borders

    private val adapter: CountriesAdapter by lazy {
        CountriesAdapter(
            this
        )
    }
    private var mainView: MainView? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainView = bindInterfaceOrThrow(context)
    }

    override fun onDetach() {
        super.onDetach()
        mainView = null
    }

    override fun onPrepareObservers() {
        super.onPrepareObservers()
        viewModel.onCountriesLoaded.observe(Observer {
            it?.let {
                adapter.updateList(it)
            }
        })

        viewModel.onCountryInfoReady.observe(Observer {
            it?.let {
                tvTitle.text = it.nativeName
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareList()
        ivBack.setOnClickListener(this)
    }

    fun prepareList() {
        rvContent.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        rvContent.adapter = adapter
        rvContent.addItemDecoration(
            DividerItemDecorator(
                context!!,
                colorAttr = R.attr.divider1
            )
        )
    }

    override fun onClick(view: View, item: CountryModel) {
        if (item.borders.isNotEmpty()) {
            mainView?.openBorders(
                item, arrayOf(
//                    view to getString(R.string.transition_name)
                )
            )
            onPause()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> onBackPressed()
        }
    }
}