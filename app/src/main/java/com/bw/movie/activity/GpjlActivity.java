package com.bw.movie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.GpAdapter;
import com.bw.movie.wdgpfragment.DfkFragment;
import com.bw.movie.wdgpfragment.YwcFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GpjlActivity extends AppCompatActivity {
    List<Fragment> list = new ArrayList<>();
    @BindView(R.id.gp_rb1)
    RadioButton gpRb1;
    @BindView(R.id.gp_rb2)
    RadioButton gpRb2;
    @BindView(R.id.gp_radio_group)
    RadioGroup gpRadioGroup;
    @BindView(R.id.gp_view_pager)
    ViewPager gpViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpjl);
        ButterKnife.bind(this);
        list.add(new DfkFragment());
        list.add(new YwcFragment());
        GpAdapter gpAdapter = new GpAdapter(getSupportFragmentManager(), list);
        gpViewPager.setAdapter(gpAdapter);
        //滑动切换
        gpViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                gpRadioGroup.check(gpRadioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //点击切换
        gpRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.gp_rb1:
                        gpViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.gp_rb2:
                        gpViewPager.setCurrentItem(1,false);
                        break;
                }
            }
        });
    }
}
