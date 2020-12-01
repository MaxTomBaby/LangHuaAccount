package com.langhua.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {
    private static final long DELAY = 5000; // 设置延迟时间为1000ms=1s

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Intent localIntent = new Intent(this, MainActivity.class); // 转向指定activity
        Timer timer = new Timer();
        TimerTask tast = new TimerTask() {
            @Override
            public void run() {
                startActivity(localIntent); // 执行
                finish(); // 结束当前页面
                //System.exit(0); // 可有可无,保证程序无报错,会有卡顿的现象
            }
        };
        timer.schedule(tast, DELAY);
    }
}