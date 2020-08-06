package com.example.UTAMU.Posts

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.UTAMU.Adaptersforproject.RestApiRCVA
import com.example.UTAMU.R
import com.example.UTAMU.SharePreforproject.Uerdetails
import org.json.JSONException
import java.util.*

class MainActivity : AppCompatActivity(),
    RestApiRCVA.OnItemClickListener {
    private val INTERNET_PERMISSION_CODE = 1
    var id = 0

    //    private static final String REGISTER = "http://192.168.43.87/Android/v1/user.php";
    var requestQueue: RequestQueue? = null
    var recyclerView: RecyclerView? = null
    var forRestArrayList: ArrayList<ForRest>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //getting the username from the login prefernces to set the ActionBar Title
        val unamepref= Uerdetails(this)
        val unamefrompref: String? = unamepref.getValueString("Username")

        supportActionBar?.title = unamefrompref
        forRestArrayList = ArrayList()
        recyclerView = findViewById<View>(R.id.profName) as RecyclerView
        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        val jsonArrayRequest =
            JsonArrayRequest(
                Request.Method.GET,
                ROOT_URL,
                null,
                Response.Listener { response ->
                    try {
//                            JSONArray jsonArray = response.getJSONArray("List of Posts");
                        for (i in 0 until response.length()) {
                            val jsonObject = response.getJSONObject(i)
                            id = jsonObject.getInt("id")
                            val author =
                                jsonObject.getString("author") as String
                            val title =
                                jsonObject.getString("title") as String
                            val post =
                                jsonObject.getString("post") as String
                            //                                String post = (String) jsonObject.getString("subtitle");
                            val creationDate =
                                jsonObject.getString("creationDate") as String
                            forRestArrayList!!.add(ForRest(title, post, author, creationDate, id))
                        }
                        val restApiRCVA =
                            RestApiRCVA(
                                this@MainActivity,
                                forRestArrayList!!
                            )
                        recyclerView!!.adapter = restApiRCVA
                        val schoolslayoutManager =
                            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                        recyclerView!!.layoutManager = schoolslayoutManager
                        restApiRCVA.setOnRCVItemClickListener(this@MainActivity)
                    } catch (e: JSONException) {
//                                    e.printStackTrace();
//                                    profName.setText(""+e);
                        Toast.makeText(
                            this@MainActivity,
                            "error ocurred$e",
                            Toast.LENGTH_SHORT
                        ).show()
                        println(e)
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this@MainActivity, "Sorry$error", Toast.LENGTH_SHORT)
                        .show()
                })
        requestQueue.add(jsonArrayRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add -> {
                val intent = Intent(this, AddPost::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun OnClick(position: Int) {
        val intent = Intent(applicationContext, PostDetails::class.java)
        val item = forRestArrayList!![position]
        intent.putExtra("postId", item.id)
        intent.putExtra("postTitle", item.title)
        intent.putExtra("postBody", item.post)
        startActivity(intent)
    }

    companion object {
        //    private static final String ROOT_URL = "http://192.168.43.87:5000/api_posts";
        private const val ROOT_URL = "http://192.168.43.87:5000/WebIntApi/allposts/"
    }
}