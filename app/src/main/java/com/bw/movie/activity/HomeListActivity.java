package com.bw.movie.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.homelistfrag.HomeListFrag01;
import com.bw.movie.homelistfrag.HomeListFrag02;
import com.bw.movie.homelistfrag.HomeListFrag03;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Auther: 郭亚杰
 * @Date:2019/6/11
 * @Description: 电影列表
 */
public class HomeListActivity extends AppCompatActivity {
    @BindView(R.id.homelist_pager)
    ViewPager homelist_pager;
    @BindView(R.id.homelist_radioGroup)
    RadioGroup homelist_radioGroup;
    @BindView(R.id.homelist_return)
    ImageView homelist_return;
    private ArrayList<Fragment> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);
        //绑定控件
        ButterKnife.bind(this);
        //获得数据
        list = new ArrayList<>();
        list.add(new HomeListFrag01());
        list.add(new HomeListFrag02());
        list.add(new HomeListFrag03());


        //获得适配器
        homelist_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //页面滑动
        homelist_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.homelist_radio1:
                        homelist_pager.setCurrentItem(0);
                        break;
                    case R.id.homelist_radio2:
                        homelist_pager.setCurrentItem(1);
                        break;
                    case R.id.homelist_radio3:
                        homelist_pager.setCurrentItem(2);
                        break;
                }
            }
        });

        //返回到影片首页
        homelist_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeListActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
