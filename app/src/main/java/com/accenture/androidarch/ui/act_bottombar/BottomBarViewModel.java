package com.accenture.androidarch.ui.act_bottombar;

import com.accenture.androidarch.service.IService;
import com.accenture.androidarch.ui.base.BaseViewModel;

import javax.inject.Inject;

public class BottomBarViewModel extends BaseViewModel {

    private IService service;

    @Inject
    BottomBarViewModel(IService service) {
        this.service = service;
    }

}
