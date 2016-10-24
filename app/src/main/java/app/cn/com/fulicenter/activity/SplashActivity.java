package app.cn.com.fulicenter.activity;

import android.graphics.ImageFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import app.cn.com.fulicenter.FuLiCenterApplication;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.User;
import app.cn.com.fulicenter.dao.UserDao;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.MFGT;


public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();
    static final long SPLAtTH_Time = 2000;
    SplashActivity mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext =this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = FuLiCenterApplication.getUser();
                L.e(TAG,"fulicenter,user="+user);
                if (user == null) {
                    UserDao dao = new UserDao(mContext);
                     user = dao.getUser("a9527010");
                    L.e(TAG,"database,user="+user);
                }
                MFGT.gotoMainActivity(SplashActivity.this);
                finish();
            }
        }).start();
    }
}
