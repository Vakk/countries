package com.valery.myapplication.ui.base.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.ref.WeakReference

abstract class BaseViewHolder<Item>(itemView: View, adapterClickListener: AdapterClickListener<Item>? = null) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    companion object {
        fun prepareView(layoutId: Int, parent: ViewGroup): View {
            return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        }
    }

    private val adapterClickListenerWR = WeakReference(adapterClickListener)
    private val adapterClickListener: AdapterClickListener<Item>?
        get() = adapterClickListenerWR.get()

    private var item: Item?
        get() = itemView.tag as Item
        set(value) {
            itemView.tag = value
        }

    fun setClickListeners(vararg views: View) {
        views.forEach { it.setOnClickListener(this) }
    }

    fun setClickListeners(onClickListener: View.OnClickListener = this, vararg views: View) {
        views.forEach { it.setOnClickListener(onClickListener) }
    }

    fun bind(item: Item, payload: Bundle? = null) {
        this.item = item
        onBind(item, payload)
    }

    override fun onClick(v: View) {
        item?.let { adapterClickListener?.onClick(v, it) }
    }

    protected abstract fun onBind(item: Item, payload: Bundle?)
}