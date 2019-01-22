package com.valery.myapplication.ui.base.activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.valery.myapplication.ui.base.fragment.BaseFragment

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutId: Int

    abstract val containerId: Int // here is fragment container id. Preferable to use the activity as just a container for some content.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    /**
     * You should use this method for show fragments. This allows easier tracking of current screen for reproduce issues and bugs.
     */
    protected fun <T : BaseFragment> replaceFragment(
        fragment: T,
        tag: String = fragment.javaClass.name,
        containerId: Int = this.containerId,
        fragmentManager: FragmentManager = supportFragmentManager!!,
        needToUseBackStack: Boolean = true
    ) {
        val transaction = fragmentManager.beginTransaction()
        if (needToUseBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.replace(containerId, fragment, tag)
        transaction.commit()
    }
}