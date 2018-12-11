package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.di.act_module.BottomBarActivityModule;
import com.accenture.androidshowcase.di.act_module.MovieSearchActivityModule;
import com.accenture.androidshowcase.ui.MainActivity;
import com.accenture.androidshowcase.ui.SplashActivity;
import com.accenture.androidshowcase.ui.act_bottombar.BottomBarActivity;
import com.accenture.androidshowcase.ui.act_moviesearch.MovieSearchActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = BottomBarActivityModule.class)
    abstract BottomBarActivity contributeBottomBarActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieSearchActivityModule.class)
    abstract MovieSearchActivity contributeMovieSearchActivity();

}