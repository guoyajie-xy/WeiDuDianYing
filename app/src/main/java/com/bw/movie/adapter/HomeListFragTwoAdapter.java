package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.HomeOneBean;
import com.bw.movie.bean.HomeTwoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeListFragTwoAdapter extends RecyclerView.Adapter<HomeListFragTwoAdapter.MyViewHolder> {
    Context context;
    List<HomeTwoBean> mList;
    private MyViewHolder myViewHolder;

    public HomeListFragTwoAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public HomeListFragTwoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.homelisttwo_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListFragTwoAdapter.MyViewHolder myViewHolder, int i) {
        HomeTwoBean homeTwoBean = mList.get(i);
        String imageUrl = homeTwoBean.getImageUrl();
        String name = homeTwoBean.getName();
        String summary = homeTwoBean.getSummary();

        myViewHolder.homelistfrag_image.setImageURI(imageUrl);
        myViewHolder.homelistfrag_title.setText(name);
        myViewHolder.homelistfrag_summary.setText("简介：" + summary);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setListDatt(List<HomeTwoBean> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.homelistfrag_simp_image2)
        SimpleDraweeView homelistfrag_image;
        @BindView(R.id.homelistfrag_title2)
        TextView homelistfrag_title;
        @BindView(R.id.homelistfrag_summary2)
        TextView homelistfrag_summary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
