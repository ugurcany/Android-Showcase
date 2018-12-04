package com.accenture.androidarch.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.accenture.androidarch.R;
import com.accenture.androidarch.databinding.ActivityMainBinding;
import com.accenture.androidarch.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Inject
    IMainNav mainNavController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainNavController.init(savedInstanceState, getBinding().bottombar);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Toolbar toolbar() {
        return getBinding().toolbar;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mainNavController.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (!mainNavController.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}