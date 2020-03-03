package com.example.jpitbootcamp.ui.student

import com.example.jpitbootcamp.R
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.ViewModel.BatchViewModel
import com.example.jpitbootcamp.ViewModel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_create_student.view.*

/**
 * A simple [Fragment] subclass.
 */
class CreateStudentFragment : Fragment() {
    private var batchArray: List<Batch> = ArrayList()

    lateinit var studentViewModel: StudentViewModel

    lateinit var batchViewModel: BatchViewModel

    lateinit var batchSpinner: Spinner

    lateinit var selectedBatch: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_create_student, container, false)
        batchSpinner = root.findViewById(R.id.batch_spinner)
        batchViewModel = ViewModelProviders.of(this).get(BatchViewModel::class.java)


        batchViewModel.allBatches.observe(viewLifecycleOwner,
            Observer { batches ->
                batchArray = batches
                var data: MutableList<String> = ArrayList()
                Log.d("BatchArray", batchArray.toString())
                batchArray.forEach{
                    data.add(0, it.batchName)
                }
                batchSpinner.adapter = context?.let { ArrayAdapter<String>(it,
                    R.layout.support_simple_spinner_dropdown_item, data)}
            })

        (activity as AppCompatActivity).supportActionBar?.title = "Create Student"
        root.add_student_btn.setOnClickListener{view: View ->
            var studentName: String = root.findViewById<EditText>(R.id.edit_student_name).text.toString()
            Log.d("Student Name",studentName)

            selectedBatch = batchSpinner.selectedItem.toString()

            Log.d("SelectedBatch", selectedBatch)

            studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
            studentViewModel.insert(Student(0,selectedBatch,studentName,R.drawable.avatar))
            root.findNavController().navigate(R.id.action_createStudentFragment_to_nav_student)
        }
        return root
    }


}
