package com.example.UTAMU.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.UTAMU.Posts.MainActivity
import com.example.UTAMU.R

class CategoryChoices : AppCompatActivity() {
    //Hooking views...
    var sst: CheckBox? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_choices)
        sst = findViewById<View>(R.id.categoriesSubjectSst) as CheckBox
        val setupprofile =
            findViewById<View>(R.id.registerCategories) as Button
        val levelOfStudy =
            findViewById<View>(R.id.levelOfStudy) as RadioGroup
        val profession =
            findViewById<View>(R.id.userprofesion) as AutoCompleteTextView
        val context = applicationContext
        val profs = arrayOf("Student", "School-Teacher")
        val arrayAdapter: ArrayAdapter<String>
        arrayAdapter =
            ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, profs)
        profession.setAdapter(arrayAdapter)
        profession.threshold = 1

        //Actions are below...
        levelOfStudy.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.primaryLevel -> Toast.makeText(
                    this@CategoryChoices,
                    "here youre " + getString(R.string.PrimaryLevel),
                    Toast.LENGTH_SHORT
                ).show()
                R.id.secondaryLevel -> Toast.makeText(
                    this@CategoryChoices,
                    "hey ya " + getString(R.string.SecondaryLevel),
                    Toast.LENGTH_SHORT
                ).show()
                R.id.TutorLevel -> Toast.makeText(
                    this@CategoryChoices,
                    "ok hre we go " + getString(R.string.TutorLevel),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        sst!!.setOnClickListener {
            Toast.makeText(
                context,
                "hey " + sst!!.isChecked,
                Toast.LENGTH_SHORT
            ).show()
        }
        setupprofile.setOnClickListener {
            fromCheckboxes()
            startActivity(
                Intent(
                    context,
                    MainActivity::class.java
                )
            )
        }
    }

    private fun fromCheckboxes() {
        if (sst!!.isChecked) {
//            val sqLiteDatabaseClass =
//                SqLiteDatabaseClass(applicationContext)
//            sqLiteDatabaseClass.insertSubject("Social Studies")
        }
    }
}