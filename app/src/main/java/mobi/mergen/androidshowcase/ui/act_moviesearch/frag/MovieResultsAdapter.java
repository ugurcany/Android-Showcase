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

package mobi.mergen.androidshowcase.ui.act_moviesearch.frag;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.data.Movie;

public class MovieResultsAdapter extends BaseQuickAdapter<Movie, BaseViewHolder> {

    MovieResultsAdapter() {
        super(R.layout.view_movie_result_item, null);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Movie item) {
        Picasso.get()
                .load(item.getPosterUrl())
                .transform(new CropCircleTransformation())
                .into((ImageView) viewHolder.getView(R.id.imageview_poster));

        viewHolder.setText(R.id.textview_title, item.getTitle());
        viewHolder.setText(R.id.textview_year, item.getYear());
    }
}