package com.example.UTAMU.Activities

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.UTAMU.Authenticating.SignupLoginFragments.SignupLoginTabAdapter
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.activity_signup_login.*

class SignupLogin : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_login)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )

        viewLoginandSignup.adapter = SignupLoginTabAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewLoginandSignup)
    }
}