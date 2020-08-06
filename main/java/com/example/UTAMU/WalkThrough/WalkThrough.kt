package com.example.UTAMU.WalkThrough

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.UTAMU.Activities.SignupLogin
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.activity_walk_through.*

class WalkThrough : AppCompatActivity() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)

        val walkthroughvp = walkthroughvp as ViewPager2
        walkthroughvp.adapter =
            WalkthroughAdapter(items, wtslideImages)
        walkthroughvp.offscreenPageLimit = 3

        //buttons
        nextbutton.setOnClickListener {
            walkthroughvp.currentItem = walkthroughvp.currentItem + 1
        }

        skipbutton.setOnClickListener {
            walkthroughvp.currentItem=items.size-1
        }
        startbutton.setOnClickListener {
            startActivity(Intent(this, SignupLogin::class.java))
            finish()
        }

        walkthroughvp.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                skipbuttonvisility(position)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("Selected_Page", position.toString())
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })


    }

    private fun skipbuttonvisility(position: Int) {
        val skipstart = AnimationUtils.loadAnimation(this,
            R.anim.skipstart
        )
        val startskip = AnimationUtils.loadAnimation(this,
            R.anim.startskip
        )
        if (position == items.size - 1) {
            nextbutton.visibility = View.INVISIBLE
            skipbutton.visibility = View.INVISIBLE
            nextbutton.animation = skipstart
            startbutton.visibility = View.VISIBLE
            startbutton.animation = startskip

        } else if (position < items.size - 1) {
            nextbutton.visibility = View.VISIBLE
            startbutton.visibility = View.INVISIBLE
            skipbutton.visibility = View.VISIBLE

        }
    }
}