package com.example.jpitbootcamp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.R


class StudentViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    var studentName: TextView = itemView.findViewById(R.id.student_name)
    var studentImage: ImageView = itemView.findViewById(R.id.student_image)
    fun bind(student: Student, clickListener: ClickListener){
        itemView.setOnClickListener{
            clickListener.OnClick(student)
        }
    }

}

class StudentListAdapter(context: Context?, val clickListener: ClickListener) : RecyclerView.Adapter<StudentViewHolder>(){

    var students = emptyList<Student>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)
        return StudentViewHolder(view)
    }
    internal fun setStudents(students: List<Student>){
        this.students = students
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students.get(position)
        holder.studentName.text = student.studentName
        //holder.studentImage.setImageResource(student.studentImage)
        holder.bind(student, clickListener)
    }
}

interface ClickListener{
    fun OnClick(student: Student)
}

