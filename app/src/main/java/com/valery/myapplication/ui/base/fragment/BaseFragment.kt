package com.valery.myapplication.ui.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int

    abstract val containerId: Int // here is fragment container id. Preferable to use the activity as just a container for some content.

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            layoutId,
            container,
            false
        )
    }

    /**
     * You should use this method for show fragments. This allows easier tracking of current screen for reproduce issues and bugs.
     */
    protected fun <T : BaseFragment> replaceFragment(
        fragment: T,
        tag: String = fragment.javaClass.name,
        containerId: Int = this.containerId,
        fragmentManager: FragmentManager? = getFragmentManager(),
        needToUseBackStack: Boolean = true
    ) {
        val fragmentManager = fragmentManager!! // without fragment manager we can not to do fragment replacing.
        val transaction = fragmentManager.beginTransaction()
        if (needToUseBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.replace(containerId, fragment, tag)
        transaction.commit()
    }
}