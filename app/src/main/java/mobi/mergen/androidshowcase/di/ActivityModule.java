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

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mobi.mergen.androidshowcase.di.act_module.MovieSearchActivityModule;
import mobi.mergen.androidshowcase.di.act_module.MultiCounterActivityModule;
import mobi.mergen.androidshowcase.ui.act_fleximages.FlexImagesActivity;
import mobi.mergen.androidshowcase.ui.act_main.MainActivity;
import mobi.mergen.androidshowcase.ui.act_moviesearch.MovieSearchActivity;
import mobi.mergen.androidshowcase.ui.act_multicounter.MultiCounterActivity;
import mobi.mergen.androidshowcase.ui.act_readme.ReadmeActivity;
import mobi.mergen.androidshowcase.ui.act_splash.SplashActivity;

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract ReadmeActivity contributeReadmeActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MultiCounterActivityModule.class)
    abstract MultiCounterActivity contributeMutliCounterActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieSearchActivityModule.class)
    abstract MovieSearchActivity contributeMovieSearchActivity();

    @ActivityScope
    @ContributesAndroidInjector
    abstract FlexImagesActivity contributeFlexImagesActivity();

}