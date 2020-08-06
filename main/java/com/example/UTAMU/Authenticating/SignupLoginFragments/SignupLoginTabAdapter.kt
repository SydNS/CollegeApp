@file:Suppress("DEPRECATION")

package com.example.UTAMU.Authenticating.SignupLoginFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SignupLoginTabAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Login"
            1 -> return "SignUp"
        }
        return null
}

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return Login()
            1 -> return Signup()
        }
        return Login()
    }
}