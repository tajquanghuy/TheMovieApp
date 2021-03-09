package com.example.basecleandaggerrx.domain.repository

import com.pigllet.themovieapp.domain.models.ResponsePopularMovie
import io.reactivex.Single


interface NetworkRepositoryInterface {
    fun getListMovie(): Single<ResponsePopularMovie>
}