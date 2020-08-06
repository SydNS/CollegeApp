package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.AdaptersJavaClasses.RCVAdapter
import com.example.UTAMU.AdaptersJavaClasses.RCVForHorizontalDisplay
import com.example.UTAMU.R

class Newest : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.newestcategory, container, false)
        val listrecyclerview =
            view.findViewById<View>(R.id.listrecyclerview) as RecyclerView
        val imageList = intArrayOf(
            R.drawable.astudio21,
            R.drawable.astudio52,
            R.drawable.astudio45,
            R.drawable.astudio49,
            R.drawable.astudio45,
            R.drawable.astudio49,
            R.drawable.astudio49
        )
        val nameList =
            arrayOf("syd", "edge", "java", "major", "edge", "java", "major")
        val rcvForHorizontalDisplay =
            activity?.let { RCVForHorizontalDisplay(it, imageList, nameList) }
        listrecyclerview.adapter = rcvForHorizontalDisplay
        listrecyclerview.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.HORIZONTAL,
            false
        )
        return view
    }
}