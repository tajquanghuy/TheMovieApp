package com.pigllet.themovieapp.service

import com.pigllet.themovieapp.domain.models.ResponsePopularMovie
import com.pigllet.themovieapp.domain.models.ResponseTopMovies
import com.pigllet.themovieapp.domain.models.ResultsItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageIndex: Int
    ): Single<ResultsItem>

    @GET("movie/popular")
    fun getPopularMoviee(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageIndex: Int
    ): Single<ResponseTopMovies>
}