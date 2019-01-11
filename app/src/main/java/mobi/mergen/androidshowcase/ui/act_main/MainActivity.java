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

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.common.Navigator;
import mobi.mergen.androidshowcase.data.MainListItem;
import mobi.mergen.androidshowcase.databinding.ActivityMainBinding;
import mobi.mergen.androidshowcase.ui.act_fleximages.FlexImagesActivity;
import mobi.mergen.androidshowcase.ui.act_moviesearch.MovieSearchActivity;
import mobi.mergen.androidshowcase.ui.act_multicounter.MultiCounterActivity;
import mobi.mergen.androidshowcase.ui.act_readme.ReadmeActivity;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding>
        implements BaseQuickAdapter.OnItemClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Navigator.start(this, ReadmeActivity.class);
                break;
            default:
                break;
        }
        return true;
    }

    private List<MainListItem> initListItems() {
        List<MainListItem> items = new ArrayList<>();

        items.add(new MainListItem(
                getString(R.string.main_title_multicounter),
                getString(R.string.main_desc_multicounter),
                () -> Navigator.start(this, MultiCounterActivity.class)));
        items.add(new MainListItem(
                getString(R.string.main_title_moviesearch),
                getString(R.string.main_desc_moviesearch),
                () -> Navigator.start(this, MovieSearchActivity.class)));
        items.add(new MainListItem(
                getString(R.string.main_title_fleximages),
                getString(R.string.main_desc_fleximages),
                () -> Navigator.start(this, FlexImagesActivity.class)));
        return items;
    }

    private void initRecyclerView() {
        getBinding().recyclerview.setLayoutManager(
                new LinearLayoutManager(this));

        MainListAdapter adapter;
        getBinding().recyclerview.setAdapter(
                adapter = new MainListAdapter(initListItems()));
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        MainListItem item = (MainListItem) adapter.getData().get(position);
        try {
            item.getClickAction().run();
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }
}