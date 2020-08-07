package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.UTAMU.AdaptersJavaClasses.FragAdapter
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.frag4.*
import kotlinx.android.synthetic.main.frag4.view.*

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


        view.frag4viewpage?.adapter = fragAdapter
        view.tablayoutffrag4?.setupWithViewPager(frag4viewpage, false)
        view.tablayoutffrag4?.setTabRippleColorResource(R.color.colorWhite)
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