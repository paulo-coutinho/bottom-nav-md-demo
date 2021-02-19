package com.paulocoutinho.bottomnavversion103

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cioccarellia.kite.Kite
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.paulocoutinho.bottomnavversion103.ui.components.CustomViewPager
import com.paulocoutinho.bottomnavversion103.ui.dashboard.DashboardFragment
import com.paulocoutinho.bottomnavversion103.ui.home.HomeFragment
import com.paulocoutinho.bottomnavversion103.ui.notifications.NotificationsFragment
import com.paulocoutinho.bottomnavversion103.ui.viewpager.MainViewPagerAdapter

class MainFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var viewPager: CustomViewPager? = null
    private var adapter: MainViewPagerAdapter? = null

    private var homeFragment: HomeFragment? = null
    private var dashboardFragment: DashboardFragment? = null
    private var notificationsFragment: NotificationsFragment? = null

    private var navigationLeft: BottomNavigationView? = null
    private var navigationRight: BottomNavigationView? = null

    fun createAll(view: View) {
        // adapter
        adapter = MainViewPagerAdapter(requireActivity().supportFragmentManager)

        // fragments
        homeFragment = HomeFragment()
        adapter?.addFragment(homeFragment!!)

        dashboardFragment = DashboardFragment()
        adapter?.addFragment(dashboardFragment!!)

        notificationsFragment = NotificationsFragment()
        adapter?.addFragment(notificationsFragment!!)

        // view pager
        viewPager = view.findViewById(R.id.mainViewPager)
        viewPager?.let { viewPager ->
            viewPager.disableScroll(true)
            viewPager.adapter = adapter
            viewPager.offscreenPageLimit = adapter?.count ?: 0
            viewPager.setOnTouchListener { _, _ -> true }
        }

        // bottom navigation 1
        navigationLeft = view.findViewById(R.id.bottom_navigation_left)

        navigationLeft?.let { navigationLeft ->
            navigationLeft.setOnNavigationItemSelectedListener(this)

            navigationLeft.setBackgroundColor(Kite.color[R.color.grey_300])

            navigationLeft.itemIconTintList = UIUtil.buildColorStateList(
                R.color.red_500,
                R.color.grey_800
            )

            navigationLeft.itemTextColor = UIUtil.buildColorStateList(
                R.color.red_500,
                R.color.grey_800
            )

            navigationLeft.inflateMenu(R.menu.navigation_left_1)
        }

        // bottom navigation 2
        navigationRight = view.findViewById(R.id.bottom_navigation_right)

        navigationRight?.let { navigationRight ->
            navigationRight.setOnNavigationItemSelectedListener(this)

            navigationRight.setBackgroundColor(Kite.color[R.color.grey_300])

            navigationRight.itemIconTintList = UIUtil.buildColorStateList(
                R.color.red_500,
                R.color.grey_800
            )

            navigationRight.itemTextColor = UIUtil.buildColorStateList(
                R.color.red_500,
                R.color.grey_800
            )

            navigationRight.inflateMenu(R.menu.navigation_right_1)
            navigationRight.menu.setGroupCheckable(0, false, true)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tab_home_left -> {
                viewPager?.currentItem = 0
                navigationLeft?.menu?.setGroupCheckable(0, true, true)
                navigationRight?.menu?.setGroupCheckable(0, false, true)

                return true
            }
            R.id.tab_my_products_left -> {
                viewPager?.currentItem = 0
                navigationLeft?.menu?.setGroupCheckable(0, true, true)
                navigationRight?.menu?.setGroupCheckable(0, false, true)

                return true
            }
            R.id.tab_news_right -> {
                viewPager?.currentItem = 1
                navigationLeft?.menu?.setGroupCheckable(0, false, true)
                navigationRight?.menu?.setGroupCheckable(0, true, true)

                return true
            }
            R.id.tab_radio_right -> {
                viewPager?.currentItem = 1
                navigationLeft?.menu?.setGroupCheckable(0, false, true)
                navigationRight?.menu?.setGroupCheckable(0, true, true)

                return true
            }
        }

        return false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        createAll(view)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

    }

}