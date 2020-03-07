package com.tmd.cookit.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tmd.cookit.R
import com.tmd.cookit.ui.adapter.TabPagerAdapter
import com.tmd.cookit.ui.widget.CookTabManager
import com.tmd.cookit.constant.TabConstant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mainViewPager.adapter = TabPagerAdapter(
            supportFragmentManager,
            TabConstant.fragmentList,
            TabConstant.titles
        )
        CookTabManager(this, mainTabLayout, mainViewPager).initInflateItems()
    }
}
