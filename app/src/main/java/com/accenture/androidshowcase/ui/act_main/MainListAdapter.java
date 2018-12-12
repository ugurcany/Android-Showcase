package com.accenture.androidshowcase.ui.act_main;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.data.MainListItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MainListAdapter extends BaseQuickAdapter<MainListItem, BaseViewHolder> {

    MainListAdapter(List<MainListItem> items) {
        super(R.layout.view_card_item, items);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MainListItem item) {
        viewHolder.setText(R.id.textview_title, item.getTitle());
        viewHolder.setText(R.id.textview_subtitle, item.getSubtitle());
        viewHolder.setText(R.id.textview_desc, item.getDesc());
    }
}