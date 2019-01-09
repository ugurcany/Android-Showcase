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

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import io.reactivex.Observable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.data.MovieResults;
import mobi.mergen.androidshowcase.helper.ResourceUtil;
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
    public void checkEmptyTextVisibility() {
        BaristaVisibilityAssertions.assertDisplayed(R.string.moviesearch_results_empty);
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkResultsVisibilityAndCount() {
        String searchText = "lord";
        MovieResults response = ResourceUtil.readFromAssets(
                "movie_search_response.json", MovieResults.class);
        final int RESULTS_COUNT = 10;

        Mockito.when(movieRepository.search(searchText))
                .thenReturn(Observable.just(response));

        SearchViewInteractions.typeAndSubmit(R.id.searchview, searchText);

        BaristaVisibilityAssertions.assertDisplayed(R.id.recyclerview_results);
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
                R.id.recyclerview_results, RESULTS_COUNT);
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkErrorTextVisibility() {
        String searchText = "invalid movie title";

        Mockito.when(movieRepository.search(searchText))
                .thenReturn(Observable.error(new Exception()));

        SearchViewInteractions.typeAndSubmit(R.id.searchview, searchText);

        BaristaVisibilityAssertions.assertDisplayed(R.string.moviesearch_results_error);
    }

}