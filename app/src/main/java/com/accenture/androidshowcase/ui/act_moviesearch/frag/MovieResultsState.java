package com.accenture.androidshowcase.ui.act_moviesearch.frag;

import android.widget.TextView;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.data.Movie;
import com.accenture.androidshowcase.databinding.FragmentMovieSearchBinding;
import com.accenture.androidshowcase.ui.base.IState;
import com.kennyc.view.MultiStateView;

import java.util.List;

import io.reactivex.functions.Consumer;

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

        String errorMsg = binding.getData().getErrorMsg();
        ((TextView) binding.multistateview.getView(MultiStateView.VIEW_STATE_ERROR)
                .findViewById(R.id.textview_message)).setText(errorMsg);
    }
}
