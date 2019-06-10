package com.bw.movie.util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class OkHttpUtil {
    public static OkHttpUtil okHttpUtil;
    private final Retrofit retrofit;

    private OkHttpUtil(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://172.17.8.100/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static OkHttpUtil getIntance(){
        if (okHttpUtil==null){
            okHttpUtil=new OkHttpUtil();
        }
        return okHttpUtil;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
