package com.bw.movie.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.LoginActivity;
import com.bw.movie.activity.WdxxActivity;
import com.bw.movie.activity.XtxxActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragMy extends Fragment {

    @BindView(R.id.my_image_xtxx)
    ImageView myImageXtxx;
    @BindView(R.id.my_text_name)
    TextView myTextName;
    @BindView(R.id.my_btn_qiandao)
    Button myBtnQiandao;
    @BindView(R.id.my_text_wdxx)
    TextView myTextWdxx;
    @BindView(R.id.my_text_wdgz)
    TextView myTextWdgz;
    @BindView(R.id.my_text_gpjl)
    TextView myTextGpjl;
    @BindView(R.id.my_text_yjfk)
    TextView myTextYjfk;
    @BindView(R.id.my_text_zxbb)
    TextView myTextZxbb;
    @BindView(R.id.my_text_tcdl)
    TextView myTextTcdl;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmy, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //跳转到系统消息
        myImageXtxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),XtxxActivity.class);
                startActivity(intent);
            }
        });
        //跳转到我的信息
        myTextWdxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),WdxxActivity.class);
                startActivity(intent);
            }
        });
        //退出登录
        myTextTcdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
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
