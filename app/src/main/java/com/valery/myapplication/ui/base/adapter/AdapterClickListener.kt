package com.valery.myapplication.ui.base.adapter

import android.view.View

interface AdapterClickListener<T> {
    fun onClick(view: View, item: T)
}