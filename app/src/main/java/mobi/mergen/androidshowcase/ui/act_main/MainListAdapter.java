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