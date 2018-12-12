package com.accenture.androidshowcase.ui.act_multicounter;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavSwitchController;

public interface IMultiCounterNav extends FragNavController.RootFragmentListener,
        FragNavSwitchController,
        BottomNavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemReselectedListener {

    void init(Bundle savedInstanceState, BottomNavigationView bottomBar);

    void clear();

    void onSaveInstanceState(Bundle outState);

    boolean onBackPressed();

    void pushFragment(int pageId, int pageInCurrentTabId);
}
