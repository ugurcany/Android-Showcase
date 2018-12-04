package com.accenture.androidarch.di;

import com.accenture.androidarch.service.IService;
import com.accenture.androidarch.service.Service;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract IService service(Service service);

}