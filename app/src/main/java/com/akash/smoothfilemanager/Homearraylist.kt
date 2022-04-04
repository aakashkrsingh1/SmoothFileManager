package com.akash.smoothfilemanager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//ViewHolder
class Homearraylist (itemView: View):RecyclerView.ViewHolder(itemView){
    var img:ImageView= itemView.findViewById(R.id.showImageHome)
    var text1:TextView= itemView.findViewById(R.id.showTextHome)
}