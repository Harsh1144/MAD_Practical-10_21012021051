package com.example.mad_practical_10_21012021051

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PersonAdapter(context:Context,val array:ArrayList<Person>):ArrayAdapter<Person>(context,0,array){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.person_icon,parent,false)
        val persondata=array.get(position)
        view.findViewById<TextView>(R.id.textView2).text=persondata.name
        view.findViewById<TextView>(R.id.textView3).text=persondata.phoneNO
        view.findViewById<TextView>(R.id.textView4).text=persondata.emailId
        view.findViewById<TextView>(R.id.textView5).text=persondata.address
        return view
    }
}