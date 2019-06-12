package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.AES.EncryptUtil;
import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.presenter.LoginPresenter;
import com.bw.movie.view.DataCall;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements DataCall<LoginBean> {

    @BindView(R.id.login_edit_phone)
    EditText loginEditPhone;
    @BindView(R.id.login_edit_pwd)
    EditText loginEditPwd;
    @BindView(R.id.login_check_pwd)
    CheckBox loginCheckPwd;
    @BindView(R.id.login_check_dl)
    CheckBox loginCheckDl;
    @BindView(R.id.login_text_kszc)
    TextView loginTextKszc;
    @BindView(R.id.login_btn_dl)
    Button loginBtnDl;
    @BindView(R.id.login_image_wx)
    ImageView loginImageWx;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //获取sp对象
        final SharedPreferences sharedPreferences=getSharedPreferences("config",MODE_PRIVATE);
        boolean flag = sharedPreferences.getBoolean("flag", false);
        loginCheckPwd.setChecked(flag);
        if (flag){
            String name=sharedPreferences.getString("name","");
            String pwd=sharedPreferences.getString("pwd","");
            loginEditPhone.setText(name);
            loginEditPwd.setText(pwd);
        }
        loginPresenter = new LoginPresenter(this);
        //点击快速注册跳转
        loginTextKszc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
            }
        });

        //点击登录
        loginBtnDl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=loginEditPhone.getText().toString().trim();
                String pwd=loginEditPwd.getText().toString().trim();
                SharedPreferences.Editor edit=sharedPreferences.edit();
                if (loginCheckPwd.isChecked()){
                    edit.putString("name",name);
                    edit.putString("pwd",pwd);
                    edit.putBoolean("flag",true);
                }else {
                    edit.clear();
                }
                edit.commit();
                if (TextUtils.isEmpty(name)&&TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this,"手机号或密码不能为空",Toast.LENGTH_SHORT).show();
                }
                String encrypt = EncryptUtil.encrypt(pwd);
                loginPresenter.requestData(name,encrypt);
            }
        });

    }

    @Override
    public void success(LoginBean data) {
        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(LoginActivity.this,ShowActivity.class);
        startActivity(intent);
        finish();
    }

}
