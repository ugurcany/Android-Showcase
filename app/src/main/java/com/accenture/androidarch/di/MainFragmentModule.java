package com.accenture.androidarch.di;

import com.accenture.androidarch.ui.main.IMainNav;
import com.accenture.androidarch.ui.main.MainNavController;
import com.accenture.androidarch.ui.main.explore.ExploreFragment;
import com.accenture.androidarch.ui.main.home.HomeFragment;
import com.accenture.androidarch.ui.main.profile.ProfileFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainFragmentModule {

    @Binds
    @ActivityScope
    abstract IMainNav mainNavController(MainNavController mainNavController);

    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector
    abstract ExploreFragment contributeExploreFragment();

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

}