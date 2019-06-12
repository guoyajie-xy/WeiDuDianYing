package com.bw.movie.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.cinemafrag.CinemaFrag01;
import com.bw.movie.cinemafrag.CinemaFrag02;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragList extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.fraglist_page1)
    ViewPager fraglist_page1;
    @BindView(R.id.fraglist_radioGroup)
    RadioGroup fraglist_radioGroup;
    private ArrayList<Fragment> list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraglist, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //数据
        list = new ArrayList<>();
        list.add(new CinemaFrag01());
        list.add(new CinemaFrag02());
        //适配器
        fraglist_page1.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //页面切换
        fraglist_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fraglist_radio1:
                        fraglist_page1.setCurrentItem(0);
                        break;
                    case R.id.fraglist_radio2:
                        fraglist_page1.setCurrentItem(1);
                        break;
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
