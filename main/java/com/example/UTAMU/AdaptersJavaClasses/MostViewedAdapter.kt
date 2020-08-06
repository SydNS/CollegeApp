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
import java.util.*

class MostViewedAdapter(
    var context: Context,
    mostVieweds: ArrayList<MostViewed>
) : RecyclerView.Adapter<MostViewedAdapter.ViewHolder>() {
    var mostVieweds: ArrayList<MostViewed>
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
        holder.DescView.setText(feature.desc)
        holder.NameView.setText(feature.name)
        holder.SchoolView.setText(feature.school)
        holder.imageSchool.setImageResource(feature.imageSchool)
    }

    override fun getItemCount(): Int {
        return mostVieweds.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var NameView: TextView
        var DescView: TextView
        var SchoolView: TextView
        var imageSchool: ImageView

        init {
            NameView = itemView.findViewById(R.id.NameView)
            DescView = itemView.findViewById(R.id.DescView)
            SchoolView = itemView.findViewById(R.id.SchoolView)
            imageSchool = itemView.findViewById(R.id.imageSchool)
        }
    }

    init {
        this.mostVieweds = mostVieweds
    }
}