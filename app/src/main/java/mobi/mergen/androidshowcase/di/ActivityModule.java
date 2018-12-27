package mobi.mergen.androidshowcase.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mobi.mergen.androidshowcase.di.act_module.MovieSearchActivityModule;
import mobi.mergen.androidshowcase.di.act_module.MultiCounterActivityModule;
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
    abstract MultiCounterActivity contributeBottomBarActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = MovieSearchActivityModule.class)
    abstract MovieSearchActivity contributeMovieSearchActivity();

}