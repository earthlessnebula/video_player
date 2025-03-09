package com.example.video_player

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find VideoView by its ID
        val videoView = findViewById<VideoView>(R.id.testView)

        // Add debug log to verify the VideoView object
        Log.d("MainActivity", "VideoView: $videoView")

        // Create a MediaController
        val mediaController = MediaController(this)

        // Attach the media controller to the VideoView
        mediaController.setAnchorView(videoView)

        // Specify the location of the video file (ensure it's in res/raw)
        val uri: Uri = Uri.parse("android.resource://" + packageName + "/raw/test")

        // Add debug log to verify the URI of the video
        Log.d("MainActivity", "Video URI: $uri")

        // Set the URI for the VideoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()

        // Start the video
        videoView.start()

        // Add debug log to confirm video playback has started
        Log.d("MainActivity", "Video playback started")
    }
}