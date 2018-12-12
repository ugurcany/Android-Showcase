package com.accenture.androidshowcase.ui.act_main;

import android.os.Bundle;
import android.view.View;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.common.Navigator;
import com.accenture.androidshowcase.data.MainListItem;
import com.accenture.androidshowcase.databinding.ActivityMainBinding;
import com.accenture.androidshowcase.ui.act_moviesearch.MovieSearchActivity;
import com.accenture.androidshowcase.ui.act_multicounter.MultiCounterActivity;
import com.accenture.androidshowcase.ui.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

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

    private List<MainListItem> initListItems() {
        List<MainListItem> items = new ArrayList<>();

        items.add(new MainListItem(
                getString(R.string.main_title_multicounter),
                getString(R.string.main_subtitle_multicounter),
                getString(R.string.main_desc_multicounter),
                () -> Navigator.start(this, MultiCounterActivity.class)));
        items.add(new MainListItem(
                getString(R.string.main_title_moviesearch),
                getString(R.string.main_subtitle_moviesearch),
                getString(R.string.main_desc_moviesearch),
                () -> Navigator.start(this, MovieSearchActivity.class)));

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