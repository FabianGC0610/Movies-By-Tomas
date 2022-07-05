package com.backbase.moviesbythomas.network.service

import android.util.Log
import com.backbase.moviesbythomas.instances.RetrofitClient
import com.backbase.moviesbythomas.model.MoviesResponse
import com.backbase.moviesbythomas.network.api.MoviesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MoviesService {
    private val retrofit = RetrofitClient.getRetrofit().create(MoviesAPI::class.java)

    suspend fun getMoviesNowPlaying(api_key: String): Response<MoviesResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getNowPlaying(api_key)
            Log.d("NowPlayingMoviesList", response.body().toString())
            response
        }
    }

    suspend fun getMoviesMostPopular(api_key: String): Response<MoviesResponse> {
        return withContext(Dispatchers.IO){
            Log.e("Before Do Path Construction", "DONE")
            try{
                val response = retrofit.getMostPopularMovies(api_key)
            }catch (e: Exception){
                Log.e("During Path Construction Exception", e.stackTraceToString())
            }
            val response = retrofit.getMostPopularMovies(api_key)
            Log.e("Service Phase", "DONE")
            Log.d("MostPopularMoviesList", response.body().toString())
            response
        }
    }
}