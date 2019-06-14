package com.bw.movie.presenter;

import android.net.Uri;

import com.bw.movie.model.IRequest;
import com.bw.movie.view.DataCall;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class SctxPresenter extends BasePresenter{
    public SctxPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        File arg= (File) args[2];
        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("image",arg.getName(),RequestBody.create(MediaType.parse("multipart/octet-stream"),arg));
        return iRequest.uploadHeadPic((String)args[0],(String)args[1],builder.build());
    }
}
