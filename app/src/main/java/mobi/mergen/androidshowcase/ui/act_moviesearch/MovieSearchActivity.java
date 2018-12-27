package mobi.mergen.androidshowcase.ui.act_moviesearch;

import android.os.Bundle;

import com.blankj.utilcode.util.FragmentUtils;

import androidx.annotation.Nullable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.ui.act_moviesearch.frag.MovieSearchFragment;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;
import mobi.mergen.androidshowcase.databinding.ActivityMovieSearchBinding;

public class MovieSearchActivity extends BaseActivity<ActivityMovieSearchBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentUtils.replace(getSupportFragmentManager(),
                    MovieSearchFragment.initialize(),
                    R.id.container_fragment);
        }
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