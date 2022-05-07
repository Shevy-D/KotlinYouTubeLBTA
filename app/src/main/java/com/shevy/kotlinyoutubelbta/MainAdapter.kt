package com.shevy.kotlinyoutubelbta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitle = listOf("First", "Second", "3rd", "MORE TITTLE")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //ho do we eve create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val videoTitles = videoTitle[position]
        val video = homeFeed.videos[position]
        holder.view.findViewById<TextView>(R.id.textView_video_title).text = video.name

    }

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}