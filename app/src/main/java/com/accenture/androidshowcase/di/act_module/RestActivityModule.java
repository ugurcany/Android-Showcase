package com.accenture.androidshowcase.di.act_module;

import com.accenture.androidshowcase.ui.act_rest.frag.RestFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RestActivityModule {

    @ContributesAndroidInjector
    abstract RestFragment contributeRestFragment();

}