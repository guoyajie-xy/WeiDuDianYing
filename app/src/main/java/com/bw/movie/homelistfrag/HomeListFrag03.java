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
import com.bw.movie.adapter.HomeListFragThreeAdapter;
import com.bw.movie.bean.HomeThree;
import com.bw.movie.presenter.HomeThreePresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeListFrag03 extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.homelistfrag_rc3)
    RecyclerView homelistfrag_rc3;
    private HomeThreePresenter homeThreePresenter;
    private HomeListFragThreeAdapter homeListFragThreeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homelistfrag03, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //关联presenter
        homeThreePresenter = new HomeThreePresenter(new HomeFragThree());
        homeThreePresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homelistfrag_rc3.setLayoutManager(linearLayoutManager);
        //适配器
        homeListFragThreeAdapter = new HomeListFragThreeAdapter(getActivity());
        homelistfrag_rc3.setAdapter(homeListFragThreeAdapter);
    }

    class HomeFragThree implements DataCall<List<HomeThree>> {

        @Override
        public void success(List<HomeThree> data) {
            homeListFragThreeAdapter.setListDatta(data);
            homeListFragThreeAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
