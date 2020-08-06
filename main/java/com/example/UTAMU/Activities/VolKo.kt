package com.example.UTAMU.Activities

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_vol_ko.*

import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.UTAMU.R
import org.json.JSONException


class VolKo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vol_ko)

        // Run volley
        var requestQueue = Volley.newRequestQueue(this);
//        btn.setOnClickListener {
            val url = "http://pastebin.com/raw/2bW31yqa"
            textView.text = ""

            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    // Process the JSON
                    try {
                        // Get the JSON array
                        val array = response.getJSONArray("students")

                        // Loop through the array elements
                        for (i in 0 until array.length()) {
                            // Get current json object
                            val student = array.getJSONObject(i)

                            // Get the current student (json object) data
                            val firstName = student.getString("firstname")
                            val lastName = student.getString("lastname")
                            val age = student.getString("age")

                            // Display the formatted json data in text view
                            textView.append("$firstName $lastName\nage : $age")
                            textView.append("\n\n")
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },Response.ErrorListener { error ->
                    Log.d("error",error.toString())
                }
            )

            // Access the RequestQueue through singleton class.
//            SingleTon.getInstance(this).addToRequestQueue(jsonObjectRequest)
            requestQueue.add(jsonObjectRequest);
//        }
    }
}
