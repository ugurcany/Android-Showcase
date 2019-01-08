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

import javax.inject.Inject;

import androidx.annotation.Nullable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;
import mobi.mergen.androidshowcase.databinding.ActivityMultiCounterBinding;

public class MultiCounterActivity extends BaseActivity<ActivityMultiCounterBinding> {

    @Inject
    IMultiCounterNav fragNavController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNavController.init(savedInstanceState, getBinding().bottombar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragNavController.clear();
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_multi_counter;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        fragNavController.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (!fragNavController.onBackPressed()) {
            super.onBackPressed();
        }
    }
}