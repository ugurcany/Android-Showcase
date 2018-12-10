package com.accenture.androidshowcase.di;

import android.app.Application;
import android.content.Context;

import com.accenture.androidshowcase.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract Context appContext(Application app);

    @Binds
    @Singleton
    abstract ViewModelProvider.Factory viewModelFactory(ViewModelFactory viewModelFactory);

}