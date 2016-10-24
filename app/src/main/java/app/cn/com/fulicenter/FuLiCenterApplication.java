package app.cn.com.fulicenter;

import android.app.Application;

import app.cn.com.fulicenter.bean.User;

/**
 * Created by 最后时刻 on 2016/10/18.
 */
public class FuLiCenterApplication extends Application {
    public static FuLiCenterApplication application;
    private static FuLiCenterApplication instance;

    private static String username;
    private static User user;

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

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        FuLiCenterApplication.user = user;
    }
}
