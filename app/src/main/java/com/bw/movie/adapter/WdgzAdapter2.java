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
import com.bw.movie.bean.WdgzBean2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class WdgzAdapter2 extends RecyclerView.Adapter<WdgzAdapter2.holder> {
    Context context;
    List<WdgzBean2>list;

    public WdgzAdapter2(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.gz_dy_item,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {



        holder.gz_dy_content.setText("简介:"+list.get(i).summary);
        holder.gz_dy_title.setText(list.get(i).name);
        long data=list.get(i).releaseTime;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-DD");
        String sj=simpleDateFormat.format(data);
        holder.gz_dy_data.setText(sj);
        Glide.with(context).load(list.get(i).imageUrl).into(holder.gz_dy_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<WdgzBean2> data) {
        list.addAll(data);
    }

    public class holder extends RecyclerView.ViewHolder{

        private final ImageView gz_dy_image;
        private final TextView gz_dy_content;
        private final TextView gz_dy_data;
        private final TextView gz_dy_title;

        public holder(@NonNull View itemView) {
            super(itemView);
            gz_dy_image = itemView.findViewById(R.id.gz_dy_image);
            gz_dy_content = itemView.findViewById(R.id.gz_dy_content);
            gz_dy_data = itemView.findViewById(R.id.gz_dy_data);
            gz_dy_title = itemView.findViewById(R.id.gz_dy_title);
        }
    }
}
