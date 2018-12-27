package mobi.mergen.androidshowcase.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import mobi.mergen.androidshowcase.repository.movie.IMovieRepository;
import mobi.mergen.androidshowcase.repository.movie.MovieRepository;

@Module(includes = {RestModule.class, LocalDbModule.class})
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract IMovieRepository movieRepository(MovieRepository repository);

}