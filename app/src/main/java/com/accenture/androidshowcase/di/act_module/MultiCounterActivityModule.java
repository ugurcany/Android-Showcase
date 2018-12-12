package com.accenture.androidshowcase.di.act_module;

import com.accenture.androidshowcase.di.ActivityScope;
import com.accenture.androidshowcase.ui.act_multicounter.MultiCounterNavController;
import com.accenture.androidshowcase.ui.act_multicounter.IMultiCounterNav;
import com.accenture.androidshowcase.ui.act_multicounter.frag.MultiCounterFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MultiCounterActivityModule {

    @Binds
    @ActivityScope
    abstract IMultiCounterNav fragNavController(MultiCounterNavController fragNavController);

    @ContributesAndroidInjector
    abstract MultiCounterFragment contributeMultiCounterFragment();

}