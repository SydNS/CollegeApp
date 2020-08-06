package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterViewFlipper
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.UTAMU.AdaptersJavaClasses.Carousel
import com.example.UTAMU.R
import com.example.UTAMU.WalkThrough.WalkthroughAdapter
import com.google.android.material.tabs.TabLayout

class SecondFragment : Fragment() {
    var newsFlipper: ViewPager2? = null
    var newsTab1: ViewPager? = null
    var TabCategoriesViewPager: ViewPager? = null
    var TabNews1: TabLayout? = null
    var TabCategories: TabLayout? = null

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11"
    )
    private val wtslideImages =
        listOf(
            R.drawable.astudio45,
            R.drawable.sld,
            R.drawable.sld2,
            R.drawable.astudio52
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag2, container, false)
        val tabVieWPagers = TabVieWPagers(childFragmentManager)
        val carousel =Carousel(items, wtslideImages)


        newsFlipper = view.findViewById<View>(R.id.newsFlipper) as ViewPager2
        newsFlipper!!.adapter = carousel

        TabNews1 = view.findViewById<View>(R.id.newTab1) as TabLayout
        TabCategories = view.findViewById<View>(R.id.TabCategories) as TabLayout
        newsTab1 = view.findViewById<View>(R.id.newTab1ViewPager) as ViewPager
        TabCategoriesViewPager =
            view.findViewById<View>(R.id.TabCategoriesViewPager) as ViewPager
        newsTab1!!.adapter = tabVieWPagers
        TabNews1!!.setupWithViewPager(newsTab1)
        return view
    }
}