package com.bw.movie.model;

import com.bw.movie.bean.CinemaOneBean;
import com.bw.movie.bean.CinemaTwoBean;
import com.bw.movie.bean.HomeOneBean;
import com.bw.movie.bean.HomeThree;
import com.bw.movie.bean.HomeTwoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegistBean;
import com.bw.movie.bean.Result;
import com.bw.movie.bean.SctxBean;
import com.bw.movie.bean.WdBean;
import com.bw.movie.bean.WdgpBean;
import com.bw.movie.bean.WdgzBean;
import com.bw.movie.bean.WdgzBean2;
import com.bw.movie.bean.XtxxBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
                                                @Field("sex")int sex,
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

    //系统消息(我的)
    @GET("movieApi/tool/v1/verify/findAllSysMsgList")
    Observable<Result<List<XtxxBean>>> findAllSysMsgList(@Header("userId") long userId,
                                                         @Header("sessionId") String sessionId,
                                                         @Query("page")String page,
                                                         @Query("count")String count);

    //影片--热门电影
    @GET("movieApi/movie/v1/findHotMovieList?page=1&count=10")
    Observable<Result<List<HomeOneBean>>> homeone();

    //影片--正在热映
    @GET("movieApi/movie/v1/findReleaseMovieList?page=1&count=10")
    Observable<Result<List<HomeTwoBean>>> hometwo();


    //影片--即将上映
    @GET("movieApi/movie/v1/findComingSoonMovieList?page=1&count=10")
    Observable<Result<List<HomeThree>>> homethree();

    //我的信息
    @GET("movieApi/user/v1/verify/getUserInfoByUserId")
    Observable<Result<WdBean>> getUserInfoByUserId(@Header("userId")long userId,
                                                   @Header("sessionId")String sessionId);

    //影院--推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas?page=1&count=10")
    Observable<Result<List<CinemaOneBean>>> cinemaoneshow();

    //影院--附近影院
    @GET("movieApi/cinema/v1/findNearbyCinemas?page=1&count=10")
    Observable<Result<List<CinemaTwoBean>>> cinematwoshow();
    //上传头像(我的)
    @POST("movieApi/user/v1/verify/uploadHeadPic")
    Observable<Result<SctxBean>> uploadHeadPic(@Header("userId")String userId,
                                               @Header("sessionId")String sessionId,
                                               @Body MultipartBody body);
    //我的购票(我的)
    @GET("movieApi/user/v1/verify/findUserBuyTicketRecordList")
    Observable<Result<List<WdgpBean>>> findUserBuyTicketRecordList(@Header("userId")int userId,
                                                                   @Header("sessionId")String sessionId,
                                                                   @Query("page")String page,
                                                                   @Query("count")String count,
                                                                   @Query("status")String status);
    //我的关注(影院关注)
    @GET("movieApi/cinema/v1/verify/findCinemaPageList")
    Observable<Result<List<WdgzBean>>> findCinemaPageList(@Header("userId")long userId,
                                                          @Header("sessionId") String sessionId,
                                                          @Query("page")String page,
                                                          @Query("count")String count);
    //我的关注(电影关注)
    @GET("movieApi/movie/v1/verify/findMoviePageList")
    Observable<Result<List<WdgzBean2>>> findMoviePageList(@Header("userId")long userId,
                                                          @Header("sessionId")String sessionId,
                                                          @Query("page")String page,
                                                          @Query("count")String count);
}
