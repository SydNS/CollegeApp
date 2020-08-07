package com.example.UTAMU.FragmentsJavaClasses.ForTheBottomNav

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.AdaptersJavaClasses.MostViewedAdapter
import com.example.UTAMU.AdaptersJavaClasses.MyAdapterViewFlippper
import com.example.UTAMU.AdaptersJavaClasses.RCVForHorizontalDisplay
import com.example.UTAMU.DataObjects.MostViewed
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.frag1.*
import kotlinx.android.synthetic.main.frag1.view.*
import java.util.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.frag1, container, false)
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity!!.setActionBar(toolbarfrag1)
        }

        val imageList = intArrayOf(
            R.drawable.astudio21,
            R.drawable.astudio52,
            R.drawable.astudio45,
            R.drawable.astudio49,
            R.drawable.astudio45,
            R.drawable.astudio49,
            R.drawable.astudio49
        )
        val nameList = arrayOf("syd", "edge", "java", "major", "edge", "java", "major")
        val rcvForHorizontalDisplay =
            activity?.let { RCVForHorizontalDisplay(it, imageList, nameList) }

        val itemDisplayRCV: RecyclerView = view.findViewById(R.id.itemDisplayRCV)
        itemDisplayRCV.adapter = rcvForHorizontalDisplay
        itemDisplayRCV.layoutManager = layoutManager

//AdapterViewFlipper's code is below this comment
//        val featuresAdapterViewFlipper:AdapterViewFlipper=view.findViewById(R.id.featuresAdapterViewFlipper)
        val imageListFoAdapterView = intArrayOf(
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61,
            R.drawable.asui61
        )
        view.featuresAdapterViewFlipper?.adapter = activity?.let {
            MyAdapterViewFlippper(
                it,
                nameList,
                imageListFoAdapterView
            )
        }
        view.featuresAdapterViewFlipper?.isAutoStart = true
        view.featuresAdapterViewFlipper?.flipInterval = 5000

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

        view.rcvschools.adapter = mostViewedAdapter
        val schoolslayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        view.rcvschools.layoutManager = schoolslayoutManager

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}