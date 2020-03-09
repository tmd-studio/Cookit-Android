package com.tmd.cookit.ui.activity

import android.os.Bundle
import com.tmd.cookit.R
import com.tmd.cookit.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_cook_mode.*

class CookModeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cook_mode)
        tvFullMode.setOnClickListener {
            open(CookeryActivity::class.java, true)
        }

        tvSimpleMode.setOnClickListener {

        }
    }

}