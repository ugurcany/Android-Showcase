package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.di.act_module.MultiCounterActivityModule;
import com.accenture.androidshowcase.di.act_module.MovieSearchActivityModule;
import com.accenture.androidshowcase.ui.act_main.MainActivity;
import com.accenture.androidshowcase.ui.act_splash.SplashActivity;
import com.accenture.androidshowcase.ui.act_multicounter.MultiCounterActivity;
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
    @ContributesAndroidInjector(modules = MultiCounterActivityModule.class)
    abstract MultiCounterActivity contributeBottomBarActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieSearchActivityModule.class)
    abstract MovieSearchActivity contributeMovieSearchActivity();

}