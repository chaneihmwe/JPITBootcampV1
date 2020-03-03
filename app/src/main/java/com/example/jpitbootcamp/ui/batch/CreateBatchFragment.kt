package com.example.jpitbootcamp.ui.batch

import com.example.jpitbootcamp.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.ViewModel.BatchViewModel
import kotlinx.android.synthetic.main.fragment_create_batch.view.*

/**
 * A simple [Fragment] subclass.
 */
class CreateBatchFragment : Fragment() {
    private lateinit var batchViewModel: BatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_create_batch, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Create Batch"

        root.add_batch_btn.setOnClickListener { _: View ->
            var batchName:String = root.findViewById<TextView>(R.id.edit_batch_name).text.toString()
            Log.d("Batch Name", batchName)

            batchViewModel = ViewModelProviders.of(this).get(BatchViewModel::class.java)
            batchViewModel.insert(Batch(0,batchName))

            root.findNavController().navigate(R.id.action_createBatchFragment_to_nav_batch)
        }

        return root.rootView

    }

}
