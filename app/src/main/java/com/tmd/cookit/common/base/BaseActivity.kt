package com.tmd.cookit.common.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    protected fun <T : BaseActivity> open(targetActivity: Class<T>, needFinish: Boolean = false) {
        startActivity(Intent(this, targetActivity))
        if (needFinish) {
            finish()
        }
    }


}