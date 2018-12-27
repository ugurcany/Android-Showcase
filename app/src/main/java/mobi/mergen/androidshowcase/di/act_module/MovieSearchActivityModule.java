package mobi.mergen.androidshowcase.di.act_module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mobi.mergen.androidshowcase.ui.act_moviesearch.frag.MovieSearchFragment;

@Module
public abstract class MovieSearchActivityModule {

    @ContributesAndroidInjector
    abstract MovieSearchFragment contributeMovieSearchFragment();

}