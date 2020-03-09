package com.tmd.cookit.ui.activity

import android.os.Bundle
import com.tmd.cookit.R
import com.tmd.cookit.common.base.BaseActivity
import com.tmd.cookit.constant.TabConstant
import com.tmd.cookit.ui.adapter.TabPagerAdapter
import com.tmd.cookit.ui.widget.CookTabManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        initToolBarEvent()
        initTabs()
    }

    private fun initToolBarEvent() {
        ivAdd.setOnClickListener { open(CookModeActivity::class.java) }
    }

    private fun initTabs() {
        mainViewPager.adapter = TabPagerAdapter(
            supportFragmentManager,
            TabConstant.fragmentList,
            TabConstant.titles
        )
        CookTabManager(this, mainTabLayout, mainViewPager).initInflateItems()
    }
}
