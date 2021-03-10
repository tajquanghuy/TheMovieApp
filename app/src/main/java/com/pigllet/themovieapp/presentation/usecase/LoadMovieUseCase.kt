package com.pigllet.themovieapp.presentation.usecase

import com.example.basecleandaggerrx.domain.usecase.SingleUseCase
import com.pigllet.themovieapp.data.NetworkRepositoryImlp
import com.pigllet.themovieapp.domain.models.ResponseTopMovies
import com.pigllet.themovieapp.domain.models.ResultsItem
import io.reactivex.Single
import javax.inject.Inject

class LoadMovieUseCase @Inject constructor(val networkRepository : NetworkRepositoryImlp ) : SingleUseCase<ResponseTopMovies, Unit> {
    override fun executee(params: Unit): Single<ResponseTopMovies> {
        return networkRepository.getListMoviee()
    }
}