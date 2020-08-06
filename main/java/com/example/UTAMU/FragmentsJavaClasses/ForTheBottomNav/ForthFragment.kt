package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.UTAMU.AdaptersJavaClasses.FragAdapter
import com.example.UTAMU.FragmentsJavaClasses.ForTheTabs.Tab1Fragment
import com.example.UTAMU.R
import com.google.android.material.tabs.TabLayout

class ForthFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag4, container, false)
        val fragAdapter = FragAdapter(childFragmentManager)
        val frag4viewpager =
            view.findViewById<View>(R.id.frag4viewpage) as ViewPager
        val frag4tablayout =
            view.findViewById<View>(R.id.tablayoutffrag4) as TabLayout
        frag4viewpager.adapter = fragAdapter
        frag4tablayout.setupWithViewPager(frag4viewpager, false)
        frag4tablayout.setTabRippleColorResource(R.color.colorWhite)
        return view
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.addposthere, menu)
    }
}