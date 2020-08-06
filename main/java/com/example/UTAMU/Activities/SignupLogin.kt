package com.example.UTAMU.Activities


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.UTAMU.Authenticating.SignupLoginFragments.SignupLoginTabAdapter
import com.example.UTAMU.R
import com.google.android.material.tabs.TabLayout

class SignupLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_login)
        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        //        setSupportActionBar(toolbar);
        val viewPager =
            findViewById<View>(R.id.viewLoginandSignup) as ViewPager
        viewPager.adapter = SignupLoginTabAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}