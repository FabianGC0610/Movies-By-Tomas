package com.backbase.moviesbythomas.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.backbase.moviesbythomas.R
import com.backbase.moviesbythomas.model.Results
import com.backbase.moviesbythomas.utils.loadImage

class NowPlayingMoviesAdapter(private val movieList: List<Results>) :
    RecyclerView.Adapter<NowPlayingMoviesAdapter.NowPlayingMoviesHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):  NowPlayingMoviesHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_now_playing_movie, parent, false)
        return NowPlayingMoviesHolder(view)
    }

    override fun onBindViewHolder(holder: NowPlayingMoviesHolder, position: Int) {
        val movie = movieList[position]
        with(holder) {
            movie.poster_path?.let { ivNowPlayinMoviePoster.loadImage(it, Pair(100,200)) }
        }
    }

    override fun getItemCount(): Int = movieList.size

    class NowPlayingMoviesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivNowPlayinMoviePoster: ImageView = view.findViewById(R.id.nowPlayingMovieImagePoster)
    }

}