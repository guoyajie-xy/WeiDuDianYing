package com.bw.movie.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import com.bw.movie.R;
import com.bw.movie.adapter.XtxxAdapter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.XtxxBean;
import com.bw.movie.dao.DaoMaster;
import com.bw.movie.dao.LoginBeanDao;
import com.bw.movie.presenter.XtxxPresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XtxxActivity extends AppCompatActivity implements DataCall<List<XtxxBean>> {

    @BindView(R.id.XT_text_xtxi)
    TextView XTTextXtxi;
    @BindView(R.id.Xtxx_recyclerview)
    RecyclerView XtxxRecyclerview;
    private XtxxPresenter xtxxPresenter;
    private XtxxAdapter xtxxAdapter;
    LoginBean loginBean;
    private long userId=13039;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xtxx);
        ButterKnife.bind(this);
       // user=DaoMaster.newDevSession(XtxxActivity.this,UserInfoDao.TABLENAME).getUserInfoDao().loadAll().get(0);

        loginBean = DaoMaster.newDevSession(this,LoginBeanDao.TABLENAME).getLoginBeanDao().loadAll().get(0);
        xtxxPresenter = new XtxxPresenter(this);
        //布局管理器
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        XtxxRecyclerview.setLayoutManager(layoutManager);
        //创建适配器
        xtxxAdapter = new XtxxAdapter(this);
        XtxxRecyclerview.setAdapter(xtxxAdapter);
        xtxxPresenter.requestData(userId,loginBean.getSessionId(),"1","5");
        Log.i("tag", "onCreate: "+userId+"------------------"+loginBean.getSessionId());
        //xtxxPresenter.requestData(userInfo.getId(),userInfo.getSessionId(),"1","5");
        //Toast.makeText(XtxxActivity.this,userInfo.getId()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(List<XtxxBean> data) {
        xtxxAdapter.addAll(data);
        xtxxAdapter.notifyDataSetChanged();
    }
}
