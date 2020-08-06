package com.example.UTAMU.AdaptersJavaClasses
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.UTAMU.R

class MyAdapterViewFlippper(
    var context: Context,
    var features: Array<String>,
    var imageFeatures: IntArray
) : BaseAdapter() {
    var layoutInflater: LayoutInflater
    override fun getCount(): Int {
        return features.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(
        position: Int,
        convertView: View,
        parent: ViewGroup
    ): View {
        val view: View = layoutInflater.inflate(R.layout.itemdisplay, parent, false)
        val textView = view.findViewById<TextView>(R.id.itemName)
        val imageView =
            view.findViewById<ImageView>(R.id.itemImage)
        textView.text = features[position]
        imageView.setImageResource(imageFeatures[position])
        return view
    }

    init {
        layoutInflater = LayoutInflater.from(context)
    }
}