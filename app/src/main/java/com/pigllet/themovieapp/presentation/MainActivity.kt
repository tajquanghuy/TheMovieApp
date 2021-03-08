package com.pigllet.themovieapp.presentation

import android.os.Bundle
import com.pigllet.themovieapp.R
import com.pigllet.themovieapp.domain.Movie
import com.pigllet.themovieapp.presentation.detail_movie.DetailMovieFragment
import com.pigllet.themovieapp.presentation.home_movie.HomeFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, HomeFragment()).commit()
    }

    fun showDetailMovie(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, DetailMovieFragment.newInstance(movie))
            .addToBackStack(DetailMovieFragment.javaClass.simpleName)
            .commit()
    }
}