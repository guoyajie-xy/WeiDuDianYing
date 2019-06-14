package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesJuZhaoAdapter extends RecyclerView.Adapter<MoviesJuZhaoAdapter.MyViewHolder> {
    Context context;
    List<String> mList = new ArrayList<>();

    private MyViewHolder myViewHolder;

    public MoviesJuZhaoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MoviesJuZhaoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.movies_juzhao_item, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesJuZhaoAdapter.MyViewHolder myViewHolder, int i) {
        String s = mList.get(i);
        Glide.with(context).load(s).into(myViewHolder.pop_jizhao_image);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void getJuZhaoData(List<String> posterList) {
        mList.addAll(posterList);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pop_jizhao_image)
        ImageView pop_jizhao_image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
