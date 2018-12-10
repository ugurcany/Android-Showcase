package com.accenture.androidshowcase.service.movie;

import com.accenture.androidshowcase.data.MovieResults;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("")
    Observable<MovieResults> search(@Query("apikey") String apiKey,
                                    @Query("s") String searchText);

}
