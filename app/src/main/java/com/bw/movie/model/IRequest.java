package com.bw.movie.model;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegistBean;
import com.bw.movie.bean.Result;
import com.bw.movie.bean.UserInfo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public interface IRequest {
    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v1/registerUser")
    Observable<Result<RegistBean>> registerUser(@Field("nickName")String nickName,
                                                @Field("sex")String sex,
                                                @Field("birthday")String birthday,
                                                @Field("phone")String phone,
                                                @Field("email")String email,
                                                @Field("pwd")String pwd,
                                                @Field("pwd2")String pwd2);
    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v1/login")
    Observable<Result<LoginBean>> login(@Field("phone") String phone,
                                                  @Field("pwd") String pwd);
}
