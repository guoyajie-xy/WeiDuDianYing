package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.MoviesDetailActivity;
import com.bw.movie.bean.HomeOneBean;
import com.bw.movie.bean.MoviesYingPingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesYingPingAdapter extends RecyclerView.Adapter<MoviesYingPingAdapter.MyViewHolder> {
    Context context;
    List<MoviesYingPingBean> mList;
    private MyViewHolder myViewHolder;

    public MoviesYingPingAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MoviesYingPingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.movies_yingping_item, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesYingPingAdapter.MyViewHolder myViewHolder, int i) {
        MoviesYingPingBean moviesYingPingBean = mList.get(i);
        String commentUserName = moviesYingPingBean.getCommentUserName();
        String commentHeadPic = moviesYingPingBean.getCommentHeadPic();
        long commentTime = moviesYingPingBean.getCommentTime();
        String commentContent = moviesYingPingBean.getCommentContent();

        myViewHolder.pop_yingping_name.setText(commentUserName);
        myViewHolder.pop_yingping_pinglun.setText(commentContent);
        myViewHolder.pop_yingping_touxiang.setImageURI(commentHeadPic);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-DD HH:mm");
        String format = simpleDateFormat.format(new Date(commentTime));
        myViewHolder.pop_yingping_time.setText(format + "");
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setMoviesData(List<MoviesYingPingBean> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pop_yingping_touxiang)
        SimpleDraweeView pop_yingping_touxiang;
        @BindView(R.id.pop_yingping_name)
        TextView pop_yingping_name;
        @BindView(R.id.pop_yingping_pinglun)
        TextView pop_yingping_pinglun;
        @BindView(R.id.pop_yingping_time)
        TextView pop_yingping_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
