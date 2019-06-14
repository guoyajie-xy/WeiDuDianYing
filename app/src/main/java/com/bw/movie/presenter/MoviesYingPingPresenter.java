package com.bw.movie.presenter;

import android.widget.BaseAdapter;

import com.bw.movie.model.IRequest;
import com.bw.movie.view.DataCall;

import io.reactivex.Observable;

public class MoviesYingPingPresenter extends BasePresenter {
    public MoviesYingPingPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.yingpingshow((String) args[0]);
    }

}
