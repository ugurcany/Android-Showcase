package mobi.mergen.androidshowcase.ui.act_multicounter;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;
import mobi.mergen.androidshowcase.databinding.ActivityMultiCounterBinding;

public class MultiCounterActivity extends BaseActivity<ActivityMultiCounterBinding> {

    @Inject
    IMultiCounterNav fragNavController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNavController.init(savedInstanceState, getBinding().bottombar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragNavController.clear();
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_multi_counter;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        fragNavController.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (!fragNavController.onBackPressed()) {
            super.onBackPressed();
        }
    }
}