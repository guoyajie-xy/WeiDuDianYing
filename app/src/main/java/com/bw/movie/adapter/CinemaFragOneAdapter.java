package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.CinemaOneBean;
import com.bw.movie.bean.HomeOneBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CinemaFragOneAdapter extends RecyclerView.Adapter<CinemaFragOneAdapter.MyViewHolder> {
    Context context;
    List<CinemaOneBean> mList;
    private MyViewHolder myViewHolder;

    public CinemaFragOneAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CinemaFragOneAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.cinemafragone_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaFragOneAdapter.MyViewHolder myViewHolder, int i) {
        CinemaOneBean cinemaOneBean = mList.get(i);
        String name = cinemaOneBean.getName();
        String address = cinemaOneBean.getAddress();
        int distance = cinemaOneBean.getDistance();
        String logo = cinemaOneBean.getLogo();

        myViewHolder.cinemafragone_item_simp.setImageURI(logo);
        myViewHolder.cinemafragone_item_title.setText(name);
        myViewHolder.cinemafragone_item_name.setText(address);
        myViewHolder.cinemafragone_item_kmil.setText(distance + "km");

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setCinemaData(List<CinemaOneBean> data) {
        if (data != null) {
            mList.addAll(data);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cinemafragone_item_simp)
        SimpleDraweeView cinemafragone_item_simp;
        @BindView(R.id.cinemafragone_item_title)
        TextView cinemafragone_item_title;
        @BindView(R.id.cinemafragone_item_name)
        TextView cinemafragone_item_name;
        @BindView(R.id.cinemafragone_item_kmil)
        TextView cinemafragone_item_kmil;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
