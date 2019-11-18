package com.axiaworks.toda.feature.viewpager

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
import com.axiaworks.toda.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager2.*

private const val NUM_PAGES = 4

class ViewPager2Activity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        pager.adapter = SliderPageAdapter(this)
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }
}

class SliderPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SliderPage1Fragment()
            1 -> SliderPage2Fragment()
            2 -> SliderPage3Fragment()
            3 -> SliderPage4Fragment()
            else -> SliderPage1Fragment()
        }
    }
}
