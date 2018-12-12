package com.accenture.androidshowcase.service.movie;

import com.accenture.androidshowcase.data.MovieResults;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Singleton
public class MovieService implements IMovieService {

    private static final String API_KEY = "583ac0ed";

    private MovieApi api;

    @Inject
    MovieService(Retrofit.Builder retrofitBuilder) {
        api = retrofitBuilder
                .baseUrl("https://www.omdbapi.com/")
                .build()
                .create(MovieApi.class);
    }

    @Override
    public Observable<MovieResults> search(String searchText) {
        return api.search(API_KEY, searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
