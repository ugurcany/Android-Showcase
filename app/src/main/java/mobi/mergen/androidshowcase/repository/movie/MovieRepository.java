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

package mobi.mergen.androidshowcase.repository.movie;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mobi.mergen.androidshowcase.data.MovieResults;
import mobi.mergen.androidshowcase.repository.localdb.LocalDb;

@Singleton
public class MovieRepository implements IMovieRepository {

    private MovieApi api;
    private LocalDb.Box<MovieResults> localDbBox;

    @Inject
    MovieRepository(MovieApi movieApi, LocalDb localDb) {
        this.api = movieApi;
        this.localDbBox = localDb.getBox("movies", MovieResults.class);
    }

    @Override
    public Observable<MovieResults> search(String searchText) {
        return Observable.concat(
                movieResultsInLocalDb(searchText),
                movieResultsThruApi(searchText)
        );
    }

    private Observable<MovieResults> movieResultsInLocalDb(String searchText) {
        MovieResults movieResultsInDb;
        return (movieResultsInDb = localDbBox.get(searchText)) != null
                ? Observable.just(movieResultsInDb) : Observable.empty();
    }

    private Observable<MovieResults> movieResultsThruApi(String searchText) {
        return api.search(searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext((MovieResults movieResults) ->
                        localDbBox.put(searchText, movieResults)
                );
    }
}
