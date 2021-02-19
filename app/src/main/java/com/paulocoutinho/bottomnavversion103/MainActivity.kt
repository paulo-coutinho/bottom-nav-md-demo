package com.paulocoutinho.bottomnavversion103

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.cioccarellia.kite.Kite
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.paulocoutinho.bottomnavversion103.ui.components.CustomViewPager
import com.paulocoutinho.bottomnavversion103.ui.dashboard.DashboardFragment
import com.paulocoutinho.bottomnavversion103.ui.home.HomeFragment
import com.paulocoutinho.bottomnavversion103.ui.notifications.NotificationsFragment
import com.paulocoutinho.bottomnavversion103.ui.viewpager.MainViewPagerAdapter

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var viewPager: CustomViewPager? = null
    private var adapter: MainViewPagerAdapter? = null

    private var homeFragment: HomeFragment? = null
    private var dashboardFragment: DashboardFragment? = null
    private var notificationsFragment: NotificationsFragment? = null

    private var navigationLeft: BottomNavigationView? = null
    private var navigationRight: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adapter
        adapter = MainViewPagerAdapter(supportFragmentManager)

        // fragments
        homeFragment = HomeFragment()
        adapter?.addFragment(homeFragment!!)

        dashboardFragment = DashboardFragment()
        adapter?.addFragment(dashboardFragment!!)

        notificationsFragment = NotificationsFragment()
        adapter?.addFragment(notificationsFragment!!)

        // view pager
        viewPager = findViewById(R.id.mainViewPager)
        viewPager?.let { viewPager ->
            viewPager.disableScroll(true)
            viewPager.adapter = adapter
            viewPager.offscreenPageLimit = adapter?.count ?: 0
            viewPager.setOnTouchListener { _, _ -> true }
        }

        // bottom navigation 1
        navigationLeft = findViewById(R.id.bottom_navigation_left)

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
        navigationRight = findViewById(R.id.bottom_navigation_right)

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

}