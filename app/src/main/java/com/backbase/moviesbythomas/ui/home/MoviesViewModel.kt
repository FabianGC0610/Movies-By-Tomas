package com.backbase.moviesbythomas.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backbase.moviesbythomas.model.MoviesError
import com.backbase.moviesbythomas.model.MoviesResponse
import com.backbase.moviesbythomas.usecase.MostPopularMoviesUseCase
import com.backbase.moviesbythomas.usecase.NowPlayingMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val nowPlayingMoviesUseCase: NowPlayingMoviesUseCase,
    private val mostPopularMoviesUseCase: MostPopularMoviesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val nowPlayingMovies = MutableLiveData<MoviesResponse>()
    val nowPlayingMoviesError = MutableLiveData<MoviesError>()

    val mostPopularMovies = MutableLiveData<MoviesResponse>()
    val mostPopularMoviesError = MutableLiveData<MoviesError>()

    fun fetchNowPlayingMovies(api_key: String) {
        viewModelScope.launch(dispatcher) {
            try {
                val response = nowPlayingMoviesUseCase.invoke(api_key)
                when {
                    response.isSuccessful -> {
                        nowPlayingMovies.postValue(response.body())
                    }
                    response.code() == 401 -> {
                        nowPlayingMoviesError.postValue(MoviesError("User Unauthorized", 401))
                    }
                    response.code() == 404 -> {
                        nowPlayingMoviesError.postValue(MoviesError("Request Not Found", 404))
                    }
                    else -> {
                        nowPlayingMoviesError.postValue(MoviesError("An Error Happen", 400))
                    }
                }
            }catch (e: Exception){
                nowPlayingMoviesError.postValue(MoviesError("An Error Happen Exception", 400))
            }
        }
    }

    fun fetchMostPopularMovies(api_key: String){
        viewModelScope.launch(dispatcher) {
            try {
                val response = mostPopularMoviesUseCase.invoke(api_key)
                when {
                    response.isSuccessful -> {
                        mostPopularMovies.postValue(response.body())
                    }
                    response.code() == 401 -> {
                        mostPopularMoviesError.postValue(MoviesError("User Unauthorized", 401))
                    }
                    response.code() == 404 -> {
                        mostPopularMoviesError.postValue(MoviesError("Request Not Found", 404))
                    }
                    else -> {
                        mostPopularMoviesError.postValue(MoviesError("An Error Happen", 400))
                    }
                }
            }catch (e: Exception){
                mostPopularMoviesError.postValue(MoviesError("An Error Happen Exception", 400))
            }
        }
    }

}