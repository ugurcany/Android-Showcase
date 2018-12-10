package com.accenture.androidshowcase.ui.base;

import android.os.Bundle;
import android.os.Handler;

import com.accenture.androidshowcase.R;
import com.accenture.androidshowcase.common.Navigator;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<V extends ViewDataBinding>
        extends DaggerAppCompatActivity {

    private boolean backToExitClickedOnce = false;

    private V binding;

    public abstract int layoutRes();

    public abstract boolean doubleClickToExitEnabled();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("onCreate()", getClass().getSimpleName());

        binding = DataBindingUtil.setContentView(this, layoutRes());
    }

    public V getBinding() {
        return binding;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("onDestroy()", getClass().getSimpleName());

        binding.unbind();
        binding = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("onStart()", getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("onStop()", getClass().getSimpleName());
    }

    @Override
    public void onBackPressed() {
        if (!doubleClickToExitEnabled() || backToExitClickedOnce) {
            ToastUtils.cancel();
            Navigator.finish(this);
            return;
        }

        backToExitClickedOnce = true;
        ToastUtils.showShort(R.string.text_click_back_again);

        new Handler().postDelayed(() -> backToExitClickedOnce = false,
                2000);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
