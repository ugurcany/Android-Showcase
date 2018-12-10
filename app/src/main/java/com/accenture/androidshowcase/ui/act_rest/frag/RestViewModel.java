package com.accenture.androidshowcase.ui.act_rest.frag;

import com.accenture.androidshowcase.service.IService;
import com.accenture.androidshowcase.ui.base.BaseViewModel;

import javax.inject.Inject;

public class RestViewModel extends BaseViewModel {

    private IService service;

    @Inject
    RestViewModel(IService service) {
        this.service = service;
    }

}
