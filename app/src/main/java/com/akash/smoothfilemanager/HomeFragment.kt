package com.akash.smoothfilemanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akash.smoothfilemanager.adapter.HomearraylistAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

lateinit var recyclerView1:RecyclerView
lateinit var modelArrayList:ArrayList<Model1>
lateinit var otherFiles:TextView
lateinit var goToLocal:LinearLayout
lateinit var create:LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_homefragment, container, false)

recyclerView1= view.findViewById(R.id.homeRecycler1)
        otherFiles= view.findViewById(R.id.other)
        goToLocal= view.findViewById(R.id.gotolocal)
        create= view.findViewById(R.id.create)
        return view
    }
    private fun recycler1(){
        modelArrayList= ArrayList()
        // add all categories, images, audio etc
        modelArrayList.add(Model1("Images", R.drawable.images_icon))
        modelArrayList.add(Model1("Videos", R.drawable.video_icon))
        modelArrayList.add(Model1("Audios", R.drawable.audio_icon))
        modelArrayList.add(Model1("Documents", R.drawable.documents_icon))

        recyclerView1.layoutManager= GridLayoutManager(context,2)
        recyclerView1.adapter= HomearraylistAdapter(modelArrayList,requireContext())

    }

}