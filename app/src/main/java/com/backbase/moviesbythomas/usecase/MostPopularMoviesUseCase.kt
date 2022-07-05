package com.backbase.moviesbythomas.usecase

import android.util.Log
import com.backbase.moviesbythomas.model.MoviesResponse
import com.backbase.moviesbythomas.repository.MoviesRepository
import retrofit2.Response

class MostPopularMoviesUseCase {
    private val repository = MoviesRepository()

    suspend operator fun invoke(api_key: String): Response<MoviesResponse>{
        Log.e("UseCase Phase", "DONE")
        return repository.getMoviesMostPopular(api_key)
    }
}