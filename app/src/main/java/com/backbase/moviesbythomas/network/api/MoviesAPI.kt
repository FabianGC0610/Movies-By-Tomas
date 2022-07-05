package com.backbase.moviesbythomas.network.api

import com.backbase.moviesbythomas.model.MovieDetail
import com.backbase.moviesbythomas.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Aqui Thomas usa Single en el modelo de la respuesta, preguntar que es...
interface MoviesAPI {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("language") language: String = "en-US",

    ): Response<MoviesResponse>

    @GET("movie/popular")
    suspend fun getMostPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<MoviesResponse>


    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int = 0,
        @Query("append_to_response") append: String = "videos"
    ): Response<MovieDetail>
}