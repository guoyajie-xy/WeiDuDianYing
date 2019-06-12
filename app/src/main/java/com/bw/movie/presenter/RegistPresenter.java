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
public class RegistPresenter extends BasePresenter{
    public RegistPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.registerUser((String)args[0],(int)args[1],(String)args[2],(String)args[3],(String)args[4],(String)args[5],(String)args[6]);
    }
}
