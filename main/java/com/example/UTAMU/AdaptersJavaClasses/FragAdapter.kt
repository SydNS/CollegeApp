@file:Suppress("DEPRECATION")

package com.example.UTAMU.AdaptersJavaClasses

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.UTAMU.FragmentsJavaClasses.ForTheTabs.Tab1Fragment
import com.example.UTAMU.FragmentsJavaClasses.ForTheTabs.Tab2Fragment
import com.example.UTAMU.FragmentsJavaClasses.ForTheTabs.Tab3Fragment
import com.example.UTAMU.FragmentsJavaClasses.ForTheTabs.Tab4Fragment

class FragAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return Tab1Fragment()
            1 -> return Tab2Fragment()
            2 -> return Tab3Fragment()
            3 -> return Tab4Fragment()
        }
        return Tab1Fragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Parks"
            1 -> return "WaterBodies"
            2 -> return "Landforms"
            3 -> return "tab1"
        }
        return null
    }
}