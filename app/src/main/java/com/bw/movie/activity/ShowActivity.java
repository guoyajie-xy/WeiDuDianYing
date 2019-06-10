package com.bw.movie.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.frag.FragHome;
import com.bw.movie.frag.FragList;
import com.bw.movie.frag.FragMy;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Auther: 郭亚杰
 * @Date:2019/6/10
 * @Description: 底部导航
 */
public class ShowActivity extends AppCompatActivity {
    @BindView(R.id.home_frame)
    FrameLayout home_frame;
    @BindView(R.id.radioGroup1)
    RadioGroup radioGroup;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private FragHome fragHome;
    private FragList fragList;
    private FragMy fragMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //绑定控件
        ButterKnife.bind(this);
        //获取管理者
        manager = getSupportFragmentManager();
        //开启事务
        transaction = manager.beginTransaction();
        //碎片
        fragHome = new FragHome();
        //提交事务
        transaction.add(R.id.home_frame, fragHome).commit();
        //点击按钮 页面变化
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //一定要加
                hideFrag();
                //开启事务
                transaction = manager.beginTransaction();

                switch (checkedId) {
                    case R.id.radio1:
                        transaction.show(fragHome).commit();
                        break;
                    case R.id.radio2:
                        if (fragList == null) {
                            fragList = new FragList();
                            transaction.add(R.id.home_frame, fragList).commit();
                        } else {
                            transaction.show(fragHome).commit();
                        }
                        break;
                    case R.id.radio3:
                        if (fragMy == null) {
                            fragMy = new FragMy();
                            transaction.add(R.id.home_frame, fragMy).commit();
                        } else {
                            transaction.show(fragMy).commit();
                        }
                        break;
                }
            }
        });

    }

    private void hideFrag() {
        //再重新获取一个开启事务
        transaction = manager.beginTransaction();
        //不等于空或者是否添加的时候
        if (fragHome != null && fragHome.isAdded()) {
            transaction.hide(fragHome);
        }
        if (fragList != null && fragList.isAdded()) {
            transaction.hide(fragList);
        }
        if (fragMy != null && fragMy.isAdded()) {
            transaction.hide(fragMy);
        }
        transaction.commit();
    }
}
