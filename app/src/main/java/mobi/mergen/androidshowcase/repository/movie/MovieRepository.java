package mobi.mergen.androidshowcase.repository.movie;

import net.rehacktive.waspdb.WaspDb;
import net.rehacktive.waspdb.WaspHash;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mobi.mergen.androidshowcase.data.MovieResults;
import retrofit2.Retrofit;

@Singleton
public class MovieRepository implements IMovieRepository {

    private static final String API_KEY = "583ac0ed";
    private static final String MOVIE_RESULTS_TABLE = "movie_results";

    private MovieApi api;
    private WaspHash movieResultsDb;

    @Inject
    MovieRepository(Retrofit.Builder retrofitBuilder, WaspDb waspDb) {
        api = retrofitBuilder
                .baseUrl("https://www.omdbapi.com/")
                .build()
                .create(MovieApi.class);

        movieResultsDb = waspDb.openOrCreateHash(MOVIE_RESULTS_TABLE);
    }

    @Override
    public Observable<MovieResults> search(String searchText) {
        return Observable.concat(
                movieResultsInLocalDb(searchText),
                movieResultsThruApi(searchText)
        );
    }

    private Observable<MovieResults> movieResultsInLocalDb(String searchText) {
        MovieResults movieResultsInDb;
        return (movieResultsInDb = movieResultsDb.get(searchText)) != null
                ? Observable.just(movieResultsInDb) : Observable.empty();
    }

    private Observable<MovieResults> movieResultsThruApi(String searchText) {
        return api.search(API_KEY, searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext((MovieResults movieResults) ->
                        movieResultsDb.put(searchText, movieResults)
                );
    }
}
