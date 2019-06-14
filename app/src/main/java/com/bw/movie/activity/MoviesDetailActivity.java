package com.bw.movie.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.MoviesJuZhaoAdapter;
import com.bw.movie.adapter.MoviesYingPingAdapter;
import com.bw.movie.bean.MoviesDettailBean;
import com.bw.movie.bean.MoviesYingPingBean;
import com.bw.movie.presenter.MoviesDetailPresenter;
import com.bw.movie.presenter.MoviesYingPingPresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Auther: 郭亚杰
 * @Date:2019/6/13
 * @Description: 影片详情主页
 */
public class MoviesDetailActivity extends AppCompatActivity {

    private MoviesDetailPresenter moviesDetailPresenter;
    @BindView(R.id.moviesdetail_title)
    TextView moviesdetail_title;//标题
    @BindView(R.id.moviesdetail_image)
    ImageView moviesdetail_image;//封面
    @BindView(R.id.moviesdetail_return)
    ImageView moviesdetail_return;


    @BindView(R.id.moviesdetail_xiangqing)
    Button moviesdetail_xiangqing;//详情
    @BindView(R.id.moviesdetail_yugao)
    Button moviesdetail_yugao;//预告
    @BindView(R.id.moviesdetail_juzhao)
    Button moviesdetail_juzhao;//剧照
    @BindView(R.id.moviesdetail_yingping)
    Button moviesdetail_yingping;//影评
    @BindView(R.id.moviesdetail_buy)//购票
            Button moviesdetail_buy;

    private String imageUrl;
    private String name;
    private String movieTypes;
    private String director;
    private String placeOrigin;
    private String duration;
    private String summary;
    private int id_data;
    private MoviesYingPingAdapter moviesYingPingAdapter;
    private MoviesJuZhaoAdapter moviesJuZhaoAdapter;
    private List<String> posterList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);
        //绑定控件
        ButterKnife.bind(this);
        //获取影片id
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        //关联presenter
        moviesDetailPresenter = new MoviesDetailPresenter(new MoviesDettailCall());
        moviesDetailPresenter.requestData(id);


        //详情
        moviesdetail_xiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建View
                View view = View.inflate(MoviesDetailActivity.this, R.layout.popwindow_xiangqing, null);
                //创建popWindow( 参数  view,宽 和 高)
                final PopupWindow pop1 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //背景颜色
                pop1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //第四步 点击外部取消
                pop1.setOutsideTouchable(true);
                //第五步 展示
                pop1.showAtLocation(v, Gravity.CENTER, 0, 0);
                //点击取消
                view.findViewById(R.id.pop_xiangqing_down).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消
                        pop1.dismiss();
                    }
                });
                //电影封面
                ImageView pop_xiangqing_image = view.findViewById(R.id.pop_xiangqing_image);
                Glide.with(MoviesDetailActivity.this).load(imageUrl).into(pop_xiangqing_image);
                //电影类型
                TextView pop_xiangqing_leixing = view.findViewById(R.id.pop_xiangqing_leixing);
                pop_xiangqing_leixing.setText("类型:" + movieTypes);
                //导演
                TextView pop_xiangqing_daoyan = view.findViewById(R.id.pop_xiangqing_daoyan);
                pop_xiangqing_daoyan.setText("导演:" + director);
                //电影时长
                TextView pop_xiangqing_time = view.findViewById(R.id.pop_xiangqing_time);
                pop_xiangqing_time.setText("时长:" + duration);
                //电影产地
                TextView pop_xiangqing_address = view.findViewById(R.id.pop_xiangqing_address);
                pop_xiangqing_address.setText("产地:" + placeOrigin);
                //电影简介
                TextView pop_xiangqing_jianjie = view.findViewById(R.id.pop_xiangqing_jianjie);
                pop_xiangqing_jianjie.setText(summary);
            }
        });
        //预告
        moviesdetail_yugao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建View
                View view = View.inflate(MoviesDetailActivity.this, R.layout.popwindow_yugao, null);
                //创建popWindow( 参数  view,宽 和 高)
                final PopupWindow pop1 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //背景颜色
                pop1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //第四步 点击外部取消
                pop1.setOutsideTouchable(true);
                //第五步 展示
                pop1.showAtLocation(v, Gravity.CENTER, 0, 0);
                //点击取消
                view.findViewById(R.id.pop_yugao_down).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消
                        pop1.dismiss();
                    }
                });
            }
        });
        //剧照
        moviesdetail_juzhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建View
                View view = View.inflate(MoviesDetailActivity.this, R.layout.popwindow_juzhao, null);
                //创建popWindow( 参数  view,宽 和 高)
                final PopupWindow pop1 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //背景颜色
                pop1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //第四步 点击外部取消
                pop1.setOutsideTouchable(true);
                //第五步 展示
                pop1.showAtLocation(v, Gravity.CENTER, 0, 0);
                //点击取消
                view.findViewById(R.id.pop_jizhao_down).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消
                        pop1.dismiss();
                    }
                });

                RecyclerView pop_jizhao_rc1 = view.findViewById(R.id.pop_jizhao_rc1);
                //布局管理器
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MoviesDetailActivity.this, 2);
                pop_jizhao_rc1.setLayoutManager(gridLayoutManager);
                //适配器
                moviesJuZhaoAdapter = new MoviesJuZhaoAdapter(MoviesDetailActivity.this);
                //Log.i("xxxx", posterList.toString());
                moviesJuZhaoAdapter.getJuZhaoData(posterList);
               // moviesJuZhaoAdapter.notifyDataSetChanged();
                pop_jizhao_rc1.setAdapter(moviesJuZhaoAdapter);
            }
        });
        //影评
        moviesdetail_yingping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建View
                View view = View.inflate(MoviesDetailActivity.this, R.layout.popwindow_yingping, null);
                //创建popWindow( 参数  view,宽 和 高)
                final PopupWindow pop1 = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                //背景颜色
                pop1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //第四步 点击外部取消
                pop1.setOutsideTouchable(true);
                //第五步 展示
                pop1.showAtLocation(v, Gravity.CENTER, 0, 0);
                //点击取消
                view.findViewById(R.id.pop_yingping_down).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消
                        pop1.dismiss();
                    }
                });
                RecyclerView pop_yingping_rc = view.findViewById(R.id.pop_yingping_rc);
                //关联presenter
                MoviesYingPingPresenter moviesYingPingPresenter = new MoviesYingPingPresenter(new MoviesYingPingCall());
                moviesYingPingPresenter.requestData(id_data + "");
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MoviesDetailActivity.this);
                pop_yingping_rc.setLayoutManager(linearLayoutManager);
                //适配器
                moviesYingPingAdapter = new MoviesYingPingAdapter(MoviesDetailActivity.this);
                pop_yingping_rc.setAdapter(moviesYingPingAdapter);
            }
        });
        //返回
        moviesdetail_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(new Intent(MoviesDetailActivity.this, HomeListActivity.class));
                startActivity(intent1);
                finish();
            }
        });

        //购票
        moviesdetail_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MoviesDetailActivity.this, MoviesBuyPiaoActivity.class);
                startActivity(intent2);
            }
        });

    }


    class MoviesDettailCall implements DataCall<MoviesDettailBean> {


        @Override
        public void success(MoviesDettailBean data) {
            //电影封面
            imageUrl = data.getImageUrl();
            //电影名称
            name = data.getName();
            //电影id
            id_data = data.getId();
            //电影类型
            movieTypes = data.getMovieTypes();
            //导演
            director = data.getDirector();
            //电影时长
            duration = data.getDuration();
            //电影产地
            placeOrigin = data.getPlaceOrigin();
            //电影简介
            summary = data.getSummary();

            moviesdetail_title.setText(name);
            Glide.with(MoviesDetailActivity.this).load(imageUrl).into(moviesdetail_image);

            //剧照
            posterList = data.getPosterList();

        }
    }


    //影评
    class MoviesYingPingCall implements DataCall<List<MoviesYingPingBean>> {

        @Override
        public void success(List<MoviesYingPingBean> data) {
            moviesYingPingAdapter.setMoviesData(data);
            moviesYingPingAdapter.notifyDataSetChanged();
        }
    }

}
