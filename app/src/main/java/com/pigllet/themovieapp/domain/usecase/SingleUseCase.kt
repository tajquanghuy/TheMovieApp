package com.example.basecleandaggerrx.domain.usecase

import io.reactivex.Single


interface SingleUseCase<T, Params> {
    fun execute(params : Params) : Single<T>
}