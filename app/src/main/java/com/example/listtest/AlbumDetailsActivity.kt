package com.example.listtest

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        setContentView(R.layout.album_info)

        val name = intent.getStringExtra(ALBUM_NAME)
        val description = intent.getStringExtra(AlBUM_DESCRIPTION)

        val textViewName = findViewById<TextView>(R.id.textViewAlbumName)
        val textViewAlbumDetail = findViewById<TextView>(R.id.textViewAlbumDetail)

        textViewName.text = name
        textViewAlbumDetail.text = description

    }

    companion object {
        const val ALBUM_NAME = "album_name"
        const val AlBUM_DESCRIPTION = "album_description"
    }
}