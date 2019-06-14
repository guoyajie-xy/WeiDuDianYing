package com.bw.movie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.Wdgzfragment.DyFragment;
import com.bw.movie.Wdgzfragment.YyFragment;
import com.bw.movie.adapter.GpAdapter;
import com.bw.movie.wdgpfragment.DfkFragment;
import com.bw.movie.wdgpfragment.YwcFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WdgzActivity extends AppCompatActivity {
    List<Fragment> list = new ArrayList<>();
    @BindView(R.id.gz_rb1)
    RadioButton gzRb1;
    @BindView(R.id.gz_rb2)
    RadioButton gzRb2;
    @BindView(R.id.gz_radio_group)
    RadioGroup gzRadioGroup;
    @BindView(R.id.gz_view_pager)
    ViewPager gzViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wdgz);
        ButterKnife.bind(this);
        list.add(new DyFragment());
        list.add(new YyFragment());
        GpAdapter gpAdapter = new GpAdapter(getSupportFragmentManager(), list);
        gzViewPager.setAdapter(gpAdapter);
        //滑动切换
        gzViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                gzRadioGroup.check(gzRadioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //点击切换
        gzRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.gz_rb1:
                        gzViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.gz_rb2:
                        gzViewPager.setCurrentItem(1,false);
                        break;
                }
            }
        });
    }
}
