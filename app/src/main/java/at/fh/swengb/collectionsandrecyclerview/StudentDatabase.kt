package at.fh.swengb.collectionsandrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_student_database.*

class StudentDatabase : AppCompatActivity() {

    private val students = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_database)
        Log.i("MyActivity", "onCreate")
        recycler_view.adapter = studentAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    fun addStudent(view: View) {
        val name = student_name.text.toString()
        val currentSemester = current_semester.text.toString().toIntOrNull() ?: 0

        val student = Student(name, currentSemester)
        students.add(student)
    }
}