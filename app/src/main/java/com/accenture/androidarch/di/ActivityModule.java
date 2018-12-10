package com.accenture.androidarch.di;

import com.accenture.androidarch.ui.act_main.MainActivity;
import com.accenture.androidarch.ui.act_bottombar.BottomBarActivity;
import com.accenture.androidarch.ui.act_splash.SplashActivity;

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
    @ContributesAndroidInjector(modules = BottomBarFragmentModule.class)
    abstract BottomBarActivity contributeBottomBarActivity();


}