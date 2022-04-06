package com.itunes.songs.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itunes.songs.R
import com.itunes.songs.Util
import com.itunes.songs.models.model.*
import com.itunes.songs.view.adapters.SongsAdapter
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    lateinit var recycleView: RecyclerView
    var songslist = ArrayList<Songs>()
    lateinit var adapter: SongsAdapter
    lateinit var textView: TextView
    lateinit var progressbarlayout: View
    lateinit var modelView: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        castViews()
        modelView = ViewModelProviders.of(this).get(ViewModel::class.java)

        button.setOnClickListener {
            if (artistinput.text.toString().isNotEmpty()) {
                modelView.getData(artistinput.text.toString())
                progressbarlayout.visibility = View.VISIBLE
            }
        }

        val nameObserver = Observer<ArrayList<Songs>> { list ->

            songslist.clear()
            songslist.addAll(list)
            adapter.notifyDataSetChanged()
            progressbarlayout.visibility = View.INVISIBLE
        }

        modelView.getObservable().observe(this, nameObserver)



        adapter = SongsAdapter(
            this,
            songslist
        )
        recycleView.adapter = adapter







    }


    private fun castViews() {

        recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.setLayoutManager(linearLayoutManager)

        progressbarlayout = findViewById(R.id.progressbarlayout)

    }


    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }


}