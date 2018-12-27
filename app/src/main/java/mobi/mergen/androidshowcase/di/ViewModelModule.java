package mobi.mergen.androidshowcase.di;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import mobi.mergen.androidshowcase.ui.act_moviesearch.frag.MovieSearchViewModel;
import mobi.mergen.androidshowcase.ui.act_multicounter.frag.MultiCounterViewModel;
import mobi.mergen.androidshowcase.viewmodel.ViewModelFactory;

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