package com.shevy.kotlinyoutubelbta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcView = findViewById<RecyclerView>(R.id.recyclerView_main)
        rcView.layoutManager = LinearLayoutManager(this)
        //rcView.adapter = MainAdapter()

        fetchJson()
    }

    private fun fetchJson() {
        println("Attempting to fetch JSON")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    val rcView = findViewById<RecyclerView>(R.id.recyclerView_main)
                    rcView.adapter = MainAdapter(homeFeed)
                }
            }

        })
    }
}