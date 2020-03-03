package com.example.jpitbootcamp.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jpitbootcamp.Adapter.ClickListener
import com.example.jpitbootcamp.Adapter.StudentListAdapter
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.R
import com.example.jpitbootcamp.ViewModel.StudentDetailViewModel
import com.example.jpitbootcamp.ViewModel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_student.view.*


class StudentFragment : Fragment(), ClickListener{
    private lateinit var studentViewModel: StudentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_student,container,false)

        (activity as AppCompatActivity).supportActionBar?.title = "Students"

        val adapter = StudentListAdapter(context, this)
        val recyclerView = root.findViewById<RecyclerView>(R.id.student_recyclerview).apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)

        studentViewModel.allStudents.observe(this,
            Observer { students ->
                students?.let { adapter.setStudents(it) }
            })

        root.create_student_btn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_nav_student_to_createStudentFragment)
        }

        return root
    }

    override fun OnClick(student: Student) {
        /*var bundle = Bundle()
        bundle.putString("Name", student.studentName)
        //bundle.putInt("Image", student.studentImage)
        val detailFragment = StudentDetailFragment()
        detailFragment.arguments = bundle
        //fragmentManager?.beginTransaction()?.replace(R.id.student_container, detailFragment)?.commit()*/

        val studentDetailViewModel: StudentDetailViewModel =
            ViewModelProviders.of(activity!!).get(StudentDetailViewModel::class.java)
        studentDetailViewModel.selectedStudent(student)
        view!!.findNavController().navigate(R.id.action_nav_student_to_studentDetailFragment)

    }

}