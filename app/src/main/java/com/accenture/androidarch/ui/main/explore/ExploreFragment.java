package com.accenture.androidarch.ui.main.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accenture.androidarch.R;
import com.accenture.androidarch.databinding.FragmentExploreBinding;
import com.accenture.androidarch.ui.base.BaseFragment;
import com.accenture.androidarch.ui.main.IMainNav;
import com.accenture.androidarch.ui.main.home.HomeViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ExploreFragment
        extends BaseFragment<FragmentExploreBinding, HomeViewModel> {

    @Inject
    IMainNav mainNavController;

    public static ExploreFragment initialize() {
        return new ExploreFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public int layoutRes() {
        return R.layout.fragment_explore;
    }

    @Override
    public Class<HomeViewModel> viewModelClass() {
        return HomeViewModel.class;
    }
}
