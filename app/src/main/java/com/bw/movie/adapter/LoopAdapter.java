package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//旋转木马适配器
public class LoopAdapter extends RecyclerView.Adapter<LoopAdapter.MyViewHolder> implements View.OnClickListener {
    private Context context;
    private int img[];
    private MyViewHolder myViewHolder;

    public LoopAdapter(Context context, int[] img) {
        this.context = context;
        this.img = img;
    }

    @NonNull
    @Override
    public LoopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.loopadapter_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LoopAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.itemView.setTag(i);
        Glide.with(context).load(img[i]).into(myViewHolder.simp_image);
    }

    @Override
    public void onClick(View v) {
        if (onItemClick != null) {
            onItemClick.onItemClick(v, (int) v.getTag());
        }
    }


    public interface OnItemClick {
        void onItemClick(View view, int position);
    }

    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    @Override
    public int getItemCount() {
        return img.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simp_cinema_flow)
        ImageView simp_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
