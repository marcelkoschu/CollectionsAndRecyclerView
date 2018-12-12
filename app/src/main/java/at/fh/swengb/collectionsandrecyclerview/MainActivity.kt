package at.fh.swengb.collectionsandrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // doWork()
        mutableWork()

    }

    fun doWork() {
        val myStudents = listOf<Student>(
            Student("Peter", 1),
            Student("Rob", 4), Student
                ("Nadja", 3), Student
                ("Kevin", 5), Student
                ("Marcel", 6)
        )


        //Student at Index 2
        Log.i("InfoStudent", myStudents[2].name)

        var mlist = mutableListOf<Student>(
            Student("Peter", 1),
            Student("Rob", 4), Student
                ("Nadja", 3), Student
                ("Kevin", 5), Student
                ("Marcel", 6)
        )

        mlist.set(3, Student("Robert", 2))
        Log.i("InfoStudent", mlist[3].name)

        mlist.add(Student("Franz", 2))

        mlist.forEach { Log.i("InfoStudentAll", it.name) }


        var set = setOf<Student>(
            Student("Peter", 1),
            Student("Marcel", 6), Student
                ("Nadja", 3), Student
                ("Kevin", 5), Student
                ("Marcel", 6)
        )

        set.forEach {
            Log.i(
                "InfoStudentSet",
                it.name
            )
        } //Student dont implement equals / hashCode !!! -> Kein Duplikatsprüfung möglich


    }

    fun mutableWork() {
        //Mutable Set
        val myStudents = mutableSetOf<Student>(
            Student("Peter", 1),
            Student("Rob", 4), Student
                ("Nadja", 3), Student
                ("Kevin", 5), Student
                ("Marcel", 6)
        )

        myStudents.add(Student("Rob", 4))
        myStudents.add(Student("Klaus", 1))

        myStudents.forEach { Log.i("InfoStudentMSet", it.name + " " + it.currentSemester.toString()) }
        myStudents.forEach {
            if (it.name == "Rob") {
                Log.i("InfoStudentMSetRob", it.name + " " + it.currentSemester.toString())
            }
        }
       // myStudents.forEach { // Nur ein Test ob ich das andere Verfahren auch kann
         //   if (it.name == "Rob") {
           //     Log.i("InfoStudentMSetRob", "${it.name} ${it.currentSemester}")
            //}


            //Maps
            val ima18List = listOf(Student("Tyrion", 1), Student("Jon", 1))
            val ima17List = mutableListOf(Student("Sansa", 3), Student("Arya", 3), Student("Bran", 3))
            val studentMap = mapOf<String, List<Student>>("IMA18" to ima18List, "IMA17" to ima17List)

            for ((key, value) in studentMap) { //Pattern Matching <3
                //Value = List of Student
                for (s: Student in value)
                    Log.i("InfoStudentMap", key + " " + s.name + " " + s.currentSemester)
            }

            ima17List.add(Student("Anton", 9))

            for ((key, value) in studentMap) { //Pattern Matching <3
                //Value = List of Student
                for (s: Student in value)
                    Log.i(
                        "InfoStudentMap2",
                        key + " " + s.name + " " + s.currentSemester
                    ) //Die Map selbst ist immutable, die mutableList in ihr jedoch nicht
            }

            //Das hier geht deshalb ja nicht
            //studentMap.add ?

            //Mutable Map

            val myMutableMap = studentMap.toMutableMap()
            val ima16List = listOf<Student>(Student("Otto", 20), Student("Rolf", 22))

            myMutableMap.put("IMA16", ima16List)

            for ((key, value) in myMutableMap) { //Pattern Matching <3
                //Value = List of Student
                for (s: Student in value)
                    Log.i(
                        "InfoStudentMap3",
                        key + " " + s.name + " " + s.currentSemester
                    ) //Die Map selbst ist immutable, die mutableList in ihr jedoch nicht
            }

        }
    }
}