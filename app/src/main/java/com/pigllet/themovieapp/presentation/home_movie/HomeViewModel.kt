package com.pigllet.themovieapp.presentation.home_movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basecleandaggerrx.rx.SchedulersProvider
import com.pigllet.themovieapp.domain.Movie
import com.pigllet.themovieapp.presentation.usecase.LoadMovieUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeViewModel
@Inject
constructor(
    val loadMovieUseCase: LoadMovieUseCase,
    val schedulers: SchedulersProvider
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private var _listMovie = MutableLiveData<List<Movie>>()
    val listMovie = _listMovie

    private var _listMoviee = MutableLiveData<List<Movie>>()
    val listMoviee = _listMoviee



    var isLoading = MutableLiveData<Boolean>()
    var isEmpty = false

    fun loadUserList() {
        isLoading.value = true
        loadMovieUseCase.executee(Unit)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .subscribe(
                { respone ->
                    _listMovie.value = respone?.results
                    isLoading.value = false
                    if (respone.movies.size > 0) isEmpty = false else isEmpty = true
                    var a : Int = 1
                },
                { error ->
                    isLoading.value = false
                    isEmpty = true
                }
            )
            .let {
                compositeDisposable.add(it)
            }
    }
    fun getListMovie(){

    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}