package com.bw.movie.Wdgzfragment;

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
import com.bw.movie.adapter.WdgzAdapter2;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WdgzBean2;
import com.bw.movie.dao.DaoMaster;
import com.bw.movie.dao.LoginBeanDao;
import com.bw.movie.presenter.WdgzPresenter2;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class DyFragment extends Fragment implements DataCall<List<WdgzBean2>> {
    @BindView(R.id.dy_recycler_view)
    RecyclerView dyRecyclerView;
    Unbinder unbinder;
    private WdgzAdapter2 wdgzAdapter2;
    long userId=13039;
    LoginBean loginBean;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dy_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        loginBean=DaoMaster.newDevSession(getContext(),LoginBeanDao.TABLENAME).getLoginBeanDao().loadAll().get(0);
        WdgzPresenter2 wdgzPresenter2=new WdgzPresenter2(this);
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dyRecyclerView.setLayoutManager(layoutManager);
        //创建适配器
        wdgzAdapter2 = new WdgzAdapter2(getContext());
        dyRecyclerView.setAdapter(wdgzAdapter2);
        wdgzPresenter2.requestData(userId,loginBean.getSessionId(),"1","5");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(List<WdgzBean2> data) {
        wdgzAdapter2.addAll(data);
        wdgzAdapter2.notifyDataSetChanged();
    }
}
