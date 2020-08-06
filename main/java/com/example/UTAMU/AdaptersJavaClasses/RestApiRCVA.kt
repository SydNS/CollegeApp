package com.example.UTAMU.AdaptersJavaClasses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.DataObjects.ForRest
import com.example.UTAMU.R
import java.util.*

class RestApiRCVA(
    var context: Context,
    forRests: ArrayList<ForRest>
) : RecyclerView.Adapter<RestApiRCVA.ViewHolder>() {
    var forRests: ArrayList<ForRest>
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
        val forRest: ForRest = forRests[position]
        holder.post.setText(forRest.post)
        holder.title.setText(forRest.title)
        holder.author.setText(forRest.author)
    }

    override fun getItemCount(): Int {
        return forRests.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var author: TextView
        var title: TextView
        var post: TextView

        init {
            post = itemView.findViewById(R.id.post)
            title = itemView.findViewById(R.id.title)
            author = itemView.findViewById(R.id.author)
        }
    }

    init {
        this.forRests = forRests
    }
}