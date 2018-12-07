package com.accenture.androidarch.ui;

import android.os.Bundle;

import com.accenture.androidarch.R;
import com.accenture.androidarch.common.Navigator;
import com.accenture.androidarch.databinding.ActivityMainBinding;
import com.accenture.androidarch.ui.act_bottombar.BottomBarActivity;
import com.accenture.androidarch.ui.base.BaseActivity;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBinding().buttonBottombar.setOnClickListener(v ->
                Navigator.start(this, BottomBarActivity.class));
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