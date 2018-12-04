package com.accenture.androidarch.di;

import com.accenture.androidarch.ui.main.MainActivity;
import com.accenture.androidarch.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainActivity contributeMainActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

}