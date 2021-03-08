package com.pigllet.themovieapp.di


import com.pigllet.themovieapp.presentation.detail_movie.DetailMovieFragment
import com.pigllet.themovieapp.presentation.home_movie.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideMovieDetailFragment(): DetailMovieFragment
}