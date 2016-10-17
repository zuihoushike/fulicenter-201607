package app.cn.com.fulicenter.utils;

import android.app.Activity;
import android.content.Intent;


import app.cn.com.fulicenter.MainActivity;
import app.cn.com.fulicenter.R;

/**
 * Created by 最后时刻 on 2016/10/14.
 */


public class MFGT {
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    public static void gotoMainActivity(Activity context){
        startActivity(context, MainActivity.class);
    }
    public static void startActivity(Activity context,Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context,cls);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_right_out);
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}
