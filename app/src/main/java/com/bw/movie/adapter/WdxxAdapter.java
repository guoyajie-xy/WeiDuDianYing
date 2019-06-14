package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.bean.WdBean;

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
public class WdxxAdapter extends RecyclerView.Adapter<WdxxAdapter.holder> {
    Context context;
    List<WdBean>list;

    public WdxxAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.wdxx_item,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        long birthday=list.get(i).birthday;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-DD");
        String day=simpleDateFormat.format(birthday);
        holder.wd_text_birthday.setText(day);
        holder.wd_text_name.setText(list.get(i).nickName);
        holder.wd_text_phone.setText(list.get(i).phone);
        Glide.with(context).load(list.get(i).headPic).apply(RequestOptions.circleCropTransform()).into(holder.wd_image_tx);
        int sex=list.get(i).sex;
        if (sex==1){
            holder.wd_text_sex.setText("男");
        }
        if (sex==2){
            holder.wd_text_sex.setText("女");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void add(WdBean data) {
        list.add(data);
    }

    public class holder extends RecyclerView.ViewHolder{

        private final ImageView wd_image_tx;
        private final TextView wd_text_birthday;
        private final TextView wd_text_name;
        private final TextView wd_text_phone;
        private final TextView wd_text_sex;

        public holder(@NonNull View itemView) {
            super(itemView);
            wd_image_tx = itemView.findViewById(R.id.wd_image_tx);
            wd_text_birthday = itemView.findViewById(R.id.wd_text_birthday);
            wd_text_name = itemView.findViewById(R.id.wd_text_name);
            wd_text_phone = itemView.findViewById(R.id.wd_text_phone);
            wd_text_sex = itemView.findViewById(R.id.wd_text_sex);
        }
    }
}
