package com.accenture.androidshowcase.service.movie;

import com.accenture.androidshowcase.data.MovieResults;

import net.rehacktive.waspdb.WaspDb;
import net.rehacktive.waspdb.WaspHash;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Singleton
public class MovieService implements IMovieService {

    private static final String API_KEY = "583ac0ed";
    private static final String MOVIE_RESULTS_TABLE = "movie_results";

    private MovieApi api;
    private WaspHash movieResultsTable;

    @Inject
    MovieService(Retrofit.Builder retrofitBuilder, WaspDb waspDb) {
        api = retrofitBuilder
                .baseUrl("https://www.omdbapi.com/")
                .build()
                .create(MovieApi.class);

        movieResultsTable = waspDb.openOrCreateHash(MOVIE_RESULTS_TABLE);
    }

    @Override
    public Observable<MovieResults> search(String searchText) {
        MovieResults movieResultsInDb;

        return Observable.concat(
                (movieResultsInDb = movieResultsTable.get(searchText)) != null
                        ? Observable.just(movieResultsInDb) : Observable.empty(),
                api.search(API_KEY, searchText)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext((MovieResults movieResults) -> {
                            movieResultsTable.put(searchText, movieResults);
                        })
        );
    }
}
