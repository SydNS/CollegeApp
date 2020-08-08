package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.UTAMU.AdaptersJavaClasses.Carousel
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.frag2.view.*

class SecondFragment : Fragment() {

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
        val carousel = Carousel(items, wtslideImages)

        view.newsFlipper?.adapter = carousel
        view.newsViewPager1?.adapter = tabVieWPagers
        view.newTablayout1?.setupWithViewPager(view.newsViewPager1)

        return view
    }
}