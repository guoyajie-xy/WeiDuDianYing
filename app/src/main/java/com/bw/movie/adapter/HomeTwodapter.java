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
import com.bw.movie.bean.HomeTwoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTwodapter extends RecyclerView.Adapter<HomeTwodapter.MyViewHolder> {
    Context context;
    List<HomeTwoBean> mList;
    private MyViewHolder myViewHolder;

    public HomeTwodapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public HomeTwodapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.hometwo_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeTwodapter.MyViewHolder myViewHolder, int i) {
        HomeTwoBean homeTwoBean = mList.get(i);
        String imageUrl = homeTwoBean.getImageUrl();
        String name = homeTwoBean.getName();

        myViewHolder.hometwo_simp_image.setImageURI(imageUrl);
        myViewHolder.hometwo_text_name.setText(name);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeListActivity.class);
                context.startActivity(intent);
                call.itemClick();
            }
        });
    }

    public Call call;

    public void setCall(Call call) {
        this.call = call;
    }

    public interface Call {
        void itemClick();
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setDatat(List<HomeTwoBean> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hometwo_simp_image)
        SimpleDraweeView hometwo_simp_image;
        @BindView(R.id.hometwo_text_name)
        TextView hometwo_text_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
