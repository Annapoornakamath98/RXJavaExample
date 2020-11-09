package com.yml.rxjavaexample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yml.rxjavaexample.R

class AdapterClass(private val uList: List<Any>) : RecyclerView.Adapter<AdapterClass.ResponseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResponseViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ResponseViewHolder(itemView)
    }

    class ResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val responseItemView: TextView = itemView.findViewById(R.id.word)

    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        holder.responseItemView.text = uList[position].toString()
    }

    override fun getItemCount(): Int {
        return uList.size
    }
}