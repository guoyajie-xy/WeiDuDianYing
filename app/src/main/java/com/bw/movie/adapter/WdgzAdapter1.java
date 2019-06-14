package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.WdgzBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class WdgzAdapter1 extends RecyclerView.Adapter<WdgzAdapter1.holder> {
    Context context;
    List<WdgzBean>list;

    public WdgzAdapter1(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.wdgz_yy_item,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        holder.gz_yy_address.setText(list.get(i).address);
        holder.gz_yy_title.setText(list.get(i).name);
        Glide.with(context).load(list.get(i).logo).into(holder.gz_yy_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<WdgzBean> data) {
        list.addAll(data);
    }

    public class holder extends RecyclerView.ViewHolder{

        private final ImageView gz_yy_image;
        private final TextView gz_yy_title;
        private final TextView gz_yy_address;

        public holder(@NonNull View itemView) {
            super(itemView);
            gz_yy_image = itemView.findViewById(R.id.gz_yy_image);
            gz_yy_title = itemView.findViewById(R.id.gz_yy_title);
            gz_yy_address = itemView.findViewById(R.id.gz_yy_address);
        }
    }
}
