package com.backbase.moviesbythomas.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.backbase.moviesbythomas.R
import com.backbase.moviesbythomas.model.Results

object MoviesRecyclerViewInfo {

    fun initNowPlayingMovieList(moviesRecyclerView: RecyclerView, movieList: List<Results>, context: Context){

        val adapterMovies = NowPlayingMoviesAdapter(movieList)
        moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterMovies
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun initMostPopularMovieList(moviesRecyclerView: RecyclerView, movieList: List<Results>, context: Context){

        val adapterMovies = MostPopularMoviesAdapter(movieList)
        moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMovies
            val itemDecoration = DividerItemDecoration(this.context,DividerItemDecoration.VERTICAL)
            context.getDrawable(R.drawable.most_popular_movies_divider)
                ?.let { itemDecoration.setDrawable(it) }
            addItemDecoration(itemDecoration)
        }
    }
}