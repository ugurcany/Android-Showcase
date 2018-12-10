package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.service.IService;
import com.accenture.androidshowcase.service.Service;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract IService service(Service service);

}