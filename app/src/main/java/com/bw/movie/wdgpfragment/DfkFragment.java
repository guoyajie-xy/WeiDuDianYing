package com.bw.movie.wdgpfragment;

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
import com.bw.movie.adapter.WdgpAdapter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WdgpBean;
import com.bw.movie.dao.DaoMaster;
import com.bw.movie.dao.LoginBeanDao;
import com.bw.movie.presenter.WdgpPresenter;
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
public class DfkFragment extends Fragment implements DataCall<List<WdgpBean>> {
    @BindView(R.id.dfk_recycler_view)
    RecyclerView dfkRecyclerView;
    Unbinder unbinder;
    private WdgpAdapter wdgpAdapter;
    LoginBean loginBean;
    private int userId=13039;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dfk_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        loginBean=DaoMaster.newDevSession(getActivity(),LoginBeanDao.TABLENAME).getLoginBeanDao().loadAll().get(0);
        //获取布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dfkRecyclerView.setLayoutManager(layoutManager);
        //创建适配器
        wdgpAdapter = new WdgpAdapter(getContext());
        dfkRecyclerView.setAdapter(wdgpAdapter);
        WdgpPresenter wdgpPresenter=new WdgpPresenter(this);
        wdgpPresenter.requestData(userId,loginBean.getSessionId(),"1","5","1");
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
    public void success(List<WdgpBean> data) {
        wdgpAdapter.addAll(data);
        wdgpAdapter.notifyDataSetChanged();
    }
}
