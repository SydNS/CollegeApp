package com.example.UTAMU.AdaptersJavaClasses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.R

class RCVAdapter(
    var context: Context,
    var names: Array<String>,
    var descriptions: Array<String>,
    var images: IntArray
) : RecyclerView.Adapter<RCVAdapter.ViewHolder>() {
    var inflater: LayoutInflater? = null

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var names: TextView
        var desc: TextView
        var imageView: ImageView

        init {
            names = itemView.findViewById(R.id.names)
            desc = itemView.findViewById(R.id.descs)
            imageView = itemView.findViewById(R.id.images)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.rcvitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.imageView.setImageResource(images[position])
        holder.names.text = names[position]
        holder.desc.text = descriptions[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }

}