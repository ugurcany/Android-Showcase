package com.accenture.androidshowcase.ui;

import android.os.Bundle;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.common.Navigator;
import com.accenture.androidshowcase.databinding.ActivityMainBinding;
import com.accenture.androidshowcase.ui.act_bottombar.BottomBarActivity;
import com.accenture.androidshowcase.ui.act_rest.RestActivity;
import com.accenture.androidshowcase.ui.base.BaseActivity;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBinding().buttonBottombar.setOnClickListener(v ->
                Navigator.start(this, BottomBarActivity.class));
        getBinding().buttonRest.setOnClickListener(v ->
                Navigator.start(this, RestActivity.class));
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