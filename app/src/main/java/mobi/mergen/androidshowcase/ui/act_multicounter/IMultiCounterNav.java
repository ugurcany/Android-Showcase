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
