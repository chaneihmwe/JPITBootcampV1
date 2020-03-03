package com.example.jpitbootcamp.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.jpitbootcamp.DAO.BatchDao
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.R
import com.example.jpitbootcamp.Repository.BatchRepository
import com.example.jpitbootcamp.ViewModel.BatchViewModel


class BatchViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    //var batchName: TextView= itemView.findViewById(R.id.batch_name)
    var batchName:TextView? = itemView.findViewById(R.id.batch_name)
    var deleteBtn: Button = itemView.findViewById(R.id.delete_batch)
    fun bind(batch:Batch){
        /*itemView.setOnClickListener{
            clickListener.OnClick(batch)
        }*/
    }

}

class BatchListAdapter(context: Context?) : RecyclerView.Adapter<BatchViewHolder>(){
    var batches = emptyList<Batch>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatchViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.batch_item,parent,false)
        return BatchViewHolder(view)
    }
    internal fun setBatchess(batches: List<Batch>){
        this.batches = batches
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = batches.size

    override fun onBindViewHolder(holder: BatchViewHolder, position: Int) {
        val batch = batches.get(position)
        holder.batchName?.text = batch.batchName
        holder.bind(batch)
        holder.deleteBtn.setOnClickListener {
            val batchId = batch.id
            Log.d("BatchId", batchId.toString())
            val batchDao: BatchDao? = null
            batchDao!!.deleteBatchById(batchId.toLong())
        }
    }
}



