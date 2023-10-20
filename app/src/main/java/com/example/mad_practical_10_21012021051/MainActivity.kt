package com.example.mad_practical_10_21012021051

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var personListVIew:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        personListVIew=findViewById(R.id.Listview1)

        val btn:FloatingActionButton = findViewById(R.id.btn_float)
        btn.setOnClickListener{
            setpersondatatolistview()

        }
    }
    fun setpersondatatolistview(){
        personListVIew.adapter=PersonAdapter(this, arrayListOf(
            Person("1","harsh","9332493494","harsh@gnu.ac.in","h hostel",24.67,40.34),
            Person("2","yash","3427935923","yash@gnu.ac.in","h hostel",45.90,43.89),
            Person("3","akky","9873456732","akky@gnu.ac.in","h hostel",34.34,23.56),
            Person("4","vikas","4325692845","vikas@gnu.ac.in","h hostel",23.56,24.67),
            Person("5","sajid","4525452345","sajid@gnu.ac.in","h hostel",23.45,25.67)
        ))
    }
}