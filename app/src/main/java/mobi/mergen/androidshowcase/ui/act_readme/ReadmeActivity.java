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

package mobi.mergen.androidshowcase.ui.act_readme;

import android.os.Bundle;

import androidx.annotation.Nullable;
import br.tiagohm.markdownview.css.styles.Github;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.databinding.ActivityReadmeBinding;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;

public class ReadmeActivity extends BaseActivity<ActivityReadmeBinding> {

    private final static String README_URL
            = "https://raw.githubusercontent.com/ugurcany/Android-Showcase/develop/README.md";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBinding().mdview.addStyleSheet(new Github());
        getBinding().mdview.loadMarkdownFromUrl(README_URL);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_readme;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return false;
    }

}