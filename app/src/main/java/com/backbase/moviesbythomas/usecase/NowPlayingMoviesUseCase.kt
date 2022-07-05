package com.backbase.moviesbythomas.usecase

import com.backbase.moviesbythomas.model.MoviesResponse
import com.backbase.moviesbythomas.repository.MoviesRepository
import retrofit2.Response

class NowPlayingMoviesUseCase {
    private val repository = MoviesRepository()

    suspend operator fun invoke(api_key: String): Response<MoviesResponse> = repository.getMoviesNowPlaying(api_key)
}