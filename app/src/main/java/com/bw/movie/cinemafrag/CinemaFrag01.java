package com.bw.movie.cinemafrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.CinemaFragOneAdapter;
import com.bw.movie.bean.CinemaOneBean;
import com.bw.movie.presenter.CinemaOnePresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CinemaFrag01 extends Fragment {
    @BindView(R.id.cinemafragone_rc1)
    RecyclerView cinemafragone_rc1;

    private Unbinder unbinder;
    private CinemaOnePresenter cinemaOnePresenter;
    private CinemaFragOneAdapter cinemaFragOneAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cinemafrag01, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //关联presenter
        cinemaOnePresenter = new CinemaOnePresenter(new CinemaFragOneCall());
        cinemaOnePresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        cinemafragone_rc1.setLayoutManager(linearLayoutManager);
        //适配器
        cinemaFragOneAdapter = new CinemaFragOneAdapter(getActivity());
        cinemafragone_rc1.setAdapter(cinemaFragOneAdapter);
    }
    class CinemaFragOneCall implements DataCall<List<CinemaOneBean>>{

        @Override
        public void success(List<CinemaOneBean> data) {
            cinemaFragOneAdapter.setCinemaData(data);
            cinemaFragOneAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
