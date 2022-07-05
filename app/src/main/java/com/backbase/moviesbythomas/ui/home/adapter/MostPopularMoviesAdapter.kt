package com.backbase.moviesbythomas.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.backbase.moviesbythomas.R
import com.backbase.moviesbythomas.model.Results
import com.backbase.moviesbythomas.utils.loadImage
import com.backbase.moviesbythomas.utils.releaseDateFormat

class MostPopularMoviesAdapter (private val movieList: List<Results>) :
    RecyclerView.Adapter<MostPopularMoviesAdapter.MostPopularMoviesHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ):  MostPopularMoviesHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_most_popular_movie, parent, false)
            return MostPopularMoviesHolder(view)
        }

        override fun onBindViewHolder(holder: MostPopularMoviesHolder, position: Int) {
            val movie = movieList[position]
            with(holder) {
                movie.poster_path?.let { ivMostPopularMoviePoster.loadImage(it, Pair(100,200)) }
                tvMostPopularMovieTitle.text = movie.title
                tvMostPopularMovieDescription.text = movie.release_date?.let { releaseDateFormat(it) }
            }
        }

        override fun getItemCount(): Int = movieList.size

        class MostPopularMoviesHolder(view: View) : RecyclerView.ViewHolder(view) {
            val ivMostPopularMoviePoster: ImageView = view.findViewById(R.id.mostPopularMovieImagePoster)
            val tvMostPopularMovieTitle: TextView = view.findViewById(R.id.mostPopularMovieTextTitle)
            val tvMostPopularMovieDescription: TextView = view.findViewById(R.id.mostPopularMovieTextDescription)
        }

}