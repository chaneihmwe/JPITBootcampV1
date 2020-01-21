package com.example.jpitbootcamp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_create_student.view.*

/**
 * A simple [Fragment] subclass.
 */
class CreateStudentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_create_student, container, false)
        val spinner: Spinner = root.findViewById(R.id.batch_spinner)
        /*spinner.adapter = ArrayAdapter(
            this.activity,
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.batch_array)
        )*/
        (activity as AppCompatActivity).supportActionBar?.title = "Create Student"
        root.add_student_btn.setOnClickListener{view: View ->
            var studentName: String = root.findViewById<EditText>(R.id.edit_student_name).text.toString()
            Log.d("Student Name",studentName)
            root.findNavController().navigate(R.id.action_createStudentFragment_to_nav_student)
        }
        return root
    }


}
