package com.accenture.androidshowcase.ui.act_moviesearch;

import android.os.Bundle;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.databinding.ActivityMovieSearchBinding;
import com.accenture.androidshowcase.ui.act_moviesearch.frag.MovieSearchFragment;
import com.accenture.androidshowcase.ui.base.BaseActivity;
import com.blankj.utilcode.util.FragmentUtils;

import androidx.annotation.Nullable;

public class MovieSearchActivity extends BaseActivity<ActivityMovieSearchBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentUtils.replace(getSupportFragmentManager(),
                    MovieSearchFragment.initialize(),
                    R.id.container_fragment);
        }
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_movie_search;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return true;
    }
}