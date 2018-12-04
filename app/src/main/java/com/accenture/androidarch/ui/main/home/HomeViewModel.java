package com.accenture.androidarch.ui.main.home;

import com.accenture.androidarch.service.IService;
import com.accenture.androidarch.ui.base.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class HomeViewModel extends BaseViewModel {

    private IService service;

    private final MutableLiveData<String> userName = new MutableLiveData<>();
    private final MutableLiveData<SignInState> signInState = new MutableLiveData<>();
    private final MutableLiveData<Integer> movieCount = new MutableLiveData<>();

    @Inject
    HomeViewModel(IService service) {
        this.service = service;

        userName.setValue("");
        signInState.setValue(SignInState.ACTIVE);
        movieCount.setValue(0);
    }

    MutableLiveData<String> getUserName() {
        return userName;
    }

    MutableLiveData<SignInState> getSignInState() {
        return signInState;
    }

    MutableLiveData<Integer> getMovieCount() {
        return movieCount;
    }

}
