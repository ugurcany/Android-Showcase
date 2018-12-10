package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.ui.MainActivity;
import com.accenture.androidshowcase.ui.act_bottombar.BottomBarActivity;
import com.accenture.androidshowcase.ui.SplashActivity;

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