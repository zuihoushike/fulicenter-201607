package app.cn.com.fulicenter.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.utils.MFGT;


public class SplashActivity extends AppCompatActivity {
    static final long SPLAtTH_Time = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = SystemClock.currentThreadTimeMillis();
                long castTime = SystemClock.currentThreadTimeMillis()-startTime;
                if (SPLAtTH_Time-castTime>0){
                    try {
                        Thread.sleep(SPLAtTH_Time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                MFGT.gotoMainActivity(SplashActivity.this);
                finish();
            }
        }).start();
    }
}
