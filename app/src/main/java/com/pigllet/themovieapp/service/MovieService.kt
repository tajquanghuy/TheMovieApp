package com.pigllet.themovieapp.service

import com.pigllet.themovieapp.domain.models.ResponseTopMovies
import com.pigllet.themovieapp.utils.API_KEY
import com.pigllet.themovieapp.utils.APP_LANGUAGE
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular?api_key=5a65a379b19af29e390fc4ec1c26b549&language=en-US&page=1")
    fun getPopularMovie(
        @Query("api_key") apiKey: String = API_KEY
        , @Query("language") language: String = APP_LANGUAGE
        , @Query("page") pageIndex: Int
    ): Observable<ResponseTopMovies>
}