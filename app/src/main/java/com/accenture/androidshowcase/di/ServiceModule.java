package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.service.movie.IMovieService;
import com.accenture.androidshowcase.service.movie.MovieService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract IMovieService restService(MovieService service);

}