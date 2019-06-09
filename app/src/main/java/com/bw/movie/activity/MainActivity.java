package com.bw.movie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bw.movie.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Auther: 郭亚杰
 * @Date:2019/6/9
 * @Description: 启动页
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_time)
    TextView text_time;
    private int time = 2;
    private Timer timer;
    //线程
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (time > 0) {
                    time--;
                    text_time.setText(time + "s");
                } else {
                    Intent intent = new Intent(MainActivity.this, YinDaoActivity.class);
                    startActivity(intent);
                    //跳转完后，关闭计时器
                    timer.cancel();
                    finish();
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定控件
        ButterKnife.bind(this);
        //通过计时器对象
        timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                //具体执行内容
                handler.sendEmptyMessage(0);
            }
        };
        timer.schedule(task, 1000, 1000);
    }
}
