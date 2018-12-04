package com.accenture.androidarch.ui.base;

import com.blankj.utilcode.util.LogUtils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel
        implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStarted() {
        LogUtils.d("onStarted()", getClass().getSimpleName());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopped() {
        LogUtils.d("onStopped()", getClass().getSimpleName());
    }

    @Override
    protected void onCleared() {
        LogUtils.d("onCleared()", getClass().getSimpleName());
    }

}
