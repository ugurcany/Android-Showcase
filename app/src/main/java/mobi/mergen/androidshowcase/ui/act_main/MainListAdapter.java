package mobi.mergen.androidshowcase.ui.act_main;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.data.MainListItem;

public class MainListAdapter extends BaseQuickAdapter<MainListItem, BaseViewHolder> {

    MainListAdapter(List<MainListItem> items) {
        super(R.layout.view_card_item, items);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MainListItem item) {
        viewHolder.setText(R.id.textview_title, item.getTitle());
        viewHolder.setText(R.id.textview_desc, item.getDesc());
    }
}