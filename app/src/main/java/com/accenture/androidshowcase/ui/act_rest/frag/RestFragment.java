package com.accenture.androidshowcase.ui.act_rest.frag;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.databinding.FragmentRestBinding;
import com.accenture.androidshowcase.ui.base.BaseFragment;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;

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

        KeyboardUtils.hideSoftInput(rootView);

        getBinding().edittextSearch.setOnEditorActionListener(
                (TextView v, int actionId, KeyEvent event) -> {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        String searchText = v.getText().toString().trim();
                        ToastUtils.showShort(searchText);
                    }
                    return false;
                });

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
