package com.example.jpitbootcamp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.R

class BatchListAdatper(val batches : List<Batch>) :RecyclerView.Adapter<BatchListAdatper.BatchViewHolder>(){
    inner class BatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val batchItemView : TextView = itemView.findViewById(R.id.batch_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.batch_item,parent,false)
        return BatchViewHolder(itemView)
    }

    override fun getItemCount() = batches.size

    override fun onBindViewHolder(holder: BatchViewHolder, position: Int) {
        var current = batches[position]
        holder.batchItemView.text = current.batchName
    }

}