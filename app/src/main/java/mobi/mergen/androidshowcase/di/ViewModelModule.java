/*
 * Copyright 2018 UGURCAN YILDIRIM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mobi.mergen.androidshowcase.di;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import mobi.mergen.androidshowcase.di.helper.ViewModelKey;
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