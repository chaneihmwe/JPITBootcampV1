package com.example.jpitbootcamp.ui.student

import com.example.jpitbootcamp.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.ViewModel.StudentDetailViewModel
import kotlinx.android.synthetic.main.fragment_student.*
import kotlinx.android.synthetic.main.student_detail.*

/**
 * A simple [Fragment] subclass.
 */
class StudentDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        //val studentName = this.arguments!!.getString("Name").toString()
        //val studentImage = this.arguments!!.getInt("Image")
       // Log.d("studentDetails",studentName+studentImage)
        //detail_student_image.setImageResource(studentImage)
        //detail_student_name.text = studentName

        val studentDetailViewModel:StudentDetailViewModel = ViewModelProviders.of(activity!!).get(StudentDetailViewModel::class.java)
        Log.d("Menu Detail", studentDetailViewModel.getSelectedStudent().toString())
        studentDetailViewModel.getSelectedStudent().observe(
            viewLifecycleOwner, Observer<Student>{ student ->
                (activity as AppCompatActivity).supportActionBar?.title = student.studentName + "'s Detail"
                Log.d("Detail Name", "Name")
                detail_student_image.setImageResource(student.studentImage)
                detail_student_name.text = student.studentName
                detail_student_batch.text = student.batchId
            }
        )
    }
}
