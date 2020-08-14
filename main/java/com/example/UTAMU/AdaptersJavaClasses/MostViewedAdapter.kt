package com.example.UTAMU.AdaptersJavaClasses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.DataObjects.MostViewed
import com.example.UTAMU.R
import com.squareup.picasso.Picasso
import java.util.*

class MostViewedAdapter(
    var context: Context,
    var mostVieweds: ArrayList<MostViewed>
) : RecyclerView.Adapter<MostViewedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.most_viewed, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val feature: MostViewed = mostVieweds[position]

        holder.DescView.text = feature.desc
        holder.NameView.text = feature.name
        holder.SchoolView.text = feature.school
//        holder.imageSchool.setImageResource(feature.imageSchool)
        Picasso.get().load(feature.imageSchool).fit().into(holder.imageSchool)

    }

    override fun getItemCount(): Int {
        return mostVieweds.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var NameView: TextView = itemView.findViewById(R.id.NameView)
        var DescView: TextView = itemView.findViewById(R.id.DescView)
        var SchoolView: TextView = itemView.findViewById(R.id.SchoolView)
        var imageSchool: ImageView = itemView.findViewById(R.id.imageSchool)

    }

}