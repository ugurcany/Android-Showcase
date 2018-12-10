package com.accenture.androidshowcase.di.act_module;

import com.accenture.androidshowcase.di.ActivityScope;
import com.accenture.androidshowcase.ui.act_bottombar.BottomBarNavController;
import com.accenture.androidshowcase.ui.act_bottombar.IBottomBarNav;
import com.accenture.androidshowcase.ui.act_bottombar.frag.BottomBarFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BottomBarActivityModule {

    @Binds
    @ActivityScope
    abstract IBottomBarNav fragNavController(BottomBarNavController fragNavController);

    @ContributesAndroidInjector
    abstract BottomBarFragment contributeBottomBarFragment();

}