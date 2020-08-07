package com.example.UTAMU.Authenticating.SignupLoginFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.UTAMU.Activities.HomeActivity
import com.example.UTAMU.R
import com.example.UTAMU.SharePreforproject.Uerdetails
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONException
import org.json.JSONObject

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.login, container, false)

        val loginButton = view.findViewById<View>(R.id.loginButton) as Button
        val loginuname = view.findViewById<View>(R.id.loginuname) as TextInputLayout
        val loginpasswd = view.findViewById<View>(R.id.loginpasswd) as TextInputLayout
        val rememberme = view.findViewById<View>(R.id.rememberme) as CheckBox

        loginButton.setOnClickListener {
            val uname = loginuname.editText!!.text.toString()
            val upasswd = loginpasswd.editText!!.text.toString()
            posting(uname, upasswd)

            if (rememberme.isChecked) {
                Toast.makeText(activity, "You'll be remembered", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun posting(uname: String, upasword: String) {
        val requestQueue = Volley.newRequestQueue(activity)
        val parameters = JSONObject()
        try {
            parameters.put("username", uname)
            parameters.put("password", upasword)
            //            parameters.put("email", uemail);
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val jsonObjReq =
            JsonObjectRequest(
                Request.Method.POST,
                ROOT_URL_POST,
                parameters,
                Response.Listener { response ->
                    try {
                        val loggedin = response.getString("token") as String
                        if (loggedin.isNotEmpty()) {
                            Toast.makeText(activity, "loggedin", Toast.LENGTH_SHORT).show()
                            val unamepref = activity?.let { it1 -> Uerdetails(it1) }
                            unamepref?.save(uname, loggedin)
                            startActivity(Intent(activity, HomeActivity::class.java))
                            activity?.finish()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {
                    Toast.makeText(activity, "Invalid Credentials", Toast.LENGTH_SHORT)
                        .show()
                })

        requestQueue.add(jsonObjReq)
    }

    companion object {
        private const val ROOT_URL_POST = "http://192.168.43.87:5000/utamuapi/login/"
    }
}