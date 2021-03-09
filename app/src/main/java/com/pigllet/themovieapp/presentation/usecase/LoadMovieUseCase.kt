package com.pigllet.themovieapp.presentation.usecase

import com.example.basecleandaggerrx.domain.usecase.SingleUseCase
import com.pigllet.themovieapp.data.NetworkRepositoryImlp
import com.pigllet.themovieapp.domain.models.ResponsePopularMovie
import com.pigllet.themovieapp.domain.models.ResponseTopMovies
import com.pigllet.themovieapp.domain.models.ResultsItem
import io.reactivex.Single
import javax.inject.Inject

class LoadMovieUseCase @Inject constructor(val networkRepository : NetworkRepositoryImlp ) : SingleUseCase<ResultsItem, Unit> {
//    override fun execute(params: Unit): Single<ResponsePopularMovie> {
//        return networkRepository.getListMovie()
//    }

    override fun executee(params: Unit): Single<ResultsItem> {
        return networkRepository.getListMoviee()
    }
}