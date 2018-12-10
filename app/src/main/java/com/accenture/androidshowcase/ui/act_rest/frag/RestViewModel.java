package com.accenture.androidshowcase.ui.act_rest.frag;

import com.accenture.androidshowcase.service.movie.IMovieService;
import com.accenture.androidshowcase.ui.base.BaseViewModel;

import javax.inject.Inject;

public class RestViewModel extends BaseViewModel {

    private IMovieService movieService;

    @Inject
    RestViewModel(IMovieService movieService) {
        this.movieService = movieService;
    }

}
