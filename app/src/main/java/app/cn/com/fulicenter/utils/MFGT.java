package app.cn.com.fulicenter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.activity.GoodsDetailActivity;
import app.cn.com.fulicenter.activity.MainActivity;
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
        startActivity(context,intent);
    }
    public static void gotoGoodsDetailsActivity(Context context, int goodsId){
        Intent intent = new Intent();
        intent.setClass(context, GoodsDetailActivity.class);
        intent.putExtra(I.GoodsDetails.KEY_GOODS_ID,goodsId);
        startActivity(context,intent);
    }
    public static void startActivity(Context context,Intent intent){
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.push_left_in,R.anim.push_right_out);

    }
}
