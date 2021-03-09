package com.pigllet.themovieapp.presentation.usecase

import com.example.basecleandaggerrx.domain.usecase.SingleUseCase
import com.pigllet.themovieapp.data.NetworkRepositoryImlp
import com.pigllet.themovieapp.domain.models.ResponsePopularMovie
import io.reactivex.Single
import javax.inject.Inject

class LoadMovieUseCase @Inject constructor(val networkRepository : NetworkRepositoryImlp ) : SingleUseCase<ResponsePopularMovie, Unit> {
    override fun execute(params: Unit): Single<ResponsePopularMovie> {
        return networkRepository.getListMovie()
    }

}