package com.itunes.songs.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itunes.songs.R
import com.itunes.songs.models.model.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.elementview.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class SongsAdapter(
    val context: Context,
    val songs: ArrayList<Songs>

) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.elementview, parent, false)
        )

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ViewHolder).bind(songs[position], context)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(song: Songs?, context: Context) {
            var song = song

            song?.let {
                if (song.artistName!= null)
                itemView.artist.text = song.artistName
                if (song.artworkUrl100!= null)
                Glide.with(context).load(song.artworkUrl100).placeholder(R.mipmap.user_icon_small)
                    .into(itemView.albumIImage)
                if (song.trackCensoredName!= null)
                itemView.trackname.text = song.trackName
                if (song.primaryGenreName!= null)
                itemView.primarygenre.text = song.primaryGenreName
                if (song.trackPrice!= null)
                itemView.TrackPrice.text = "$" + song.trackPrice.toString()
                if (song.releaseDate!= null)
                itemView.releaseDate.text = "Release date " + LocalDate.parse(
                    song.releaseDate,
                    DateTimeFormatter.ISO_DATE_TIME
                )
            }

        }

    }

}

