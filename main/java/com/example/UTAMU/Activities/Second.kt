package com.example.UTAMU.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.UTAMU.Adaptersforproject.RCVAdapterTrial
import com.example.UTAMU.R
import com.example.UTAMU.WalkThrough.WalkThrough
import kotlinx.android.synthetic.main.activity_second.*


class Second : AppCompatActivity(), RCVAdapterTrial.OnItemClickListener {
    //    lateinit var tv:TextView
    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var tv=tvsecond
        var smtxt = intent.getStringExtra("names")
        tv.text = "$smtxt"
        val rcvAdapter= RCVAdapterTrial(items)
        recvitem.adapter=rcvAdapter
        recvitem.layoutManager=LinearLayoutManager(this)
        rcvAdapter.setOnItemClickListener(this)

        tv.setOnClickListener {
            intent=Intent(this, WalkThrough::class.java)
            startActivity(intent)
        }


        

    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(applicationContext,
            WalkThrough::class.java))

    }

}