package com.akash.smoothfilemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class HomeCategory : AppCompatActivity() {

    lateinit var category:String
    lateinit var categoryName:TextView
    lateinit var fileLink:String
    lateinit var categoryRecycler:RecyclerView
    lateinit var datas:MutableList<File>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_category)
        category= intent.getStringExtra("category").toString()
        categoryName= findViewById(R.id.homeCategory) as TextView
        categoryRecycler= findViewById(R.id.homeCategoryRecycler) as RecyclerView

        datas= ArrayList()
        fileLink= System.getenv("EXTERNAL_STORAGE")
        gettingFile(fileLink)

    }
    private  fun gettingFile( path:String){
        var file= File(path)
        if(file.isDirectory && file.canRead())
        {
            val listOfFiles=file.listFiles()
            for(singleFile in listOfFiles)
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
        var fileName:String= singleFile.name.lowercase(Locale.getDefault())

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