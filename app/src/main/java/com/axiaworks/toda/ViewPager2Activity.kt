package com.axiaworks.toda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_view_pager2.*

private const val NUM_PAGES = 4

class ViewPager2Activity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        tabs.addTab(tabs.newTab().setText("Tab 1"))
        tabs.addTab(tabs.newTab().setText("Tab 2"))
        tabs.addTab(tabs.newTab().setText("Tab 3"))
        tabs.addTab(tabs.newTab().setText("Tab 4"))
        pager.adapter = SliderPageAdapter()
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(pager))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


    }

//    private inner class SliderPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
//        override fun getItemCount(): Int = NUM_PAGES
//
//        override fun createFragment(position: Int): Fragment {
//            return when (position) {
//                0 -> SliderPage1Fragment()
//                1 -> SliderPage2Fragment()
//                2 -> SliderPage3Fragment()
//                3 -> SliderPage4Fragment()
//                else -> SliderPage1Fragment()
//            }
//        }
//    }
class SliderPageAdapter: PagerAdapter() {
    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return o === view
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Page: Item${position + 1}"
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.activity_view_pager2, container, false)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as View)
    }
}
}
