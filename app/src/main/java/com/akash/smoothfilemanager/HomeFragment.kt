package com.akash.smoothfilemanager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akash.smoothfilemanager.adapter.HomearraylistAdapter
import com.karumi.dexter.Dexter
import com.karumi.dexter.DexterBuilder
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.util.jar.Manifest
import android.content.Intent

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
        goToLocal.setOnClickListener{
            Toast.makeText(requireContext()," I am internal storage.",Toast.LENGTH_SHORT).show()

        }
        create= view.findViewById(R.id.create) 
        create.setOnClickListener{
            Toast.makeText(requireContext(),"Other Files and Folders",Toast.LENGTH_SHORT).show()
        }
        runtimepermission()
        return view
    }
    private fun recycler1(){
        modelArrayList= ArrayList()
        // add all categories, images, audio etc
        modelArrayList.add(Model1("Image", R.drawable.images_icon))
        modelArrayList.add(Model1("Video", R.drawable.video_icon))
        modelArrayList.add(Model1("Audio", R.drawable.audio_icon))
        modelArrayList.add(Model1("Document", R.drawable.documents_icon))

        recyclerView1.layoutManager= GridLayoutManager(context,2)
        recyclerView1.adapter= HomearraylistAdapter(modelArrayList,requireContext())

    }
    private fun runtimepermission(){
        Dexter.withContext(context).withPermissions(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE).withListener(object : MultiplePermissionsListener{
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                if(p0!!.areAllPermissionsGranted())
                {
                    recycler1()
                    Toast.makeText(requireContext(),"Permission Granted. ", Toast.LENGTH_SHORT).show()}
                else{
                    Toast.makeText(requireContext(),"Permission Denied. Please try again. ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {
                p1!!.continuePermissionRequest()
            }

        }).check()
    }

}