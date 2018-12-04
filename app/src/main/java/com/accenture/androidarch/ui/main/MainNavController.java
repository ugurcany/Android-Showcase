package com.accenture.androidarch.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.accenture.androidarch.R;
import com.accenture.androidarch.common.Navigator;
import com.accenture.androidarch.di.ActivityScope;
import com.accenture.androidarch.ui.main.explore.ExploreFragment;
import com.accenture.androidarch.ui.main.home.HomeFragment;
import com.accenture.androidarch.ui.main.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;
import com.ncapdevi.fragnav.tabhistory.UniqueTabHistoryStrategy;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

@ActivityScope
public class MainNavController implements IMainNav {

    private final FragNavController fragNavController;
    private BottomNavigationView bottomBar;

    @Inject
    MainNavController(MainActivity mainActivity) {
        fragNavController = new FragNavController(
                mainActivity.getSupportFragmentManager(),
                R.id.container_fragment);
        fragNavController.setNavigationStrategy(
                new UniqueTabHistoryStrategy(this));
        fragNavController.setDefaultTransactionOptions(
                FragNavTransactionOptions.Companion.newBuilder()
                        .customAnimations(Navigator.ENTER_ANIM, Navigator.EXIT_ANIM,
                                Navigator.ENTER_ANIM, Navigator.EXIT_ANIM)
                        .build());
        fragNavController.setRootFragmentListener(this);
    }

    @Override
    public void init(Bundle savedInstanceState, BottomNavigationView bottomBar) {
        this.bottomBar = bottomBar;
        bottomBar.setSelectedItemId(R.id.action_home);
        bottomBar.setOnNavigationItemSelectedListener(this);
        bottomBar.setOnNavigationItemReselectedListener(this);

        fragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (fragNavController != null) {
            fragNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public boolean onBackPressed() {
        return fragNavController.popFragment();
    }

    @Override
    public int getNumberOfRootFragments() {
        return bottomBar.getMenu().size();
    }

    @NotNull
    @Override
    public Fragment getRootFragment(int i) {
        switch (i) {
            case FragNavController.TAB1:
                return HomeFragment.initialize();
            case FragNavController.TAB2:
                return ExploreFragment.initialize();
            case FragNavController.TAB3:
                return ProfileFragment.initialize();
        }
        throw new IllegalStateException("No tab found for index:" + i);
    }

    @Override
    public void switchTab(int i, @Nullable FragNavTransactionOptions fragNavTransactionOptions) {
        int itemId = bottomBar.getMenu().getItem(i).getItemId();
        bottomBar.setSelectedItemId(itemId);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                fragNavController.switchTab(FragNavController.TAB1);
                break;
            case R.id.action_explore:
                fragNavController.switchTab(FragNavController.TAB2);
                break;
            case R.id.action_profile:
                fragNavController.switchTab(FragNavController.TAB3);
                break;
        }
        return true;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        if (fragNavController.getCurrentStack() != null
                && fragNavController.getCurrentStack().size() > 1) {
            fragNavController.clearStack();
        }
    }

    @Override
    public void navigateToPlay() {
        //fragNavController.pushFragment(new PlayFragment());
    }

    @Override
    public void navigateBackToHome() {
        while (!fragNavController.isRootFragment()) {
            fragNavController.popFragment();
        }
    }
}
