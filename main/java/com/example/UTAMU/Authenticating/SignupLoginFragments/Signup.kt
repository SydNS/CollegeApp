@file:Suppress("DEPRECATION")

package com.example.UTAMU.Authenticating.SignupLoginFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android.volley.ClientError
import com.android.volley.NoConnectionError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.UTAMU.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONException
import org.json.JSONObject


class Signup : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.signup, container, false)
        val signup_uname = view.findViewById<View>(R.id.signup_uname) as TextInputLayout
        val signup_uname2 = view.findViewById<View>(R.id.signup_uname2) as TextInputLayout
        val signup_uemail = view.findViewById<View>(R.id.signup_uemail) as TextInputLayout
        val signup_residence = view.findViewById<View>(R.id.signup_residence) as TextInputLayout
        val signup_upassword1 = view.findViewById<View>(R.id.signup_upassword1) as TextInputLayout
        val signup_upassword2 = view.findViewById<View>(R.id.signup_upassword2) as TextInputLayout

        val signupButton = view.findViewById<View>(R.id.signupButton) as Button
        signupButton.setOnClickListener {


            val firstname = signup_uname.editText!!.text.toString()
            val lastname = signup_uname2.editText!!.text.toString()
            val upassd = signup_upassword1.editText!!.text.toString()
            val upassd2 = signup_upassword2.editText!!.text.toString()
            val uemail = signup_uemail.editText!!.text.toString()
            val residence = signup_residence.editText!!.text.toString()

            if (firstname.isNotEmpty() and lastname.isNotEmpty() and residence.isNotEmpty() and upassd.isNotEmpty() and upassd2.isNotEmpty() and uemail.isNotEmpty()) {
                if (upassd == upassd2) {
                    posting(firstname, lastname, uemail, residence, upassd, upassd2)

                } else {
                    Toast.makeText(activity, "Passwords dont match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Fill in All the Fields", Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }


    private fun posting(
        firstname: String,
        lastname: String,
        uemail: String,
        residence: String,
        upasword: String,
        upasword2: String
    ) {
        val tabLayout = activity?.findViewById(R.id.tabs) as TabLayout
        val viewPager = activity?.findViewById<View>(R.id.viewLoginandSignup) as ViewPager
        val requestQueue = Volley.newRequestQueue(activity)
        val parameters = JSONObject()
        try {

            parameters.put("lastname", firstname)
            parameters.put("firstname", lastname)
            parameters.put("password_1", upasword)
            parameters.put("password2", upasword2)
            parameters.put("residence", residence)
            parameters.put("Uemail", uemail)

        } catch (e: JSONException) {
            e.printStackTrace()
            Toast.makeText(activity, "response.toString()", Toast.LENGTH_LONG).show()

        }
        val jsonObjReq =
            JsonObjectRequest(
                Request.Method.POST,
                ROOT_URL_POST,
                parameters,
                Response.Listener { response ->
                    val fname: String = response.get("firstname") as String
                    val lname: String = response.get("lastname") as String
                    Toast.makeText(
                        activity,
                        "Hey $lname $fname You're Most Welcome ",
                        Toast.LENGTH_LONG
                    ).show()
                    tabLayout.setScrollPosition(0, 0F, true)
                    viewPager.currentItem = 0
                },
                Response.ErrorListener { error ->
                    when (error) {
                        is NoConnectionError -> Toast.makeText(
                            activity,
                            "Encountered Some Connection Issues, Ensure You have internet Connection",
                            Toast.LENGTH_SHORT
                        ).show()
                        is ClientError -> Toast.makeText(
                            activity,
                            "Credential Errors",
                            Toast.LENGTH_SHORT
                        ).show()
                        else -> Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT)
                            .show()

                    }

                })
        requestQueue.add(jsonObjReq)
    }

    companion object {
        private const val ROOT_URL_POST = "http://192.168.43.87:5000/utamuapi/registration/"
    }
}

//    {
//        "firstname": "marshall",
//        "lastname": "eriksen",
//        "Uemail": "marshall@himym.com",
//        "residence": "NYC",
//        "password_1":"marshall",
//        "password2":"marshall"
//    }
//