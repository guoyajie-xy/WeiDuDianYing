package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.AES.EncryptUtil;
import com.bw.movie.R;
import com.bw.movie.bean.RegistBean;
import com.bw.movie.presenter.RegistPresenter;
import com.bw.movie.view.DataCall;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistActivity extends AppCompatActivity implements DataCall<RegistBean> {

    @BindView(R.id.regist_ed_name)
    EditText registEdName;
    @BindView(R.id.regist_ed_sex)
    EditText registEdSex;
    @BindView(R.id.regist_ed_data)
    EditText registEdData;
    @BindView(R.id.regist_ed_phone)
    EditText registEdPhone;
    @BindView(R.id.regist_ed_mail)
    EditText registEdMail;
    @BindView(R.id.regist_ed_pass)
    EditText registEdPass;
    @BindView(R.id.regist_button)
    Button registButton;
    private RegistPresenter registPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        registPresenter = new RegistPresenter(this);
        //点击注册
        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取到输入框的值
                String name=registEdName.getText().toString();
                int sex= Integer.parseInt(registEdSex.getText().toString());
                String birdata=registEdData.getText().toString();
                String call=registEdPhone.getText().toString();
                String email=registEdMail.getText().toString();
                String pwd=registEdPass.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(RegistActivity.this,"昵称输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if (sex == Integer.parseInt(null)){
                    Toast.makeText(RegistActivity.this,"昵称输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if (birdata.isEmpty()){
                    Toast.makeText(RegistActivity.this,"出生日期输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if (call.isEmpty()){
                    Toast.makeText(RegistActivity.this,"手机号输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if (email.isEmpty()){
                    Toast.makeText(RegistActivity.this,"邮箱输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if (pwd.isEmpty()){
                    Toast.makeText(RegistActivity.this,"密码输入不能为空",Toast.LENGTH_SHORT).show();
                }
                if (pwd.length()<6){
                    Toast.makeText(RegistActivity.this,"密码不能低于六位数",Toast.LENGTH_SHORT).show();
                    return;
                }
                String encrypt = EncryptUtil.encrypt(pwd);
                String pwd2=encrypt;
                registPresenter.requestData(name,sex,birdata,call,email,encrypt,pwd2);
            }

        });
    }

    @Override
    public void success(RegistBean data) {
        Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(RegistActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
