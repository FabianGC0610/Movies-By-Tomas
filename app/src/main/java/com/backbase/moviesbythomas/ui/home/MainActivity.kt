package com.backbase.moviesbythomas.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.backbase.moviesbythomas.databinding.ActivityMainBinding
import com.backbase.moviesbythomas.model.MoviesError
import com.backbase.moviesbythomas.model.MoviesResponse
import com.backbase.moviesbythomas.ui.home.adapter.MoviesRecyclerViewInfo
import com.backbase.moviesbythomas.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val moviesViewModel by viewModel<MoviesViewModel>()

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        observers()

    }

    private fun observers(){
        //Now Playing Movies
        moviesViewModel.nowPlayingMoviesError.observe(this,::nowPlayingMoviesError)
        moviesViewModel.nowPlayingMovies.observe(this,::showNowPlayingMovieList)
        moviesViewModel.fetchNowPlayingMovies(Constants.API_KEY)

        //Most Popular Movies
        moviesViewModel.mostPopularMoviesError.observe(this,::mostPopularMoviesError)
        moviesViewModel.mostPopularMovies.observe(this,::showMostPopularMovieList)
        moviesViewModel.fetchMostPopularMovies(Constants.API_KEY)
    }

    private fun showNowPlayingMovieList(moviesList: MoviesResponse){
        binding?.apply {
            MoviesRecyclerViewInfo.initNowPlayingMovieList(nowPlayingMoviesRecyclerView,moviesList.results,this@MainActivity)
        }
    }

    private fun nowPlayingMoviesError(error: MoviesError){
        error.status_message?.let { Log.e("Now Playing Error Response", it) }
    }

    private fun showMostPopularMovieList(moviesList: MoviesResponse){
        binding?.apply {
            MoviesRecyclerViewInfo.initMostPopularMovieList(mostPopularMoviesRecyclerView,moviesList.results,this@MainActivity)
        }
    }

    private fun mostPopularMoviesError(error: MoviesError){
        error.status_message?.let { Log.e("Most Popular Error Response", it) }
    }

}