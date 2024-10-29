package com.example.exam3

// StudentAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    private var students = listOf<Student>()
    private var filteredStudents = listOf<Student>()

    init {
        filteredStudents = students
    }

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.textViewName)
        val idTextView: TextView = view.findViewById(R.id.textViewId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = filteredStudents[position]
        holder.nameTextView.text = student.name
        holder.idTextView.text = student.id
    }

    override fun getItemCount() = filteredStudents.size

    fun setData(newStudents: List<Student>) {
        students = newStudents
        filteredStudents = students
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        filteredStudents = if (query.length > 2) {
            students.filter { student ->
                student.name.contains(query, ignoreCase = true) ||
                        student.id.contains(query, ignoreCase = true)
            }
        } else {
            students
        }
        notifyDataSetChanged()
    }
}