package com.example.UTAMU.Authenticating.SignupLoginFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
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

    var signup_uname: TextInputLayout? = null
    var signup_uname2: TextInputLayout? = null
    var signup_uemail: TextInputLayout? = null
    var signup_residence: TextInputLayout? = null
    var signup_upassword1: TextInputLayout? = null
    var signup_upassword2: TextInputLayout? = null
    var firstname: String? = null
    var lastname: String? = null
    var upassd: String? = null
    var upassd2: String? = null
    var uemail: String? = null
    var residence: String? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.signup, container, false)
        signup_uname = view.findViewById<View>(R.id.signup_uname) as TextInputLayout
        signup_uname2 = view.findViewById<View>(R.id.signup_uname2) as TextInputLayout
        signup_uemail = view.findViewById<View>(R.id.signup_uemail) as TextInputLayout
        signup_residence = view.findViewById<View>(R.id.signup_residence) as TextInputLayout
        signup_upassword1 =
            view.findViewById<View>(R.id.signup_upassword1) as TextInputLayout
        signup_upassword2 =
            view.findViewById<View>(R.id.signup_upassword2) as TextInputLayout
        val signupButton =
            view.findViewById<View>(R.id.signupButton) as Button


        signupButton.setOnClickListener {

            firstname = signup_uname!!.editText!!.text.toString()
            lastname = signup_uname2!!.editText!!.text.toString()
            upassd = signup_upassword1!!.editText!!.text.toString()
            upassd2 = signup_upassword2!!.editText!!.text.toString()
            uemail = signup_uemail!!.editText!!.text.toString()
            residence = signup_residence!!.editText!!.text.toString()

            if (firstname!!.isNotEmpty() and lastname!!.isNotEmpty() and residence!!.isNotEmpty() and upassd!!.isNotEmpty() and upassd2!!.isNotEmpty() and uemail!!.isNotEmpty()) {
                if (upassd == upassd2) {
                    posting(firstname!!, lastname!!, uemail!!, residence!!, upassd!!, upassd2!!)

                } else {
                    Toast.makeText(activity, "Passwords dont match", Toast.LENGTH_SHORT).show()
                }
//                getChildFragmentManager().beginTransaction().replace(R.id.signuplayout, Login())
//                    .commit()
//                tabLayout.getTabAt(0)


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
        val tabLayout = activity!!.findViewById(R.id.tabs) as TabLayout
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
                    Toast.makeText(activity, response.toString(), Toast.LENGTH_LONG).show()
                    //                        startActivity(new Intent(getActivity(), MainActivity.class));
                    tabLayout.setScrollPosition(0, 0F, true)
                    viewPager.currentItem = 0
                },
                Response.ErrorListener {error ->
                    Toast.makeText(activity, error.toString(), Toast.LENGTH_SHORT)
                        .show()
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