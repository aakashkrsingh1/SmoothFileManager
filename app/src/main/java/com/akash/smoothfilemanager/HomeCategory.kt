package com.akash.smoothfilemanager

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akash.smoothfilemanager.adapter.CategoryViewAdapter
import java.io.File
import java.util.*
import java.util.logging.LogManager
import kotlin.collections.ArrayList

class HomeCategory : AppCompatActivity() {

    lateinit var category:String
    lateinit var categoryName:TextView
    lateinit var fileLink:String
    lateinit var categoryRecycler:RecyclerView
    lateinit var datas:MutableList<File>
    lateinit var  categoryViewAdapter: CategoryViewAdapter


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_category)
        category= intent.getStringExtra("category").toString()
        categoryName= findViewById(R.id.homeCategory) as TextView
        categoryRecycler= findViewById(R.id.homeCategoryRecycler) as RecyclerView
        categoryRecycler.layoutManager= LinearLayoutManager(this)

        datas= ArrayList()
        categoryViewAdapter= CategoryViewAdapter(this@HomeCategory, datas as ArrayList<File>, category)
        categoryRecycler.adapter= categoryViewAdapter





        categoryName.text= category
       // fileLink= Environment.getDataDirectory().absolutePath
        fileLink= System.getenv("") as String
        gettingFile(fileLink)

    }
    private  fun gettingFile( path:String){
        val file= File(path)
        if(file.isDirectory && file.canRead())
        {
            val listOfFiles=file.listFiles()
            for(singleFile in listOfFiles!!)
            {
                if(singleFile.isDirectory && singleFile.canRead())
                    gettingFile(singleFile.absolutePath)
                else if(singleFile.isFile && singleFile.canRead())
                    display(singleFile)
            }

        }
        else if (file.isFile && file.canRead())
        {
            display(file)
        }

    }

    private fun display(singleFile: File) {
        val fileName:String= singleFile.name.lowercase(Locale.getDefault())

      when(category){
          "Image"->if(fileName.endsWith(".png")|| fileName.contains(".jpg")|| fileName.contains(".jpeg")|| fileName.contains(".gif"))
          {
              datas.add(singleFile)
          }
          "Video"->if(fileName.endsWith(".mp3")|| fileName.contains(".wav"))
          {
              datas.add(singleFile)
          }
          "Document"->if(fileName.endsWith(".pdf")|| fileName.contains(".txt"))
          {
              datas.add(singleFile)
          }
      }
    }
}