package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder{

        public holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
