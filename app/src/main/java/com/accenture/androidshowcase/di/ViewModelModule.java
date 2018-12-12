package com.accenture.androidshowcase.di;

import com.accenture.androidshowcase.ui.act_multicounter.frag.MultiCounterViewModel;
import com.accenture.androidshowcase.ui.act_moviesearch.frag.MovieSearchViewModel;
import com.accenture.androidshowcase.viewmodel.ViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract ViewModelProvider.Factory viewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(MultiCounterViewModel.class)
    abstract ViewModel multiCounterViewModel(MultiCounterViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieSearchViewModel.class)
    abstract ViewModel movieSearchViewModel(MovieSearchViewModel viewModel);

}