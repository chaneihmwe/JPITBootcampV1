package com.example.jpitbootcamp.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.jpitbootcamp.R
import kotlinx.android.synthetic.main.fragment_student.view.*

class StudentFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_student,container,false)
        root.create_student_btn.setOnClickListener { view: View ->
            root.findNavController().navigate(R.id.action_nav_student_to_createStudentFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Students"
        return root
    }
}