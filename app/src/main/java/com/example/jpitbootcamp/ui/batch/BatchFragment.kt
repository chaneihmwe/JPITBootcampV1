package com.example.jpitbootcamp.ui.batch

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jpitbootcamp.Adapter.BatchListAdapter
import com.example.jpitbootcamp.R
import com.example.jpitbootcamp.ViewModel.BatchViewModel
import com.example.jpitbootcamp.ViewModel.StudentDetailViewModel
import kotlinx.android.synthetic.main.batch_item.view.*
import kotlinx.android.synthetic.main.fragment_batch.view.*

class BatchFragment :Fragment() {
    private lateinit var batchViewModel: BatchViewModel

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_batch, container, false)
        /*var recyclerViewBatch : RecyclerView = root.findViewById(R.id.batch_recyclerview)
        var name = root.findViewById<TextView>(R.id.batch_name)
        var batchModel = Batch(1,"Batch 2")
        batchModel.batchName = name.text.toString()*/
        (activity as AppCompatActivity).supportActionBar?.title = "Batch"

        val adapter = BatchListAdapter(context)
        val recyclerView = root.findViewById<RecyclerView>(R.id.batch_recyclerview).apply {
            layoutManager = GridLayoutManager(context,2)
            this.adapter = adapter
        }
        batchViewModel = ViewModelProviders.of(this).get(BatchViewModel::class.java)

        batchViewModel.allBatches.observe(this,
            Observer { batches ->
                batches?.let { adapter.setBatchess(it) }
            })

        root.create_batch_btn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_batch_to_createBatchFragment)

            //var batchName: String? = arguments!!.getString("BatchName")
            //Log.d("BatchName", batchName)
        }

        return root
    }
}