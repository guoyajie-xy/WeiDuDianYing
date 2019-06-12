package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.XtxxBean;

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
public class XtxxAdapter extends RecyclerView.Adapter<XtxxAdapter.holder> {
    Context context;
    List<XtxxBean>list;

    public XtxxAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.xtxx_item,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        long time=list.get(i).pushTime;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
        String day=simpleDateFormat.format(time);
        holder.xtxx_text_time.setText(day);
        holder.xtxx_text_title.setText(list.get(i).content);
        holder.xtxx_text_xx.setText(list.get(i).title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(List<XtxxBean> data) {
        list.addAll(data);
    }

    public class holder extends RecyclerView.ViewHolder{

        private final TextView xtxx_text_xx;
        private final TextView xtxx_text_time;
        private final TextView xtxx_text_title;

        public holder(@NonNull View itemView) {
            super(itemView);
            xtxx_text_xx = itemView.findViewById(R.id.Xtxx_text_xx);
            xtxx_text_time = itemView.findViewById(R.id.Xtxx_text_time);
            xtxx_text_title = itemView.findViewById(R.id.Xtxx_text_title);
        }
    }
}
