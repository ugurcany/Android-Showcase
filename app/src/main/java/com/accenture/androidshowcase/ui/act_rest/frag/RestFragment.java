package com.accenture.androidshowcase.ui.act_rest.frag;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.data.MovieResults;
import com.accenture.androidshowcase.databinding.FragmentRestBinding;
import com.accenture.androidshowcase.ui.base.BaseFragment;
import com.blankj.utilcode.util.KeyboardUtils;
import com.kennyc.view.MultiStateView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RestFragment
        extends BaseFragment<FragmentRestBinding, RestViewModel> {

    private ResultsAdapter resultsAdapter;

    public static RestFragment initialize() {
        RestFragment fragment = new RestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        KeyboardUtils.hideSoftInput(rootView);

        getBinding().recyclerviewResults.setLayoutManager(
                new LinearLayoutManager(getContext()));
        getBinding().recyclerviewResults.setAdapter(
                resultsAdapter = new ResultsAdapter());

        getBinding().edittextSearch.setOnEditorActionListener(
                (TextView v, int actionId, KeyEvent event) -> {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        String searchText = v.getText().toString().trim();
                        getViewModel().searchMovie(searchText);
                    }
                    return false;
                });

        observeResults();

        return rootView;
    }

    @Override
    public int layoutRes() {
        return R.layout.fragment_rest;
    }

    @Override
    public Class<RestViewModel> viewModelClass() {
        return RestViewModel.class;
    }

    private void observeResults() {
        observe(getViewModel().getResults(), (MovieResults movieResults) -> {
            if (movieResults != null) {
                resultsAdapter.setNewData(movieResults.getResults());

                ((TextView) getBinding().multistateview.getView(MultiStateView.VIEW_STATE_ERROR)
                        .findViewById(R.id.textview_message)).setText(movieResults.getErrorMsg());
            }
        });

        observe(getViewModel().getResultsState(), (ResultsState resultsState) -> {
            if (resultsState != null) {
                resultsState.decorate(getBinding());
            }
        });
    }
}
