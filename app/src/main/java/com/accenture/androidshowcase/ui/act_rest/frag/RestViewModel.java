package com.accenture.androidshowcase.ui.act_rest.frag;

import com.accenture.androidshowcase.data.MovieResults;
import com.accenture.androidshowcase.service.movie.IMovieService;
import com.accenture.androidshowcase.ui.base.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;

public class RestViewModel extends BaseViewModel {

    private IMovieService movieService;

    private Disposable disposable;

    private final MutableLiveData<MovieResults> results = new MutableLiveData<>();
    private final MutableLiveData<ResultsState> resultsState = new MutableLiveData<>();

    @Inject
    RestViewModel(IMovieService movieService) {
        this.movieService = movieService;

        results.setValue(null);
        resultsState.setValue(ResultsState.EMPTY);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposeCalls();
    }

    MutableLiveData<MovieResults> getResults() {
        return results;
    }

    MutableLiveData<ResultsState> getResultsState() {
        return resultsState;
    }

    void searchMovie(String searchText) {
        resultsState.setValue(ResultsState.LOADING);

        disposeCalls();
        disposable = movieService.search(searchText)
                .doOnNext((MovieResults movieResults) -> {
                    results.setValue(movieResults);
                    if (movieResults.isSuccessful()) {
                        resultsState.setValue(ResultsState.CONTENT);
                    } else {
                        resultsState.setValue(ResultsState.ERROR);
                    }
                })
                .doOnError((Throwable throwable) -> {
                    results.setValue(null);
                    resultsState.setValue(ResultsState.ERROR);
                })
                .subscribe();
    }

    private void disposeCalls() {
        if (disposable != null) {
            disposable.dispose();
            disposable = null;
        }
    }
}
