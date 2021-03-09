package com.pigllet.themovieapp.di

import android.app.Application

import com.pigllet.themovieapp.MovieApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, AndroidSupportInjectionModule::class, ActivityModule::class, ViewModelModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<MovieApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}