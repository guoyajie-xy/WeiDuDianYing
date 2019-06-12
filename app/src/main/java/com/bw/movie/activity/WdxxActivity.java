package com.bw.movie.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.adapter.WdxxAdapter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.WdBean;
import com.bw.movie.dao.DaoMaster;
import com.bw.movie.dao.LoginBeanDao;
import com.bw.movie.presenter.WdxxPresenter;
import com.bw.movie.view.DataCall;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WdxxActivity extends AppCompatActivity implements DataCall<WdBean> {

    @BindView(R.id.Wdxx_image_back)
    ImageView WdxxImageBack;
    LoginBean loginBean;
    @BindView(R.id.Wdxx_recycler_view)
    RecyclerView WdxxRecyclerView;
    private long userId = 13062;
    private WdxxAdapter wdxxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wdxx);
        ButterKnife.bind(this);
        loginBean = DaoMaster.newDevSession(WdxxActivity.this, LoginBeanDao.TABLENAME).getLoginBeanDao().loadAll().get(0);
        WdxxPresenter wdxxPresenter = new WdxxPresenter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        WdxxRecyclerView.setLayoutManager(layoutManager);
        //创建适配器
        wdxxAdapter = new WdxxAdapter(this);
        WdxxRecyclerView.setAdapter(wdxxAdapter);
        wdxxPresenter.requestData(userId, loginBean.getSessionId());
        WdxxImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void success(WdBean data) {
        wdxxAdapter.add(data);
        wdxxAdapter.notifyDataSetChanged();
    }
}
