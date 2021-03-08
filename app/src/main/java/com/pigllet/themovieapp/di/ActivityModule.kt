package com.pigllet.themovieapp.di

import com.pigllet.themovieapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MovieModule::class])
    abstract fun provideMainActivity(): MainActivity
}