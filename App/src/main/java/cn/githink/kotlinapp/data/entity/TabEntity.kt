package cn.githink.kotlinapp.data.entity

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(var title: String, private var selectedIcon: Int, private var unSelectedIcon: Int): CustomTabEntity {
    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabTitle(): String {
        return title
    }
}