package com.bw.movie.presenter;

import com.bw.movie.model.IRequest;
import com.bw.movie.view.DataCall;

import io.reactivex.Observable;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class WdgzPresenter extends BasePresenter{
    public WdgzPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.findCinemaPageList((String)args[0],(String)args[1],(String)args[2],(String)args[3]);
    }
}
