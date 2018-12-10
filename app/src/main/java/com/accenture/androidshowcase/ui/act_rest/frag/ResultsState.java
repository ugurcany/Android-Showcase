package com.accenture.androidshowcase.ui.act_rest.frag;

import com.accenture.androidshowcase.databinding.FragmentRestBinding;
import com.accenture.androidshowcase.ui.base.IState;
import com.kennyc.view.MultiStateView;

import io.reactivex.functions.Consumer;

public enum ResultsState implements IState<FragmentRestBinding> {
    EMPTY(ResultsState::setEmpty),
    LOADING(ResultsState::setLoading),
    CONTENT(ResultsState::setContent),
    ERROR(ResultsState::setError);

    private Consumer<FragmentRestBinding> consumer;

    ResultsState(Consumer<FragmentRestBinding> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void decorate(FragmentRestBinding binding) {
        decorate(consumer, binding);
    }

    private static void setEmpty(FragmentRestBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_EMPTY);
    }

    private static void setLoading(FragmentRestBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_LOADING);
    }

    private static void setContent(FragmentRestBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_CONTENT);
    }

    private static void setError(FragmentRestBinding binding) {
        binding.multistateview.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }
}
