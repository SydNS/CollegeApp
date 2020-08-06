package com.example.UTAMU.Adaptersforproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.Posts.ForRest
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.forestapi.view.*
import java.util.*

class RestApiRCVA(
    var context: Context,
    var forRests: ArrayList<ForRest>
) : RecyclerView.Adapter<RestApiRCVA.ViewHolder>() {
    var mylistener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun OnClick(position: Int)
    }

    fun setOnRCVItemClickListener(mylistener: OnItemClickListener?) {
        this.mylistener = mylistener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.forestapi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val forRest = forRests[position]
        holder.post.text = forRest.post
        holder.title.text = forRest.title
        holder.author.text = forRest.author
        holder.created.text = forRest.creationdate
    }

    override fun getItemCount(): Int {
        return forRests.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var author: TextView
        var title: TextView
        var post: TextView
        var created: TextView

        init {
            post = itemView.findViewById(R.id.post)
            title = itemView.findViewById(R.id.title)
            author = itemView.findViewById(R.id.author)
            created = itemView.findViewById(R.id.cdate)

//use the usual setOnClickListener and then use the interface & its methods
            itemView.setOnClickListener {
                if (mylistener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        mylistener!!.OnClick(position)
                    }
                }
            }
            itemView.author.setOnClickListener {
//                have to create an interface with code to run on this event
//                if (mylistener != null) {
//                    val position = adapterPosition
//                    if (position != RecyclerView.NO_POSITION) {
//                        mylistener!!.OnClick(position)
//                    }
//                }
                Toast.makeText(context,"your sup",Toast.LENGTH_LONG).show()
            }
        }
    }

}