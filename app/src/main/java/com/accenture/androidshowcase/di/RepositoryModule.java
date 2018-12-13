package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.repository.movie.IMovieRepository;
import com.accenture.androidshowcase.repository.movie.MovieRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module(includes = {RestModule.class, LocalDbModule.class})
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract IMovieRepository movieRepository(MovieRepository repository);

}