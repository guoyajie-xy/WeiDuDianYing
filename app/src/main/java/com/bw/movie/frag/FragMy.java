package com.bw.movie.frag;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.activity.GpjlActivity;
import com.bw.movie.activity.LoginActivity;
import com.bw.movie.activity.WdgzActivity;
import com.bw.movie.activity.WdxxActivity;
import com.bw.movie.activity.XtxxActivity;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.SctxBean;
import com.bw.movie.dao.DaoMaster;
import com.bw.movie.dao.LoginBeanDao;
import com.bw.movie.presenter.SctxPresenter;
import com.bw.movie.util.RealPathFromUriUtils;
import com.bw.movie.view.DataCall;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragMy extends Fragment implements DataCall<SctxBean> {

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
    @BindView(R.id.my_image_tx)
    ImageView myImageTx;
    private Unbinder unbinder;
    private PopupWindow popupWindow;
    private TextView my_pop_xc;
    private TextView my_pop_xj;
    private SctxPresenter sctxPresenter;
    private LoginBean loginBean;
    private long userId = 13062;
    private String path = Environment.getExternalStorageDirectory()+"/my.jpg";
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
        sctxPresenter = new SctxPresenter(this);
        //保存数据库
        loginBean=DaoMaster.newDevSession(getContext(),LoginBeanDao.TABLENAME).getLoginBeanDao().loadAll().get(0);
        //跳转到系统消息
        myImageXtxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), XtxxActivity.class);
                startActivity(intent);
            }
        });
        //跳转到我的信息
        myTextWdxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WdxxActivity.class);
                startActivity(intent);
            }
        });
        //退出登录
        myTextTcdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        //加载popupwindow的子布局
        View view = View.inflate(getContext(), R.layout.my_popupwindow, null);
        my_pop_xc = view.findViewById(R.id.my_pop_xc);
        my_pop_xj = view.findViewById(R.id.my_pop_xj);
        //创建popupwindow
        //contentView, 布局   width, 宽    height 高
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置背景
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        popupWindow.setBackgroundDrawable(dw);
        //设置焦点
        popupWindow.setFocusable(true);
        //设置可触摸
        popupWindow.setTouchable(true);
        //相机
        my_pop_xj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建拍照的隐式意图对象
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //把拍完的照片,输出到指定路径上
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));
                //开启页面
                startActivityForResult(intent, 100);
            }
        });
        //相册
        my_pop_xc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,200);
            }
        });
        myImageTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据父窗体X Y轴的偏移改变位置
                popupWindow.showAtLocation(View.inflate(getContext(), R.layout.fragmy, null), Gravity.CENTER, 0, 600);
            }
        });
        //我的购票
        myTextGpjl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),GpjlActivity.class);
                startActivity(intent);
            }
        });
        //我的关注
        myTextWdgz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),WdgzActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            //取出拍照的照片
            Uri uri = Uri.fromFile(new File(path));
            File file=new File(path);
            myImageTx.setImageURI(uri);
            sctxPresenter.requestData(String.valueOf(userId),loginBean.getSessionId(),file);
        }
        if (requestCode==200){
            String realPathFromUri=RealPathFromUriUtils.getRealPathFromUri(getActivity(),data.getData());
            File filea=new File(realPathFromUri);
            Uri uri=data.getData();
            myImageTx.setImageURI(uri);
            Glide.with(getContext()).load(uri).apply(RequestOptions.circleCropTransform()).into(myImageTx);
            sctxPresenter.requestData(String.valueOf(userId),loginBean.getSessionId(),filea);
        }
    }

    @Override
    public void success(SctxBean data) {

    }
}
