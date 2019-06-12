package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.CinemaOneBean;
import com.bw.movie.bean.CinemaTwoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CinemaFragTwoAdapter extends RecyclerView.Adapter<CinemaFragTwoAdapter.MyViewHolder> {
    Context context;
    List<CinemaTwoBean> mList;
    private MyViewHolder myViewHolder;

    public CinemaFragTwoAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CinemaFragTwoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.cinemafragtwo_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaFragTwoAdapter.MyViewHolder myViewHolder, int i) {
        CinemaTwoBean cinemaTwoBean = mList.get(i);
        String name = cinemaTwoBean.getName();
        String address = cinemaTwoBean.getAddress();
        int distance = cinemaTwoBean.getDistance();
        String logo = cinemaTwoBean.getLogo();

        myViewHolder.cinemafragone_item_simp.setImageURI(logo);
        myViewHolder.cinemafragone_item_title.setText(name);
        myViewHolder.cinemafragone_item_name.setText(address);
        myViewHolder.cinemafragone_item_kmil.setText(distance + "km");

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setCinemaDatt(List<CinemaTwoBean> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cinemafragone_item_simp2)
        SimpleDraweeView cinemafragone_item_simp;
        @BindView(R.id.cinemafragone_item_title2)
        TextView cinemafragone_item_title;
        @BindView(R.id.cinemafragone_item_name2)
        TextView cinemafragone_item_name;
        @BindView(R.id.cinemafragone_item_kmil2)
        TextView cinemafragone_item_kmil;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
