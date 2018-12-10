package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.ui.act_bottombar.frag.BottomBarFragment;
import com.accenture.androidshowcase.ui.act_bottombar.BottomBarNavController;
import com.accenture.androidshowcase.ui.act_bottombar.IBottomBarNav;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class BottomBarFragmentModule {

    @Binds
    @ActivityScope
    abstract IBottomBarNav fragNavController(BottomBarNavController fragNavController);

    @ContributesAndroidInjector
    abstract BottomBarFragment contributeBottomBarFragment();

}