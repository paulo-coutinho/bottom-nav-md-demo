package com.paulocoutinho.bottomnavversion103.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.*

class MainViewPagerAdapter(fragmentManager: FragmentManager?) :
    FragmentStatePagerAdapter(fragmentManager!!) {
    private val tabTitles: List<String> =
        object : ArrayList<String>() {
            init {
                add("Normal")
                add("Big")
            }
        }

    private val tabs: ArrayList<Fragment> =
        ArrayList()

    fun addFragment(fragment: Fragment) {
        tabs.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        return tabs[position]
    }

    override fun getCount(): Int {
        return tabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}
