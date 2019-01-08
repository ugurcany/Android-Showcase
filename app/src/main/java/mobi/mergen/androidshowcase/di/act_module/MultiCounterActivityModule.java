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

package mobi.mergen.androidshowcase.di.act_module;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mobi.mergen.androidshowcase.di.helper.ActivityScope;
import mobi.mergen.androidshowcase.ui.act_multicounter.IMultiCounterNav;
import mobi.mergen.androidshowcase.ui.act_multicounter.MultiCounterNavController;
import mobi.mergen.androidshowcase.ui.act_multicounter.frag.MultiCounterFragment;

@Module
public abstract class MultiCounterActivityModule {

    @Binds
    @ActivityScope
    abstract IMultiCounterNav fragNavController(MultiCounterNavController fragNavController);

    @ContributesAndroidInjector
    abstract MultiCounterFragment contributeMultiCounterFragment();

}