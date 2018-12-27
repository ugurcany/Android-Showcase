package mobi.mergen.androidshowcase.ui.act_moviesearch.frag;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import mobi.mergen.androidshowcase.data.MovieResults;
import mobi.mergen.androidshowcase.repository.movie.IMovieRepository;
import mobi.mergen.androidshowcase.ui.base.BaseViewModel;

public class MovieSearchViewModel extends BaseViewModel {

    private IMovieRepository movieService;

    private final MutableLiveData<MovieResults> results = new MutableLiveData<>();
    private final MutableLiveData<MovieResultsState> resultsState = new MutableLiveData<>();

    @Inject
    MovieSearchViewModel(IMovieRepository movieService) {
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
