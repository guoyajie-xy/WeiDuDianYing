package com.bw.movie.presenter;

import com.bw.movie.bean.Result;
import com.bw.movie.model.IRequest;
import com.bw.movie.util.OkHttpUtil;
import com.bw.movie.view.DataCall;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public abstract class BasePresenter {
    DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    public void requestData(Object...args){
        IRequest iRequest=OkHttpUtil.getIntance().getRetrofit().create(IRequest.class);
        getModel(iRequest,args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result o) throws Exception {
                        if (o.status.equals("0000")){
                            dataCall.success(o.result);
                        }
                    }
                });
    }
    protected abstract Observable getModel(IRequest iRequest,Object...args);
}
