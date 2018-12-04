package com.accenture.androidarch;

import android.view.Gravity;

import com.accenture.androidarch.di.DaggerAppComponent;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.evernote.android.state.StateSaver;
import com.squareup.leakcanary.LeakCanary;

import androidx.core.content.ContextCompat;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class TheApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        StateSaver.setEnabledForAllActivitiesAndSupportFragments(this, true);
        initUtils();
    }

    private void initUtils() {
        Utils.init(this);
        ToastUtils.setBgColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        ToastUtils.setMsgColor(ContextCompat.getColor(this, R.color.colorLight));
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
    }

    @Override
    protected AndroidInjector<TheApp> applicationInjector() {
        return DaggerAppComponent.builder()
                .app(this)
                .build();
    }
}
