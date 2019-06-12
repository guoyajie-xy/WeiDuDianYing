package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.HomeOneBean;
import com.bw.movie.bean.HomeThree;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeListFragThreeAdapter extends RecyclerView.Adapter<HomeListFragThreeAdapter.MyViewHolder> {
    Context context;
    List<HomeThree> mList;
    private MyViewHolder myViewHolder;

    public HomeListFragThreeAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public HomeListFragThreeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.homelistthree_item_layout, null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListFragThreeAdapter.MyViewHolder myViewHolder, int i) {
        HomeThree homeThree = mList.get(i);
        String imageUrl = homeThree.getImageUrl();
        String name = homeThree.getName();
        String summary = homeThree.getSummary();

        myViewHolder.homelistfrag_image.setImageURI(imageUrl);
        myViewHolder.homelistfrag_title.setText(name);
        myViewHolder.homelistfrag_summary.setText("简介：" + summary);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setListDatta(List<HomeThree> data) {
        if (data!=null){
            mList.addAll(data);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.homelistfrag_simp_image3)
        SimpleDraweeView homelistfrag_image;
        @BindView(R.id.homelistfrag_title3)
        TextView homelistfrag_title;
        @BindView(R.id.homelistfrag_summary3)
        TextView homelistfrag_summary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
