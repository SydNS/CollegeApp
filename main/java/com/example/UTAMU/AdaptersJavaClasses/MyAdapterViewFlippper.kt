package com.example.UTAMU.AdaptersJavaClasses
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.itemdisplay.view.*

class MyAdapterViewFlippper(
    var context: Context,
    var features: Array<String>,
    var imageFeatures: IntArray
) : BaseAdapter() {
    var layoutInflater: LayoutInflater = LayoutInflater.from(context)
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
        convertView: View?,
        parent: ViewGroup
    ): View {
        val convertView = layoutInflater.inflate(R.layout.itemdisplay, parent, false)

        val textView = convertView.itemName
        val imageView = convertView.itemImage
        textView.text = features[position]
        imageView.setImageResource(imageFeatures[position])
        return convertView
    }

}