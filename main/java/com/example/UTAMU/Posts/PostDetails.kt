package com.example.UTAMU.Posts

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.UTAMU.Adaptersforproject.ForComments
import com.example.UTAMU.Adaptersforproject.RCVAdapterforcomments
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.activity_post_details.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class PostDetails : AppCompatActivity() {
    var requestQueue: RequestQueue? = null
    lateinit var forCommentsArrayList: ArrayList<ForComments>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        setSupportActionBar(toolbar)
        val detes = findViewById<View>(R.id.detes) as TextView
        forCommentsArrayList= ArrayList()
        val intentWithPostId = intent
        supportActionBar?.title= intentWithPostId.extras!!.getString("postTitle")
        detes.text= intentWithPostId.extras!!.getString("postBody")

        val ROOT_URL =
            "http://192.168.43.87:5000/WebIntApi/allposts/${intentWithPostId.extras!!.getInt("postId")}"
        val requestQueue = Volley.newRequestQueue(applicationContext)
        val jsonObjectRequestt =
            JsonObjectRequest(
                Request.Method.GET, ROOT_URL, null,
                Response.Listener { response ->
                    try {
//                        ${response.getInt("id")}
                        val author =
                            response.getString("author") as String
                        val title = response.getString("title") as String
                        val post = response.getString("post") as String
                        val creationDate = response.getString("creationDate") as String
                        val postcomments = response.getJSONArray("comments") as JSONArray

                        for (i in 0 until postcomments.length()) {

                            val commentjsonObject = postcomments[i] as JSONObject

                            val commentorname:String = commentjsonObject.getString("name")
                            val commentbody:String = commentjsonObject.getString("body")
                            val commentcreated:String = commentjsonObject.getString("created")
//                            val date = LocalDate.parse(commentcreated, DateTimeFormatter.ISO_DATE)
//                            commenttv.append("$commentorname $commentbody $commentcreated")

                            forCommentsArrayList.add(ForComments(commentbody,commentorname,commentcreated))

                        }
                        val rcvAdapterforcomments =RCVAdapterforcomments(this,forCommentsArrayList)
                        commentrcv.adapter=rcvAdapterforcomments
                        commentrcv.layoutManager= LinearLayoutManager(this)

                    } catch (ex: JSONException) {
                        ex.printStackTrace()
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(applicationContext, "Sorry$error", Toast.LENGTH_SHORT)
                        .show()
                })
        requestQueue.add(jsonObjectRequestt)
    }
}