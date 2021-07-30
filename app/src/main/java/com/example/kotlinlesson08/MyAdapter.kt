package com.example.kotlinlesson08

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinlesson08.model.ExchangeRate

class MyAdapter(val items: List<ItemList>, val gson: List<ExchangeRate>, context: Context) :
    BaseAdapter() {

    override fun getCount() = items.size

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = LayoutInflater.from(parent?.context)
        val result = convertView ?: inflater
            .inflate(R.layout.list_item, parent, false)

        val textView = result.findViewById<TextView>(R.id.text_id)

        getItem(position).apply {
            textView.text = "${gson[position].currency}: ${gson[position].saleRateNB}"
        }

        return result
    }

}