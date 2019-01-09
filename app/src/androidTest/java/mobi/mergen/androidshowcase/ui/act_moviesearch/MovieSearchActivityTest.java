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

package mobi.mergen.androidshowcase.ui.act_moviesearch;

import android.content.Intent;

import com.google.gson.Gson;
import com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions;
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions;
import com.schibsted.spain.barista.rule.BaristaRule;
import com.schibsted.spain.barista.rule.flaky.AllowFlaky;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import io.reactivex.Observable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.data.MovieResults;
import mobi.mergen.androidshowcase.helper.SearchViewInteractions;
import mobi.mergen.androidshowcase.repository.movie.IMovieRepository;
import mobi.mergen.androidshowcase.ui.act_moviesearch.frag.MovieSearchViewModel;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;
import mobi.mergen.androidshowcase.viewmodel.ViewModelFactory;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MovieSearchActivityTest {

    @Mock
    IMovieRepository movieRepository;

    @InjectMocks
    MovieSearchViewModel movieSearchViewModel;

    @Mock
    ViewModelFactory viewModelFactory;

    @Rule
    public BaristaRule<MovieSearchActivity> rule = BaristaRule.create(MovieSearchActivity.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(viewModelFactory.create(MovieSearchViewModel.class))
                .thenReturn(movieSearchViewModel);

        Intent intent = new Intent();
        intent.putExtra(BaseActivity.IS_TESTING, true);
        rule.launchActivity(intent);
        rule.getActivityTestRule().getActivity().loadFragmentWithViewModelFactory(viewModelFactory);
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkEmptyTextVisible() {
        BaristaVisibilityAssertions.assertDisplayed(R.string.moviesearch_results_empty);
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkResultsVisibilityAndCount() {
        Mockito.when(movieRepository.search(Mockito.anyString()))
                .thenReturn(Observable.just(movieSearchResponse()));

        SearchViewInteractions.writeToAndSubmit(R.id.searchview, "lord");

        BaristaVisibilityAssertions.assertDisplayed(R.id.recyclerview_results);
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
                R.id.recyclerview_results, 10);
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkErrorTextVisible() {
        Mockito.when(movieRepository.search(Mockito.anyString()))
                .thenReturn(Observable.error(new Exception()));

        SearchViewInteractions.writeToAndSubmit(R.id.searchview, "invalid movie title");

        BaristaVisibilityAssertions.assertDisplayed(R.string.moviesearch_results_error);
    }

    private MovieResults movieSearchResponse() {
        try {
            InputStream responseStream = InstrumentationRegistry.getInstrumentation().getContext()
                    .getResources().getAssets().open("movie_search_response.json");
            return new Gson().fromJson(new InputStreamReader(responseStream), MovieResults.class);
        } catch (IOException e) {
            return new MovieResults();
        }
    }
}