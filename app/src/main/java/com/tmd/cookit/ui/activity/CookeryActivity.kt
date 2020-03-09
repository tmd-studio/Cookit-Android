package com.tmd.cookit.ui.activity

import android.os.Bundle
import com.tmd.cookit.R
import com.tmd.cookit.common.base.BaseActivity
/*
    1. 创建功能，可以测试新增数据
    2. 构建存储到本地功能，涉及ViewModel+Room+LiveData+协程
 */
class CookeryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cookery)
    }

}