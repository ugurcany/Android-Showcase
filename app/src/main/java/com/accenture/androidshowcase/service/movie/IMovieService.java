package com.accenture.androidshowcase.service.movie;

import com.accenture.androidshowcase.data.MovieResults;

import io.reactivex.Observable;

public interface IMovieService {

    Observable<MovieResults> search(String searchText);

}
