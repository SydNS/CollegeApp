package com.example.UTAMU.Adaptersforproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.R

class RCVAdapterTrial(val items: List<String>) : RecyclerView.Adapter<RCVAdapterTrial.ViewHolder>() {

    lateinit var mlistener: OnItemClickListener
    lateinit var ctx:Activity
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(mlistener: OnItemClickListener): Unit {
        this.mlistener = mlistener

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItem: TextView = itemView.findViewById(R.id.itemmtv)

//        init {
//            Toast.makeText(ctx,"sdssd",Toast.LENGTH_LONG).show()
////            itemView.setOnClickListener {
////                if (mlistener != null) {
////                    val position = adapterPosition
////                    if (position != RecyclerView.NO_POSITION) {
////                        mlistener.onItemClick(position)
////                    }
////                }
////
////            }
////            itemView
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder =
            LayoutInflater.from(parent.context).inflate(R.layout.itemviewlayout, parent, false)
        return ViewHolder(holder)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text = items[position]
    }

}