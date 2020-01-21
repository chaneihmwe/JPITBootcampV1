package com.example.jpitbootcamp.ui.batch

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.jpitbootcamp.DataBase.JPITDatabase
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.R
import kotlinx.android.synthetic.main.fragment_batch.view.*
import org.w3c.dom.Text

class BatchFragment :Fragment() {

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_batch, container, false)
       /* var recyclerViewBatch : RecyclerView = root.findViewById(R.id.batch_recycler)
        var name = root.findViewById<TextView>(R.id.batch_name)
        var batchModel = Batch()
        batchModel.batchName = name.text.toString()*/
        root.create_batch_btn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_batch_to_createBatchFragment)

        }
        (activity as AppCompatActivity).supportActionBar?.title = "Batch"


        return root
    }
}