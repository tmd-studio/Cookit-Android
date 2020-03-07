package com.tmd.cookit.constant

import androidx.annotation.DrawableRes
import com.tmd.cookit.R
import com.tmd.cookit.ui.fragment.HomeFragment
import com.tmd.cookit.ui.fragment.MenuFragment
import com.tmd.cookit.ui.fragment.MineFragment

data class TabItemEntity(
    val title: String,
    @DrawableRes val selectedResId: Int,
    @DrawableRes val unselectedResId: Int
)


object TabConstant {

    val titles = listOf("主页", "菜单", "我的")

    val tabItems = listOf(
        TabItemEntity(
            "主页",
            R.mipmap.tab_selected_home,
            R.mipmap.tab_unselected_home
        ),
        TabItemEntity(
            "菜单",
            R.mipmap.tab_selected_menu,
            R.mipmap.tab_unselected_menu
        ),
        TabItemEntity(
            "我的",
            R.mipmap.tab_selected_setting,
            R.mipmap.tab_unselected_setting
        )
    )

    val fragmentList = listOf(HomeFragment(), MenuFragment(), MineFragment())


}