package com.pigllet.themovieapp.di

import com.example.basecleandaggerrx.rx.SchedulersFacade
import com.example.basecleandaggerrx.rx.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideSchedules(schedulersProvider: SchedulersFacade) : SchedulersProvider
}