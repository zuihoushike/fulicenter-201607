package app.cn.com.fulicenter;

import android.app.Application;

/**
 * Created by 最后时刻 on 2016/10/18.
 */
public class FuLiCenterApplication extends Application {
    public static FuLiCenterApplication application;
    private static FuLiCenterApplication instance;

     private static String username;

    @Override
    public void onCreate() {
        super.onCreate();
        application= this;
        instance=this;
    }

    public static FuLiCenterApplication getInstance(){
        if (instance==null){
            instance = new FuLiCenterApplication();
        }
        return instance;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        FuLiCenterApplication.username = username;
    }
}
