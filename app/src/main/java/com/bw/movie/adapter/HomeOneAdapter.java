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

public class HomeOneAdapter extends RecyclerView.Adapter<HomeOneAdapter.MyViewHolder> {
    Context context;
    List<HomeOneBean> mList;
    private MyViewHolder myViewHolder;

    public HomeOneAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public HomeOneAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.homeone_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeOneAdapter.MyViewHolder myViewHolder, int i) {
        HomeOneBean homeOneBean = mList.get(i);
        String imageUrl = homeOneBean.getImageUrl();
        String name = homeOneBean.getName();

        myViewHolder.homeone_simp_image.setImageURI(imageUrl);
        myViewHolder.homeone_text_name.setText(name);

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

    public void setData(List<HomeOneBean> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.homeone_simp_image)
        SimpleDraweeView homeone_simp_image;
        @BindView(R.id.homeone_text_name)
        TextView homeone_text_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
