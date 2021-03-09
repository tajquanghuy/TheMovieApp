package com.pigllet.themovieapp.data


import com.example.basecleandaggerrx.domain.repository.NetworkRepositoryInterface
import com.pigllet.themovieapp.domain.models.ResponsePopularMovie
import com.pigllet.themovieapp.service.MovieService
import com.pigllet.themovieapp.utils.API_KEY
import com.pigllet.themovieapp.utils.APP_LANGUAGE
import io.reactivex.Single
import javax.inject.Inject

class NetworkRepositoryImlp @Inject constructor(val movieService: MovieService) :
    NetworkRepositoryInterface {
    override fun getListMovie(): Single<ResponsePopularMovie> {
        return movieService.getPopularMovie(API_KEY, APP_LANGUAGE,1)
    }

}