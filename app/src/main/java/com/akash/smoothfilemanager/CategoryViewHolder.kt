package com.akash.smoothfilemanager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    var image:ImageView= itemView.findViewById(R.id.imageCategoryView)
    var textView:TextView=itemView.findViewById(R.id.textCategoryView)

}