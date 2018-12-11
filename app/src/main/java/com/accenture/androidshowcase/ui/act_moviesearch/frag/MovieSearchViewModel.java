package com.accenture.androidshowcase.ui.act_moviesearch.frag;

import com.accenture.androidshowcase.data.MovieResults;
import com.accenture.androidshowcase.service.movie.IMovieService;
import com.accenture.androidshowcase.ui.base.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class MovieSearchViewModel extends BaseViewModel {

    private IMovieService movieService;

    private final MutableLiveData<MovieResults> results = new MutableLiveData<>();
    private final MutableLiveData<MovieResultsState> resultsState = new MutableLiveData<>();

    @Inject
    MovieSearchViewModel(IMovieService movieService) {
        this.movieService = movieService;

        results.setValue(null);
        resultsState.setValue(MovieResultsState.EMPTY);
    }

    MutableLiveData<MovieResults> getResults() {
        return results;
    }

    MutableLiveData<MovieResultsState> getResultsState() {
        return resultsState;
    }

    void searchMovie(String searchText) {
        resultsState.setValue(MovieResultsState.LOADING);

        dispose(movieService.search(searchText)
                .doOnNext((MovieResults movieResults) -> {
                    results.setValue(movieResults);
                    if (movieResults.isSuccessful()) {
                        resultsState.setValue(MovieResultsState.CONTENT);
                    } else {
                        resultsState.setValue(MovieResultsState.ERROR);
                    }
                })
                .doOnError((Throwable throwable) -> {
                    results.setValue(null);
                    resultsState.setValue(MovieResultsState.ERROR);
                })
                .subscribe());
    }
}
