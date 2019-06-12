package com.bw.movie.presenter;

import com.bw.movie.model.IRequest;
import com.bw.movie.view.DataCall;
import io.reactivex.Observable;

public class CinemaTwoPresenter extends BasePresenter {
    public CinemaTwoPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.cinematwoshow();
    }
}
