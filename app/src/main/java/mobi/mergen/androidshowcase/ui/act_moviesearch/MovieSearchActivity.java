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

package mobi.mergen.androidshowcase.ui.act_moviesearch;

import android.os.Bundle;

import com.blankj.utilcode.util.FragmentUtils;

import androidx.annotation.Nullable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.databinding.ActivityMovieSearchBinding;
import mobi.mergen.androidshowcase.ui.act_moviesearch.frag.MovieSearchFragment;
import mobi.mergen.androidshowcase.ui.base.TestableBaseActivity;
import mobi.mergen.androidshowcase.viewmodel.ViewModelFactory;

public class MovieSearchActivity extends TestableBaseActivity<ActivityMovieSearchBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null && !isOnTesting()) {
            FragmentUtils.replace(getSupportFragmentManager(),
                    MovieSearchFragment.initialize(),
                    R.id.container_fragment);
        }
    }

    @Override
    public void loadFragmentWithViewModelFactory(ViewModelFactory viewModelFactory) {
        MovieSearchFragment fragment = MovieSearchFragment.initialize();
        fragment.setViewModelFactory(viewModelFactory);

        FragmentUtils.replace(getSupportFragmentManager(),
                fragment,
                R.id.container_fragment);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_movie_search;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return true;
    }
}