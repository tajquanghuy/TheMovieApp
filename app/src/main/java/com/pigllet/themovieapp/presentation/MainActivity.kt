package com.pigllet.themovieapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pigllet.themovieapp.R
import com.pigllet.themovieapp.domain.models.ResultsItem
import com.pigllet.themovieapp.presentation.detail_movie.DetailMovieFragment
import com.pigllet.themovieapp.presentation.home_movie.HomeFragment
import com.pigllet.themovieapp.utils.KEY_MOVIE_DETAIL
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, HomeFragment()).commit()
    }

    fun showDetailMovie(movie: ResultsItem) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, DetailMovieFragment.newInstance(movie))
            .addToBackStack(DetailMovieFragment.javaClass.simpleName)
            .commit()
        val bundle: Bundle? = Bundle()
        bundle?.putSerializable(KEY_MOVIE_DETAIL, movie)
    }

    override fun onBackPressed() {
        val myFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.container)
        if (myFragment != null && myFragment is DetailMovieFragment) {
            finish()
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed()
            }
        }
    }
}