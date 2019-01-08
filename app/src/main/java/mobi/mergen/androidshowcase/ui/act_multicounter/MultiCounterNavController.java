/*
 * Copyright 2018 UGURCAN YILDIRIM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mobi.mergen.androidshowcase.ui.act_multicounter;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;
import com.ncapdevi.fragnav.tabhistory.UniqueTabHistoryStrategy;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.common.Navigator;
import mobi.mergen.androidshowcase.di.helper.ActivityScope;
import mobi.mergen.androidshowcase.ui.act_multicounter.frag.MultiCounterFragment;

@ActivityScope
public class MultiCounterNavController implements IMultiCounterNav {

    private FragNavController fragNavController;
    private BottomNavigationView bottomBar;

    @Inject
    MultiCounterNavController(MultiCounterActivity multiCounterActivity) {
        fragNavController = new FragNavController(
                multiCounterActivity.getSupportFragmentManager(),
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
        bottomBar.setSelectedItemId(R.id.action_home);
        bottomBar.setOnNavigationItemSelectedListener(this);
        bottomBar.setOnNavigationItemReselectedListener(this);
        this.bottomBar = bottomBar;

        fragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    @Override
    public void clear() {
        fragNavController = null;
        bottomBar = null;
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
                return MultiCounterFragment.initialize(i + 1, 1);
            case FragNavController.TAB2:
                return MultiCounterFragment.initialize(i + 1, 1);
            case FragNavController.TAB3:
                return MultiCounterFragment.initialize(i + 1, 1);
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
    public void pushFragment(int pageId, int pageInCurrentTabId) {
        fragNavController.pushFragment(
                MultiCounterFragment.initialize(pageId, pageInCurrentTabId));
    }
}
