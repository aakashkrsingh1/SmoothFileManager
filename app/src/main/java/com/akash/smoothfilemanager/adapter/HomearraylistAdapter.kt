package com.akash.smoothfilemanager.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.akash.smoothfilemanager.HomeCategory
import com.akash.smoothfilemanager.Homearraylist
import com.akash.smoothfilemanager.Model1
import com.akash.smoothfilemanager.R

class HomearraylistAdapter(var model1ArrayList:ArrayList<Model1>, var context:Context):
    RecyclerView.Adapter<Homearraylist>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Homearraylist {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.homesingle,parent,false)
        return Homearraylist(view)
    }

    override fun onBindViewHolder(holder: Homearraylist, position: Int) {
        val temp= model1ArrayList[position]
        holder.img.setImageResource(temp.image)
        holder.text1.setText(temp.text1)
        holder.itemView.setOnClickListener{
            Toast.makeText(context,"Fetching ${holder.text1.text}s", Toast.LENGTH_SHORT).show()
            val intent=Intent(context, HomeCategory ::class.java)
            intent.putExtra("category",temp.text1)
            context.startActivity(intent)


        }
    }

    override fun getItemCount(): Int {

        return model1ArrayList.size;
    }

}