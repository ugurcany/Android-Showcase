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

import android.content.Context;
import android.widget.TextView;

import com.kennyc.view.MultiStateView;

import java.util.List;

import io.reactivex.functions.Consumer;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.data.Movie;
import mobi.mergen.androidshowcase.databinding.FragmentMovieSearchBinding;
import mobi.mergen.androidshowcase.ui.base.IState;

public enum MovieResultsState implements IState<FragmentMovieSearchBinding> {
    EMPTY(MovieResultsState::setEmpty),
    LOADING(MovieResultsState::setLoading),
    CONTENT(MovieResultsState::setContent),
    ERROR(MovieResultsState::setError);

    private Consumer<FragmentMovieSearchBinding> consumer;

    MovieResultsState(Consumer<FragmentMovieSearchBinding> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void decorate(FragmentMovieSearchBinding binding) {
        decorate(consumer, binding);
    }

    private static void setEmpty(FragmentMovieSearchBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_EMPTY);
    }

    private static void setLoading(FragmentMovieSearchBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_LOADING);
    }

    private static void setContent(FragmentMovieSearchBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_CONTENT);

        List<Movie> movies = binding.getData().getMovies();
        ((MovieResultsAdapter) binding.recyclerviewResults.getAdapter())
                .setNewData(movies);
    }

    private static void setError(FragmentMovieSearchBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_ERROR);

        Context context = binding.getRoot().getContext();

        String errorMsg = context.getString(R.string.moviesearch_results_error);
        if (binding.getData() != null) {
            errorMsg = binding.getData().getErrorMsg();
        }

        ((TextView) binding.multistateview.getView(MultiStateView.VIEW_STATE_ERROR)
                .findViewById(R.id.textview_message)).setText(errorMsg);
    }
}
