package com.example.kotlinlesson08

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlesson08.model.PrivatApi
import com.google.gson.GsonBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder().create()
        val data = gson.fromJson<PrivatApi>(rates, PrivatApi::class.java)
        val gsonList = data.exchangeRate
        var listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = MyAdapter(myListItems, gsonList, this)

    }


}


