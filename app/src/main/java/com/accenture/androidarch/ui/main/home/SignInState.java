package com.accenture.androidarch.ui.main.home;

import com.accenture.androidarch.databinding.FragmentHomeBinding;
import com.accenture.androidarch.ui.base.IState;

import io.reactivex.functions.Consumer;

public enum SignInState implements IState<FragmentHomeBinding> {
    ACTIVE(SignInState::setAsActive),
    LOADING(SignInState::setAsLoading),
    FAILED(SignInState::setAsFailed);

    private Consumer<FragmentHomeBinding> consumer;

    SignInState(Consumer<FragmentHomeBinding> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void decorate(FragmentHomeBinding binding) {
        decorate(consumer, binding);
    }

    private static void setAsActive(FragmentHomeBinding binding) {

    }

    private static void setAsLoading(FragmentHomeBinding binding) {

    }

    private static void setAsFailed(FragmentHomeBinding binding) {

    }
}
