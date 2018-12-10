package com.accenture.androidarch.di;

import com.accenture.androidarch.ui.act_bottombar.frag.BottomBarViewModel;
import com.accenture.androidarch.viewmodel.ViewModelFactory;

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
    @ViewModelKey(BottomBarViewModel.class)
    abstract ViewModel bottomBarViewModel(BottomBarViewModel viewModel);

}