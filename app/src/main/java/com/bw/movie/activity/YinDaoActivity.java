package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.bw.movie.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Auther: 郭亚杰
 * @Date:2019/6/9
 * @Description: 引导页
 */
public class YinDaoActivity extends AppCompatActivity {
    @BindView(R.id.pager1)
    ViewPager pager;
    @BindView(R.id.button_yindao)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);
        //绑定控件
        ButterKnife.bind(this);
        //1.获取sp 对象（ 存储文件的名字，存储的文件权限）
        SharedPreferences sp = getSharedPreferences("ydy", Context.MODE_PRIVATE);//5判断是不是第一次
        if (sp.getBoolean("第一次", false)) {
            startActivity(new Intent(YinDaoActivity.this, LoginActivity.class));
            finish();//这行代码很重要必须写 不然会减5分；
            return;//停止继续执行
        }

        //2获取编辑器
        SharedPreferences.Editor edit = sp.edit();
        //3存储值
        edit.putBoolean("第一次", true);
        //4提交
        edit.commit();

        button.setVisibility(View.GONE);
        // 第一步：数据
        final ArrayList<ImageView> list = new ArrayList<>();
        int arr[] = {R.mipmap.yindao1, R.mipmap.yindao2,
                R.mipmap.yindao3, R.mipmap.yindao4};
        for (int i = 0; i < arr.length; i++) {
            ImageView imageView = new ImageView(YinDaoActivity.this);
            imageView.setImageResource(arr[i]);
            list.add(imageView);
        }

        // 第二部：适配器
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = list.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

        // 第三部：页面滑动事件
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == list.size() - 1) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        // 第四部：点击 事件跳转页面
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YinDaoActivity.this, LoginActivity.class));
                finish();//这行代码很重要必须写 不然会减5分；
            }
        });
    }
}
