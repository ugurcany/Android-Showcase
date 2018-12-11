package com.accenture.androidshowcase.ui;

import android.os.Bundle;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.common.Navigator;
import com.accenture.androidshowcase.databinding.ActivityMainBinding;
import com.accenture.androidshowcase.ui.act_bottombar.BottomBarActivity;
import com.accenture.androidshowcase.ui.act_moviesearch.MovieSearchActivity;
import com.accenture.androidshowcase.ui.base.BaseActivity;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBinding().cardviewBottombar.setOnClickListener(v ->
                Navigator.start(this, BottomBarActivity.class));
        getBinding().cardviewMoviesearch.setOnClickListener(v ->
                Navigator.start(this, MovieSearchActivity.class));
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return false;
    }
}