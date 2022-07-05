package com.backbase.moviesbythomas.repository

import android.util.Log
import com.backbase.moviesbythomas.model.MoviesResponse
import com.backbase.moviesbythomas.network.service.MoviesService
import retrofit2.Response


class MoviesRepository {
    private val api = MoviesService()

    suspend fun getMoviesNowPlaying(api_key: String): Response<MoviesResponse> {
        return api.getMoviesNowPlaying(api_key)
    }

    suspend fun getMoviesMostPopular(api_key: String): Response<MoviesResponse>{
        Log.e("Repo Phase", "DONE")
        return api.getMoviesMostPopular(api_key)
    }
}