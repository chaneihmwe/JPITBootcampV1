package com.example.jpitbootcamp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_batch.view.*
import kotlinx.android.synthetic.main.fragment_create_batch.view.*

/**
 * A simple [Fragment] subclass.
 */
class CreateBatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_create_batch, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Create Batch"


        root.add_batch_btn.setOnClickListener { veiw: View ->
            var batchName:String = root.findViewById<TextView>(R.id.edit_batch_name).text.toString()
            Log.d("Batch Name", batchName)
            root.findNavController().navigate(R.id.action_createBatchFragment_to_nav_batch)
        }
        return root.rootView

    }


}
