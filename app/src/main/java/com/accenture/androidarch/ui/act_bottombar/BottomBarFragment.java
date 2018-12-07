package com.accenture.androidarch.ui.act_bottombar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accenture.androidarch.R;
import com.accenture.androidarch.databinding.FragmentBottombarBinding;
import com.accenture.androidarch.ui.base.BaseFragment;
import com.evernote.android.state.State;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomBarFragment
        extends BaseFragment<FragmentBottombarBinding, BottomBarViewModel> {

    @Inject
    IBottomBarNav bottomBarNavController;

    @State
    int pageId;
    @State
    int count;

    public static BottomBarFragment initialize(int pageId) {
        BottomBarFragment fragment = new BottomBarFragment();
        fragment.pageId = pageId;
        fragment.count = 0;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getBinding().setPageName(getString(R.string.bottombar_page_x, pageId + 1));
        getBinding().setCount(count);

        getBinding().fab.setOnClickListener((v) -> getBinding().setCount(++count));

        return rootView;
    }

    @Override
    public int layoutRes() {
        return R.layout.fragment_bottombar;
    }

    @Override
    public Class<BottomBarViewModel> viewModelClass() {
        return BottomBarViewModel.class;
    }

}
