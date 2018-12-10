package com.accenture.androidshowcase.ui.act_rest.frag;

import com.accenture.androidshowcase.data.Movie;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class ResultsAdapter extends BaseQuickAdapter<Movie, BaseViewHolder> {

    public ResultsAdapter() {
        super(android.R.layout.simple_list_item_1, null);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Movie item) {
        viewHolder.setText(android.R.id.text1, item.getTitle());
    }
}