package com.valery.myapplication.ui.base.adapter

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import java.lang.ref.WeakReference

abstract class BaseRecyclerAdapter<Item, VH : BaseViewHolder<Item>>(adapterClickListener: AdapterClickListener<Item>? = null) :
    RecyclerView.Adapter<VH>(), AdapterClickListener<Item> {
    private val adapterClickListenerWR = WeakReference(adapterClickListener)
    private val adapterClickListener: AdapterClickListener<Item>?
        get() = adapterClickListenerWR.get()

    private var items = mutableListOf<Item>()

    override fun onClick(view: View, item: Item) {
        adapterClickListener?.onClick(view, item)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindViewHolder(holder, position, mutableListOf())
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        holder.bind(getItem(position), payloads.firstOrNull() as? Bundle?)
    }

    protected fun getItem(index: Int): Item = items[index]

    /**
     * This method will update current list by @param newList.
     */
    fun updateList(newList: List<Item>, diffUtilCallback: BaseDiffUtilCallback<Item>? = null) {
        if (diffUtilCallback == null) {
            items = newList.toMutableList()
            notifyDataSetChanged()
        } else {
            diffUtilCallback.oldList = items
            DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
        }
    }

}