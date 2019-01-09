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

package mobi.mergen.androidshowcase.ui.act_main;

import com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions;
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions;
import com.schibsted.spain.barista.rule.BaristaRule;
import com.schibsted.spain.barista.rule.flaky.AllowFlaky;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import mobi.mergen.androidshowcase.R;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public BaristaRule<MainActivity> rule = BaristaRule.create(MainActivity.class);

    @Before
    public void setUp() {
        rule.launchActivity();
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkInfoButtonVisible() {
        BaristaVisibilityAssertions.assertDisplayed(R.id.action_info);
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkMainListItemCount() {
        BaristaRecyclerViewAssertions.assertRecyclerViewItemCount(
                R.id.recyclerview, 3);
    }

}