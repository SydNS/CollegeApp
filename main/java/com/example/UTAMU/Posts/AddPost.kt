package com.example.UTAMU.Posts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.UTAMU.R
import com.example.UTAMU.SharePreforproject.Uerdetails
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONException
import org.json.JSONObject

class AddPost : AppCompatActivity() {
    var send: Button? = null
    var postauthor: TextInputLayout? = null
    var posttitle: TextInputLayout? = null
    var postsubtitle: TextInputLayout? = null
    var postpost: TextInputLayout? = null
    private var requestQueue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        var unamepref= Uerdetails(this)
        var unamefrompref: String? = unamepref.getValueString("Username")

        send = findViewById<View>(R.id.sendpost) as Button
        postauthor = findViewById<View>(R.id.postauthorlayout) as TextInputLayout
        posttitle = findViewById<View>(R.id.posttitlelayout) as TextInputLayout
        postsubtitle = findViewById<View>(R.id.postsubtitlelayout) as TextInputLayout
        postpost = findViewById<View>(R.id.postpostlayout) as TextInputLayout

        postauthor!!.hint=unamefrompref

        send!!.setOnClickListener {
            val author = unamefrompref.toString()
            val title = posttitle!!.editText!!.text.toString()
            val subtitle = postsubtitle!!.editText!!.text.toString()
            val post = postpost!!.editText!!.text.toString()
            posting(author, title, subtitle, post)
        }
    }

    private fun posting(
        author: String,
        title: String,
        subtitle: String,
        post: String
    ) {
        var requestQueue = Volley.newRequestQueue(applicationContext)
        val parameters = JSONObject()
        try {
            parameters.put("author", author)
            parameters.put("title", title)
            parameters.put("subtitle", subtitle)
            parameters.put("post", post)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val jsonObjReq =
            JsonObjectRequest(
                Request.Method.POST,
                ROOT_URL_POST,
                parameters,
                Response.Listener { //                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                    startActivity(
                        Intent(
                            applicationContext,
                            MainActivity::class.java
                        )
                    )
                },
                Response.ErrorListener { })
        requestQueue.add(jsonObjReq)
    }

    companion object {
        //    private static final String ROOT_URL_POST = "http://192.168.43.87:5000/add_api_posts".replaceAll(" ", "%20");
        private val ROOT_URL_POST =
            "http://192.168.43.87:5000/WebIntApi/allposts/".replace(" ".toRegex(), "%20")
    }
}