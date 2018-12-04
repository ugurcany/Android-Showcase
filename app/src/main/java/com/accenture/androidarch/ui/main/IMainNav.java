package com.accenture.androidarch.ui.main;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavSwitchController;

public interface IMainNav extends FragNavController.RootFragmentListener,
        FragNavSwitchController,
        BottomNavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener {

    void init(Bundle savedInstanceState, BottomNavigationView bottomBar);

    void onSaveInstanceState(Bundle outState);

    boolean onBackPressed();

    void navigateToPlay();

    void navigateBackToHome();

}
