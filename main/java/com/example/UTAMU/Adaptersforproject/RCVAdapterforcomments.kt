package com.example.UTAMU.Adaptersforproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.UTAMU.R
import kotlinx.android.synthetic.main.commentrow.view.*
import java.util.ArrayList

class RCVAdapterforcomments(
    var context: Context,
    var forComments: ArrayList<ForComments>
) : RecyclerView.Adapter<RCVAdapterforcomments.ViewHolder>() {
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
            LayoutInflater.from(context).inflate(R.layout.commentrow, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val forComment = forComments[position]

        holder.commentbody.text = forComment.body
        holder.commentcreateddate.text = forComment.created
        holder.commentorsname.text = forComment.name
    }

    override fun getItemCount(): Int {
        return forComments.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var commentcreateddate: TextView
        var commentorsname: TextView
        var commentbody: TextView

        init {
            commentbody = itemView.findViewById(R.id.commentbody)
            commentorsname = itemView.findViewById(R.id.commentorsname)
            commentcreateddate = itemView.findViewById(R.id.commentcreateddate)

//use the usual setOnClickListener and then use the interface & its methods
            itemView.setOnClickListener {
                if (mylistener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        mylistener!!.OnClick(position)
                    }
                }
            }
            itemView.commentorsname.setOnClickListener {
//                have to create an interface with code to run on this event
//                if (mylistener != null) {
//                    val position = adapterPosition
//                    if (position != RecyclerView.NO_POSITION) {
//                        mylistener!!.OnClick(position)
//                    }
//                }
                Toast.makeText(context, "your sup", Toast.LENGTH_LONG).show()
            }
        }
    }


}
