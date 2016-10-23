package app.cn.com.fulicenter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import java.util.ArrayList;

import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.activity.BoutiqueChildActivity;
import app.cn.com.fulicenter.activity.CategoryChildtivity;
import app.cn.com.fulicenter.activity.GoodsDetailActivity;
import app.cn.com.fulicenter.activity.LoginActivity;
import app.cn.com.fulicenter.activity.MainActivity;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.BoutiqueBean;
import app.cn.com.fulicenter.activity.RegisterActivity;
import app.cn.com.fulicenter.bean.CategoryChildBean;

import static app.cn.com.fulicenter.I.REQUEST_CODE_REGISTER;

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
    public static void gotoBoutiqueChildActivity(Context context, BoutiqueBean bean){
        Intent intent = new Intent();
        intent.setClass(context, BoutiqueChildActivity.class);
        intent.putExtra(I.Boutique.CAT_ID,bean);
        startActivity(context,intent);
    }
    public static void gotoCategoryChildtivity(Context context, int catId, String groupName,ArrayList<CategoryChildBean> list){
        Intent intent = new Intent();
        intent.setClass(context, CategoryChildtivity.class);
        intent.putExtra(I.CategoryChild.CAT_ID,catId);
        intent.putExtra(I.CategoryGroup.NAME,groupName);
        intent.putExtra(I.CategoryChild.ID,list);
        startActivity(context,intent);
    }

    public static void gotoLogin(Activity context){
        startActivity(context, LoginActivity.class);
    }

    public static void gotoRegister(Activity context){
        Intent intent = new Intent();
        intent.setClass(context,RegisterActivity.class);
        startActivityForResult(context,intent, REQUEST_CODE_REGISTER);
    }

    public static void startActivityForResult(Activity context,Intent intent,int requestCode){
        context.startActivityForResult(intent,requestCode);
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_right_out);
    }
}
