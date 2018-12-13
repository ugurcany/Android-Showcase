package com.accenture.androidshowcase.repository.movie;

import com.accenture.androidshowcase.data.MovieResults;

import io.reactivex.Observable;

public interface IMovieRepository {

    Observable<MovieResults> search(String searchText);

}
