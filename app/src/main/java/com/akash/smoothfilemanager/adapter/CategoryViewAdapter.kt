package com.akash.smoothfilemanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akash.smoothfilemanager.CategoryViewHolder
import com.akash.smoothfilemanager.FileOpener.openFile
import com.akash.smoothfilemanager.R
import java.io.File
import java.io.IOException
import java.lang.Exception

class CategoryViewAdapter(
    private val context: Context,
    private val fileList:List<File>,
    private val category:String
) :RecyclerView.Adapter<CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.categoryviewholdersingle,parent , false)
          return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val tempFile= fileList[position]
        holder.textView.setText(tempFile.name)

        // to Set Image

        setImage(holder,tempFile)
        holder.itemView.setOnClickListener{
            try {
                   openFile(context,tempFile)
            }
            catch (exception:IOException){
                exception.printStackTrace()

            }
        }
    }

    private fun setImage(categoryViewHolder: CategoryViewHolder, singleFile: File) {
         when(category){
             "Image"->categoryViewHolder.image.setImageResource(R.drawable.images)
             "Video"->categoryViewHolder.image.setImageResource(R.drawable.videos)
             "Audio"->categoryViewHolder.image.setImageResource(R.drawable.audios)
             "Document"->categoryViewHolder.image.setImageResource(R.drawable.documents)
         }
    }

    override fun getItemCount(): Int {
        return fileList.size
    }


}