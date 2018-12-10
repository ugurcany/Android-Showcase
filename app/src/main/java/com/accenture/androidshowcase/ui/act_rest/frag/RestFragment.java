package com.accenture.androidshowcase.ui.act_rest.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.databinding.FragmentRestBinding;
import com.accenture.androidshowcase.ui.base.BaseFragment;
import com.blankj.utilcode.util.KeyboardUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RestFragment
        extends BaseFragment<FragmentRestBinding, RestViewModel> {

    public static RestFragment initialize() {
        RestFragment fragment = new RestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        KeyboardUtils.hideSoftInput(getActivity());

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

}
