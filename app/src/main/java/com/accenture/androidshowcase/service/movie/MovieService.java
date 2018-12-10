package com.accenture.androidshowcase.service.movie;

import android.content.Context;

import com.accenture.androidshowcase.data.MovieResults;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class MovieService implements IMovieService {

    private static final String API_KEY = "583ac0ed";

    private MovieApi api;

    @Inject
    MovieService(Context context) {
        api = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://www.omdbapi.com/")
                .build()
                .create(MovieApi.class);
    }

    @Override
    public Observable<MovieResults> search(String searchText) {
        return api.search(API_KEY, searchText);
    }
}
