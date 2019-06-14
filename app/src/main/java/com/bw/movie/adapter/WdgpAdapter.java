package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.WdgpBean;

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
public class WdgpAdapter extends RecyclerView.Adapter<WdgpAdapter.holder> {
    Context context;
    List<WdgpBean>list;

    public WdgpAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.wdgp_dfk_item,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        holder.gp_name.setText(list.get(i).movieName);
        holder.gp_ddh.setText(list.get(i).orderId);
        holder.gp_yy.setText(list.get(i).cinemaName);
        holder.gp_yt.setText(list.get(i).screeningHall);
        String start=list.get(i).beginTime;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-DD HH-mm");
        String sj=simpleDateFormat.format(start);
        holder.gp_start_time.setText(sj);
        String end=list.get(i).endTime;
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("HH-mm");
        String sj1=simpleDateFormat1.format(end);
        holder.gp_end_time.setText(sj1);
        holder.gp_num.setText(list.get(i).amount);
        holder.gp_money.setText(list.get(i).price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<WdgpBean> data) {
        list.addAll(data);
    }

    public class holder extends RecyclerView.ViewHolder{

        private final TextView gp_name;
        private final Button gp_btn_qfk;
        private final TextView gp_ddh;
        private final TextView gp_yy;
        private final TextView gp_yt;
        private final TextView gp_start_time;
        private final TextView gp_num;
        private final TextView gp_money;
        private final TextView gp_end_time;

        public holder(@NonNull View itemView) {
            super(itemView);
            gp_name = itemView.findViewById(R.id.gp_name);
            gp_btn_qfk = itemView.findViewById(R.id.gp_btn_qfk);
            gp_ddh = itemView.findViewById(R.id.gp_ddh);
            gp_yy = itemView.findViewById(R.id.gp_yy);
            gp_yt = itemView.findViewById(R.id.gp_yt);
            gp_start_time = itemView.findViewById(R.id.gp_start_time);
            gp_end_time = itemView.findViewById(R.id.gp_end_time);
            gp_num = itemView.findViewById(R.id.gp_num);
            gp_money = itemView.findViewById(R.id.gp_money);
        }
    }
}
