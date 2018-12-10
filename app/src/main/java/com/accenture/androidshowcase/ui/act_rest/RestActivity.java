package com.accenture.androidshowcase.ui.act_rest;

import android.os.Bundle;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.databinding.ActivityRestBinding;
import com.accenture.androidshowcase.ui.act_rest.frag.RestFragment;
import com.accenture.androidshowcase.ui.base.BaseActivity;
import com.blankj.utilcode.util.FragmentUtils;

import androidx.annotation.Nullable;

public class RestActivity extends BaseActivity<ActivityRestBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentUtils.replace(getSupportFragmentManager(),
                RestFragment.initialize(),
                R.id.container_fragment);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_rest;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return true;
    }
}