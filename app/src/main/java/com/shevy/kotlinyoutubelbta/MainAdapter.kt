package com.shevy.kotlinyoutubelbta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {

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
        holder.view.findViewById<TextView>(R.id.textView_channel_name).text =
            video.channel.name + " • " + "20K Views\n4 days ago"

        val thumbnailImageView = holder.view.findViewById<ImageView>(R.id.imageView_video_thumbnail)
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView =
            holder.view.findViewById<CircleImageView>(R.id.imageView_channel_profile)
        Picasso.get().load(video.channel.profileimageUrl).into(channelProfileImageView)
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
}