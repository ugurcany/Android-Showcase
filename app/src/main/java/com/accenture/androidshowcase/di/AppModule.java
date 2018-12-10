package com.accenture.androidshowcase.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract Context appContext(Application app);

}