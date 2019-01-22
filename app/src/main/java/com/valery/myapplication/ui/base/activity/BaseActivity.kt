package com.valery.myapplication.ui.base.activity

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.valery.myapplication.ui.base.fragment.BaseFragment

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutId: Int

    abstract val containerId: Int // here is fragment container id. Preferable to use the activity as just a container for some content.

    private val mainFragmentManager: FragmentManager
        get() = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        if (mainFragmentManager.fragments.firstOrNull() == null) {
            onLoadInitialContent()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (mainFragmentManager.fragments.size == 0) { // we have latest fragment in stack, so we should close this screen.
            finish()
        }
    }

    /**
     * You should use this method for show fragments. This allows easier tracking of current screen for reproduce issues and bugs.
     *
     * @param forceUpdateFragment - if you want to do force update (and ignore exists fragment of current class in stack) - set this flag to "true", otherwise this will use exists fragment instance (by tag).
     */
    protected fun <T : BaseFragment> replaceFragment(
        fragment: T,
        tag: String = fragment.javaClass.name,
        containerId: Int = this.containerId,
        fragmentManager: FragmentManager = mainFragmentManager,
        forceUpdateFragment: Boolean = false
    ) {
        val existsFragment = fragmentManager.findFragmentByTag(tag)
        if (!forceUpdateFragment && existsFragment != null) {
            return
        }
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.addToBackStack(tag)
        transaction.replace(containerId, fragment, tag)
        transaction.commit()
    }

    open fun onLoadInitialContent() {

    }
}