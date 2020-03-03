package com.example.jpitbootcamp.Adapter

import com.example.jpitbootcamp.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jpitbootcamp.Enity.Batch
import kotlinx.android.synthetic.main.batch_item.view.*


class BatchListClickAdapter (var batchList:List<Batch> = ArrayList()) : RecyclerView.Adapter<BatchListClickAdapter.BatchViewHolder>() {

    var mClickListener: ClickListener? = null
    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatchViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.batch_item,parent,false)
        return  BatchViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("Category List:", batchList.size.toString())
        return batchList.size
    }

    override fun onBindViewHolder(holder: BatchViewHolder, position: Int) {
        holder.bindCategory(batchList.get(position))
    }

    fun updateList(batch: List<Batch>){
        this.batchList = batch
        notifyDataSetChanged()
    }

    inner class BatchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private var view:View = itemView
        private lateinit var batchesResult:Batch
        init {
            itemView.setOnClickListener(this)
        }
        fun bindCategory(batches: Batch){
            this.batchesResult = batches
            view.batch_name.text = batchesResult.batchName
        }
        override fun onClick(v: View?) {
            mClickListener?.onClick(batchesResult)
        }
    }
    interface ClickListener{
        fun onClick(batches: Batch)
    }
}