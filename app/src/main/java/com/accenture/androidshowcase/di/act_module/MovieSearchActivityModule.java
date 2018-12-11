package com.accenture.androidshowcase.di.act_module;

import com.accenture.androidshowcase.ui.act_moviesearch.frag.MovieSearchFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieSearchActivityModule {

    @ContributesAndroidInjector
    abstract MovieSearchFragment contributeMovieSearchFragment();

}