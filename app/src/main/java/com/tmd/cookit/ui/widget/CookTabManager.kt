package com.tmd.cookit.ui.widget

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.tmd.cookit.R
import com.tmd.cookit.constant.TabConstant
import com.tmd.cookit.constant.TabItemEntity

class CookTabManager(
    private val context: Context,
    private val tabLayout: TabLayout,
    private val viewPager: ViewPager
) {

    private val tabList: List<TabItemEntity> = TabConstant.tabItems

    private val colors = arrayOf(R.color.tab_selected, R.color.tab_unselected)

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)


    fun initInflateItems() {
        tabLayout.setupWithViewPager(viewPager)
        tabList.forEachIndexed { index, tabItem ->
            tabLayout.getTabAt(index)?.customView = createTabView(index, tabItem)
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.apply { changeStatus(tabView = this, isSelected = false) }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.apply { changeStatus(tabView = this, isSelected = true) }
            }

        })
    }

    private fun changeStatus(tabView: View, isSelected: Boolean) {
        tabView.apply {
            if (tag == null || tag !is TabItemEntity) {
                return
            }
            val itemEntity = tag as TabItemEntity
            val tvTitle = findViewById<TextView>(R.id.tv_tab)
            val ivTabIcon = findViewById<ImageView>(R.id.iv_tab)
            if (isSelected) {
                tvTitle.setTextColor(context.resources.getColor(R.color.tab_selected))
                ivTabIcon.setImageDrawable(context.getDrawable(itemEntity.selectedResId))
            } else {
                tvTitle.setTextColor(context.resources.getColor(R.color.tab_unselected))
                ivTabIcon.setImageDrawable(context.getDrawable(itemEntity.unselectedResId))
            }
        }

    }

    private fun createTabView(index: Int, itemEntity: TabItemEntity): View {
        val tabItemView = layoutInflater.inflate(R.layout.item_cook_tab, null)
        tabItemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tv_tab)
            val ivTabIcon = findViewById<ImageView>(R.id.iv_tab)

            tvTitle.apply {
                text = itemEntity.title
                setTextColor(
                    context.resources.getColor(if (index == 0) colors[0] else colors[1])
                )
            }

            ivTabIcon.setImageDrawable(
                context.getDrawable(
                    if (index == 0) itemEntity.selectedResId else itemEntity.unselectedResId
                )
            )

            setOnClickListener { viewPager.currentItem = index }

            tag = itemEntity
        }

        return tabItemView

    }


}