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
import com.bw.movie.adapter.CinemaFragTwoAdapter;
import com.bw.movie.bean.CinemaTwoBean;
import com.bw.movie.presenter.CinemaTwoPresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CinemaFrag02 extends Fragment {
    @BindView(R.id.cinemafragone_rc2)
    RecyclerView cinemafragone_rc2;
    private Unbinder unbinder;
    private CinemaTwoPresenter cinemaTwoPresenter;
    private CinemaFragTwoAdapter cinemaFragTwoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cinemafrag02, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //关联presenter
        cinemaTwoPresenter = new CinemaTwoPresenter(new CinemaFragTwoCall());
        cinemaTwoPresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        cinemafragone_rc2.setLayoutManager(linearLayoutManager);
        //适配器
        cinemaFragTwoAdapter = new CinemaFragTwoAdapter(getActivity());
        cinemafragone_rc2.setAdapter(cinemaFragTwoAdapter);
    }

    class CinemaFragTwoCall implements DataCall<List<CinemaTwoBean>> {

        @Override
        public void success(List<CinemaTwoBean> data) {
            cinemaFragTwoAdapter.setCinemaDatt(data);
            cinemaFragTwoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
