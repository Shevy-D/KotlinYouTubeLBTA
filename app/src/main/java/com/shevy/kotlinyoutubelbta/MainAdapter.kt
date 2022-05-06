package com.shevy.kotlinyoutubelbta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {
    val videoTitle = listOf("First", "Second", "3rd", "MORE TITTLE")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //ho do we eve create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videoTitles = videoTitle[position]
        holder.view.findViewById<TextView>(R.id.textView_video_title).text = videoTitles

    }

    override fun getItemCount(): Int {
        return videoTitle.size
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}