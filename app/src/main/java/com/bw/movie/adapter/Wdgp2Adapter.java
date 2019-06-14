package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
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
public class Wdgp2Adapter extends RecyclerView.Adapter<Wdgp2Adapter.holder> {
    Context context;
    List<WdgpBean> list;

    public Wdgp2Adapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.wdgp_ywc_item,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        holder.gp_ywc_start_time.setText(list.get(i).beginTime);
        holder.gp_ywc_end_time.setText(list.get(i).endTime);
        holder.gp_ywc_ddh.setText(list.get(i).orderId);
        String time=list.get(i).createTime;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-DD HH-mm");
        String sj=simpleDateFormat.format(time);
        holder.gp_ywc_time.setText(sj);
        holder.gp_ywc_yy.setText(list.get(i).cinemaName);
        holder.gp_ywc_yt.setText(list.get(i).screeningHall);
        holder.gp_ywc_num.setText(list.get(i).amount);
        holder.gp_ywc_money.setText(list.get(i).price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<WdgpBean> data) {
        list.addAll(data);
    }

    public class holder extends RecyclerView.ViewHolder{

        private final TextView gp_ywc_start_time;
        private final TextView gp_ywc_end_time;
        private final TextView gp_ywc_ddh;
        private final TextView gp_ywc_time;
        private final TextView gp_ywc_yy;
        private final TextView gp_ywc_yt;
        private final TextView gp_ywc_num;
        private final TextView gp_ywc_money;

        public holder(@NonNull View itemView) {
            super(itemView);
            gp_ywc_start_time = itemView.findViewById(R.id.gp_ywc_start_time);
            gp_ywc_end_time = itemView.findViewById(R.id.gp_ywc_end_time);
            gp_ywc_ddh = itemView.findViewById(R.id.gp_ywc_ddh);
            gp_ywc_time = itemView.findViewById(R.id.gp_ywc_time);
            gp_ywc_yy = itemView.findViewById(R.id.gp_ywc_yy);
            gp_ywc_yt = itemView.findViewById(R.id.gp_ywc_yt);
            gp_ywc_num = itemView.findViewById(R.id.gp_ywc_num);
            gp_ywc_money = itemView.findViewById(R.id.gp_ywc_money);
        }
    }
}
