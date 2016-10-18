package app.cn.com.fulicenter;

import android.app.Application;

/**
 * Created by 最后时刻 on 2016/10/18.
 */
public class FuLiCenterApplication extends Application {
    public static FuLiCenterApplication application;
    private static FuLiCenterApplication instance;

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
}
