package com.valery.myapplication.ui.base.adapter

import android.support.v7.util.DiffUtil

abstract class BaseDiffUtilCallback<T>(var oldList: List<T>, var newList: List<T>) : DiffUtil.Callback() {
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areContentsTheSame(oldList[oldItemPosition], newList[newItemPosition])
    }

    open fun areContentsTheSame(oldItem: T, newItem: T): Boolean = false


    override fun getNewListSize(): Int = newList.size

    override fun getOldListSize(): Int = oldList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTheSame(oldList[oldItemPosition], newList[newItemPosition])
    }

    open fun areItemsTheSame(oldItem: T, newItem: T): Boolean = false

}