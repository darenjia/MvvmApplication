package com.bkjcb.mvvmapplication.repository

import com.bkjcb.mvvmapplication.R
import com.bkjcb.mvvmapplication.model.MenuItem

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
class MenuRepository(val userRole: Int) {
    fun getMenuItem(): List<MenuItem> {
        return  createMenuItemList(userRole)
    }

    private fun createMenuItemList(userRole: Int): List<MenuItem> {
        val menuItems = ArrayList<MenuItem>()
        menuItems.add(
            MenuItem(
                "一户一档",
                R.drawable.main_menu_report,
                1
            )
        )
        menuItems.add(
            MenuItem(
                "站点检查",
                R.drawable.main_menu_instruction,
                2
            )
        )
        menuItems.add(
            MenuItem(
                "器具检查",
                R.drawable.main_menu_maintenance,
                3
            )
        )
        menuItems.add(MenuItem("联络册", R.drawable.main_menu_assess, 4))
        menuItems.add(
            MenuItem(
                "稽查执法",
                R.drawable.main_menu_select,
                5
            )
        )
        menuItems.add(
            MenuItem(
                "事故现场",
                R.drawable.main_menu_statistics,
                6
            )
        )
        menuItems.add(
            MenuItem(
                "企业查询",
                R.drawable.main_menu_selfcheck, 9
            )
        )
        menuItems.add(MenuItem("设置中心", R.drawable.main_menu_more, 10))
        return menuItems
    }
}