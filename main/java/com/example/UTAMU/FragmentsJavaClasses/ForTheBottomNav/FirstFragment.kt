package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.content.Context
import android.net.sip.SipAudioCall
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterViewFlipper
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import com.example.UTAMU.AdaptersJavaClasses.MostViewedAdapter
import com.example.UTAMU.AdaptersJavaClasses.MyAdapterViewFlippper
import com.example.UTAMU.AdaptersJavaClasses.RCVForHorizontalDisplay
import com.example.UTAMU.DataObjects.MostViewed
import com.example.UTAMU.R
import java.util.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag1, container, false)
        val layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val exitting =
            view.findViewById<View>(R.id.exitButton) as Button
        val itemDisplay =
            view.findViewById<View>(R.id.itemDisplayRCV) as RecyclerView
        val schoolDisplay =
            view.findViewById<View>(R.id.rcvschools) as RecyclerView
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
        itemDisplay.adapter = rcvForHorizontalDisplay
        itemDisplay.layoutManager = layoutManager
        val itemAnimator: ItemAnimator = DefaultItemAnimator()
        itemDisplay.itemAnimator = itemAnimator
//        if (rcvForHorizontalDisplay != null) {
//            rcvForHorizontalDisplay.setListener(object : SipAudioCall.Listener() {
//                fun onClick(position: Int) {
//                    Toast.makeText(context, "heya its done", Toast.LENGTH_LONG).show()
//                    childFragmentManager.beginTransaction().replace(R.id.frag1, SecondFragment())
//                }
//            })
//        }


//AdapterViewFlipper's code is below this comment
        val slides =
            intArrayOf(R.layout.page1, R.layout.page2, R.layout.page3, R.layout.page4)
        var mcontext: Context
          val imageListFoAdapterView = intArrayOf(
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61
        )
//        val adapterViewFlipper =
//            view.findViewById<AdapterViewFlipper>(R.id.featuresAdapterViewFlipper)
//        adapterViewFlipper.adapter = activity?.let {
//            MyAdapterViewFlippper(
//                it,
//                nameList,
//                imageListFoAdapterView
//            )
//        }
//        adapterViewFlipper.isAutoStart = true
//        adapterViewFlipper.flipInterval = 5000

        //school recycler view dets
        val mostViewedArrayList: ArrayList<MostViewed> = ArrayList<MostViewed>()
        mostViewedArrayList.add(
            MostViewed(
                "David Kali",
                "traditional leading school",
                "Kings College",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Zion Dan",
                "Education is a priority,put it first",
                "St Mary's K",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Aaron G",
                "Offering qualtiy education to build solid foundations",
                "Namilyango College",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Gina Kali",
                "traditional leading school",
                "Homeland College",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Lolli Poppy",
                "Education is a priority,put it first",
                "Lubiri S.S.S",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Aaron G",
                "Offering qualtiy education to build solid foundations",
                "Namilyango College",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Gina Kali",
                "traditional leading school",
                "Homeland College",
                R.drawable.asui61
            )
        )
        mostViewedArrayList.add(
            MostViewed(
                "Lolli Poppy",
                "Education is a priority,put it first",
                "Lubiri S.S.S",
                R.drawable.asui61
            )
        )
        val mostViewedAdapter =
            activity?.let { MostViewedAdapter(it, mostViewedArrayList) }
        schoolDisplay.adapter = mostViewedAdapter
        val schoolslayoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val schools =
            DividerItemDecoration(context, layoutManager.orientation)
        val schoolAnimator: ItemAnimator = DefaultItemAnimator()
        itemDisplay.itemAnimator = schoolAnimator
        schoolDisplay.layoutManager = schoolslayoutManager
        val toolbar =
            view.findViewById<Toolbar>(R.id.toolbarfrag1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.setActionBar(toolbar)
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}