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
import com.bw.movie.adapter.WdgzAdapter1;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WdgzBean;
import com.bw.movie.dao.DaoMaster;
import com.bw.movie.dao.LoginBeanDao;
import com.bw.movie.presenter.WdgzPresenter;
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
public class YyFragment extends Fragment implements DataCall<List<WdgzBean>> {
    @BindView(R.id.yy_recycler_view)
    RecyclerView yyRecyclerView;
    Unbinder unbinder;
    private WdgzAdapter1 wdgzAdapter1;
    private WdgzPresenter wdgzPresenter;
    LoginBean loginBean;
    private long userId=13039;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yy_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        loginBean=DaoMaster.newDevSession(getContext(),LoginBeanDao.TABLENAME).getLoginBeanDao().loadAll().get(0);
        wdgzPresenter = new WdgzPresenter(this);
        //获取布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        yyRecyclerView.setLayoutManager(layoutManager);
        //创建适配器
        wdgzAdapter1 = new WdgzAdapter1(getContext());
        yyRecyclerView.setAdapter(wdgzAdapter1);
        wdgzPresenter.requestData(userId,loginBean.getSessionId(),"1","5");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void success(List<WdgzBean> data) {
        wdgzAdapter1.addAll(data);
        wdgzAdapter1.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
