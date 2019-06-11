package com.bw.movie.homelistfrag;

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
import com.bw.movie.adapter.HomeListFragOneAdapter;
import com.bw.movie.bean.HomeOneBean;
import com.bw.movie.presenter.HomeOnePresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeListFrag01 extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.homelistfrag_rc1)
    RecyclerView homelistfrag_rc1;
    private HomeListFragOneAdapter homeListFragOneAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homelistfrag01, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //关联presenter
        HomeOnePresenter homeOnePresenter = new HomeOnePresenter(new HomeFragOne());
        homeOnePresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homelistfrag_rc1.setLayoutManager(linearLayoutManager);
        //适配器
        homeListFragOneAdapter = new HomeListFragOneAdapter(getActivity());
        homelistfrag_rc1.setAdapter(homeListFragOneAdapter);
    }

    class HomeFragOne implements DataCall<List<HomeOneBean>> {

        @Override
        public void success(List<HomeOneBean> data) {
         homeListFragOneAdapter.setListData(data);
         homeListFragOneAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
