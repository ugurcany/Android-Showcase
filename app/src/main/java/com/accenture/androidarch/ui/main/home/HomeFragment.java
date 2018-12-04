package com.accenture.androidarch.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accenture.androidarch.R;
import com.accenture.androidarch.databinding.FragmentHomeBinding;
import com.accenture.androidarch.ui.base.BaseFragment;
import com.accenture.androidarch.ui.main.IMainNav;
import com.evernote.android.state.State;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeFragment
        extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    @Inject
    IMainNav mainNavController;

    @State
    int count;

    public static HomeFragment initialize() {
        HomeFragment fragment = new HomeFragment();
        fragment.count = 0;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getBinding().setCount(count);
        getBinding().fab.setOnClickListener((v) -> getBinding().setCount(++count));

        //OBSERVE LIVE DATA
        observeUserName();
        observeSignInState();
        observeMovieCount();

        return rootView;
    }

    @Override
    public int layoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public Class<HomeViewModel> viewModelClass() {
        return HomeViewModel.class;
    }

    private void observeUserName() {
        observe(getViewModel().getUserName(), userName -> {

        });
    }

    private void observeSignInState() {
        observe(getViewModel().getSignInState(), signInState -> {

        });
    }

    private void observeMovieCount() {
        observe(getViewModel().getMovieCount(), movieCount -> {

        });
    }
}
