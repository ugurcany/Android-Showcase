package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.service.movie.IMovieService;
import com.accenture.androidshowcase.service.movie.MovieService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module(includes = {RestModule.class, LocalDbModule.class})
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract IMovieService movieService(MovieService service);

}