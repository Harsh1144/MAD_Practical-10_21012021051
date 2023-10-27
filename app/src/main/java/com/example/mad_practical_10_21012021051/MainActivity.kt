package com.example.mad_practical_10_21012021051

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var personListView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personListView = findViewById(R.id.listview1)

        val btn:FloatingActionButton = findViewById(R.id.floating_button_1)
        btn.setOnClickListener{
            setPersondata_to_Listview()
        }

    }
    fun setPersondata_to_Listview(){
//        personListView.adapter=PersonAdapter(this, arrayListOf(
//            Person("1","Durgesh","9332493494","durgesh@gnu.ac.in","uma hostel",24.67,40.34),
//            Person("2","Yash","3427935923","yash@gnu.ac.in","h hostel",45.90,43.89),
//            Person("3","Jainish","9873456732","jainish@gnu.ac.in","h hostel",34.34,23.56),
//            Person("4","Bharat","4325692845","bharat@gnu.ac.in","uma hostel",23.56,24.67),
//            Person("5","Harsh","4325692845","harsh@gnu.ac.in","g hostel",23.56,24.67)
//        ))
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = HttpRequest().makeServiceCall(
                    "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                    "rbn0rerl1k0d3mcwgw7dva2xuwk780z1hxvyvrb1")
                withContext(Dispatchers.Main) {
                    try {
                        if(data != null)
                            runOnUiThread{getPersonDetailsFromJson(data)}
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            var listView1 : ListView = findViewById(R.id.listview1)
            listView1.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }
}