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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.evernote.android.state.State;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.common.Navigator;
import mobi.mergen.androidshowcase.data.Movie;
import mobi.mergen.androidshowcase.data.MovieResults;
import mobi.mergen.androidshowcase.databinding.FragmentMovieSearchBinding;
import mobi.mergen.androidshowcase.ui.base.TestableBaseFragment;

public class MovieSearchFragment
        extends TestableBaseFragment<FragmentMovieSearchBinding, MovieSearchViewModel>
        implements SearchView.OnQueryTextListener, BaseQuickAdapter.OnItemClickListener {

    @State
    String searchText;

    public static MovieSearchFragment initialize() {
        MovieSearchFragment fragment = new MovieSearchFragment();
        fragment.searchText = "";
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        initSearchView();
        initRecyclerView();

        observeResults();

        return rootView;
    }

    @Override
    public int layoutRes() {
        return R.layout.fragment_movie_search;
    }

    @Override
    public Class<MovieSearchViewModel> viewModelClass() {
        return MovieSearchViewModel.class;
    }

    private void initSearchView() {
        getBinding().searchview.setOnQueryTextListener(this);
        getBinding().searchview.setQuery(searchText, true);
    }

    private void initRecyclerView() {
        getBinding().recyclerviewResults.setHasFixedSize(true);
        getBinding().recyclerviewResults.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        getBinding().recyclerviewResults.setLayoutManager(
                new LinearLayoutManager(getContext()));

        MovieResultsAdapter resultsAdapter;
        getBinding().recyclerviewResults.setAdapter(
                resultsAdapter = new MovieResultsAdapter());
        resultsAdapter.setOnItemClickListener(this);
    }

    private void observeResults() {
        observe(getViewModel().getResults(), (MovieResults results) -> {
            if (results != null) {
                getBinding().setData(results);
            }
        });

        observe(getViewModel().getResultsState(), (MovieResultsState resultsState) -> {
            if (resultsState != null) {
                resultsState.decorate(getBinding());
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchText = query.trim();
        if (!searchText.isEmpty()) {
            getViewModel().searchMovie(searchText);
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Movie movie = getBinding().getData().getMovies().get(position);
        Navigator.goToWebPage("https://www.imdb.com/title/" + movie.getImdbId());
    }
}
