package com.pigllet.themovieapp.presentation.detail_movie

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}