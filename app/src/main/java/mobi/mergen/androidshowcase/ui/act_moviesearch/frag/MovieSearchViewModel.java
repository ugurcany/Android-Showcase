/*
 * Copyright 2018 UGURCAN YILDIRIM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

        results.postValue(null);
        resultsState.postValue(MovieResultsState.EMPTY);
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
                .subscribe((MovieResults movieResults) -> {
                            results.setValue(movieResults);
                            if (movieResults.isSuccessful()) {
                                resultsState.setValue(MovieResultsState.CONTENT);
                            } else {
                                resultsState.setValue(MovieResultsState.ERROR);
                            }
                        },
                        (Throwable throwable) -> {
                            results.setValue(null);
                            resultsState.setValue(MovieResultsState.ERROR);
                        }));
    }
}
