package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.HomeListActivity;
import com.bw.movie.bean.HomeOneBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeListFragOneAdapter extends RecyclerView.Adapter<HomeListFragOneAdapter.MyViewHolder> {
    Context context;
    List<HomeOneBean> mList;
    private MyViewHolder myViewHolder;

    public HomeListFragOneAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public HomeListFragOneAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.homelistone_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListFragOneAdapter.MyViewHolder myViewHolder, int i) {
        HomeOneBean homeOneBean = mList.get(i);
        String imageUrl = homeOneBean.getImageUrl();
        String name = homeOneBean.getName();
        String summary = homeOneBean.getSummary();

        myViewHolder.homelistfrag_image.setImageURI(imageUrl);
        myViewHolder.homelistfrag_title.setText(name);
        myViewHolder.homelistfrag_summary.setText("简介：" + summary);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setListData(List<HomeOneBean> data) {
        if (data != null) {
            mList.addAll(data);
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.homelistfrag_simp_image)
        SimpleDraweeView homelistfrag_image;
        @BindView(R.id.homelistfrag_title)
        TextView homelistfrag_title;
        @BindView(R.id.homelistfrag_summary)
        TextView homelistfrag_summary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
