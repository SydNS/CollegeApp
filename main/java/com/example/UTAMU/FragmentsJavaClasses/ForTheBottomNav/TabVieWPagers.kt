@file:Suppress("DEPRECATION")

package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabVieWPagers(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return Newest()
            1 -> return Newest()
            2 -> return Newest()
        }
        return Newest()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Newest"
            1 -> return "SuperDeals"
            2 -> return "Features"
        }
        return null
    }
}