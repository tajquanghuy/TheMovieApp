package com.example.basecleandaggerrx.domain.repository

import com.pigllet.themovieapp.domain.models.ResponsePopularMovie
import com.pigllet.themovieapp.domain.models.ResponseTopMovies
import com.pigllet.themovieapp.domain.models.ResultsItem
import io.reactivex.Single


interface NetworkRepositoryInterface {
    fun getListMovie(): Single<ResponsePopularMovie>

    fun getListMoviee(): Single<ResultsItem>
}