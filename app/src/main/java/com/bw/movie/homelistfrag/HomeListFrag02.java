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
import com.bw.movie.adapter.HomeListFragTwoAdapter;
import com.bw.movie.bean.HomeTwoBean;
import com.bw.movie.presenter.HomeTwoPresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeListFrag02 extends Fragment {
    private Unbinder unbinder;
    private HomeTwoPresenter homeTwoPresenter;

    @BindView(R.id.homelistfrag_rc2)
    RecyclerView homelistfrag_rc2;
    private HomeListFragTwoAdapter homeListFragTwoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homelistfrag02, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //关联presenter
        homeTwoPresenter = new HomeTwoPresenter(new HomeFragTwo());
        homeTwoPresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homelistfrag_rc2.setLayoutManager(linearLayoutManager);
        //适配器
        homeListFragTwoAdapter = new HomeListFragTwoAdapter(getActivity());
        homelistfrag_rc2.setAdapter(homeListFragTwoAdapter);
    }

    class HomeFragTwo implements DataCall<List<HomeTwoBean>> {

        @Override
        public void success(List<HomeTwoBean> data) {
            homeListFragTwoAdapter.setListDatt(data);
            homeListFragTwoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
