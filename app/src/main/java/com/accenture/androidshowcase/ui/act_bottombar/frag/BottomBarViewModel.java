package com.accenture.androidshowcase.ui.act_bottombar.frag;

import com.accenture.androidshowcase.service.IService;
import com.accenture.androidshowcase.ui.base.BaseViewModel;

import javax.inject.Inject;

public class BottomBarViewModel extends BaseViewModel {

    private IService service;

    @Inject
    BottomBarViewModel(IService service) {
        this.service = service;
    }

}
