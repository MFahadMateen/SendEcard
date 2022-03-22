package com.devprotocols.sendecard.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.devprotocols.sendecard.R
import com.devprotocols.sendecard.models.SpinnerModel

class SpinnerAdapter(context: Context, private var dataSource: List<SpinnerModel>) :
    BaseAdapter() {
    @SuppressLint("ServiceCast")
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_spinner_items, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = dataSource[position].name
        vh.img.setImageResource(dataSource[position].image!!)

        return view
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private class ItemHolder(row: View?) {
        var label: TextView = row?.findViewById(R.id.textView) as TextView
        var img: ImageView = row?.findViewById(R.id.imageView) as ImageView
    }
}