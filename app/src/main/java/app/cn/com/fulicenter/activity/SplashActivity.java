package app.cn.com.fulicenter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import app.cn.com.fulicenter.FuLiCenterApplication;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.User;
import app.cn.com.fulicenter.dao.SharePrefrenceUtils;
import app.cn.com.fulicenter.dao.UserDao;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.MFGT;
import okhttp3.internal.framed.FrameReader;


public class SplashActivity extends AppCompatActivity {
    private static  String TAG = SplashActivity.class.getSimpleName();
    private final long sleepime = 2000;
    SplashActivity mContext;
    private String sleepTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext =this;
    }

    @Override
    protected void onStart() {
        super.onStart();

         new Handler().postDelayed(new Runnable() {
                @Override
                public void run () {
                    User user = FuLiCenterApplication.getUser();
                    L.e(TAG, "fulicenter,user=" + user);
                    String username = SharePrefrenceUtils.getInstance(mContext).getUser();
                    L.e(TAG, "fulicenter,username=" + username);
                    if (user == null && username != null) {
                        UserDao dao = new UserDao(mContext);
                        user = dao.getUser(username);
                        L.e(TAG, "database,user=" + user);
                        if (user != null) {
                            FuLiCenterApplication.setUser(user);
                        }
                    }
                    MFGT.gotoMainActivity(SplashActivity.this);
                    finish();
                }
          },sleepime);
    }


}
