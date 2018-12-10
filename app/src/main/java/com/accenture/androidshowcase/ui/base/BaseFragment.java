package com.accenture.androidshowcase.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.accenture.androidshowcase.viewmodel.ViewModelFactory;
import com.blankj.utilcode.util.LogUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<V extends ViewDataBinding, M extends BaseViewModel>
        extends DaggerFragment {

    @Inject
    ViewModelFactory viewModelFactory;

    private V binding;
    private M viewModel;

    private List<LiveData> observedDataList;

    public abstract int layoutRes();

    public abstract Class<M> viewModelClass();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LogUtils.d("onCreateView()", getClass().getSimpleName());
        binding = DataBindingUtil.inflate(
                inflater, layoutRes(), container, false);

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(viewModelClass());

        observedDataList = new ArrayList<>();

        getLifecycle().addObserver(viewModel);
        return binding.getRoot();
    }

    public V getBinding() {
        return binding;
    }

    public M getViewModel() {
        return viewModel;
    }

    public <D> void observe(LiveData<D> liveData, Observer<D> observer) {
        observedDataList.add(liveData);
        liveData.observe(this, observer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.d("onDestroyView()", getClass().getSimpleName());

        stopObservingData();
        getLifecycle().removeObserver(viewModel);
        binding.unbind();
        binding = null;
    }

    private void stopObservingData() {
        Iterator<LiveData> iterator = observedDataList.iterator();
        while (iterator.hasNext()) {
            LiveData liveData = iterator.next();
            liveData.removeObservers(this);
            iterator.remove();
        }
        observedDataList = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d("onStart()", getClass().getSimpleName());
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d("onStop()", getClass().getSimpleName());
    }
}
