package com.example.listtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var albums: List<albumDetail> = arrayListOf(

        albumDetail("Rain", "Rain in the sea"),
        albumDetail("Sun", "Rain in the sea"),
        albumDetail("Ice", "Rain in the sea")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewAlbuns = findViewById<ListView>(R.id.listViewAlbuns)
        val albunsAdapter = albunsAdapter()
        listViewAlbuns.adapter = albunsAdapter

    }

    inner class albunsAdapter(): BaseAdapter() {
        override fun getCount(): Int {
            return albums.size
        }

        override fun getItem(position: Int): Any {
            return albums[position]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.row_content, viewGroup, false)
            val textViewName = rootView.findViewById<TextView>(R.id.textViewAlbumName)
            val textViewDescription = rootView.findViewById<TextView>(R.id.textViewAlbumDetail)

            textViewName.text = albums[position].name
            textViewDescription.text = albums[position].description

            rootView.setOnClickListener{
                val intent = Intent(this@MainActivity, AlbumDetailsActivity::class.java)
                intent.putExtra(AlbumDetailsActivity.ALBUM_NAME, albums[position].name)
                intent.putExtra(AlbumDetailsActivity.AlBUM_DESCRIPTION, albums[position].description)
                startActivity(intent)
            }
            return rootView
        }

    }
}