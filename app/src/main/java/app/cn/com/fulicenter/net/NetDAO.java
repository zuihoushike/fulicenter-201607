package app.cn.com.fulicenter.net;

import android.content.Context;

import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.bean.NewGoodsBean;
import app.cn.com.fulicenter.utils.OkHttpUtils;

/**
 * Created by 最后时刻 on 2016/10/18.
 */
public class NetDAO {
    public static void downLoadNewGoods(Context context,int  pageId,OkHttpUtils.OnCompleteListener<NewGoodsBean[]> listener){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
                .addParam(I.NewAndBoutiqueGoods.CAT_ID,String.valueOf(I.CAT_ID))
                .addParam(I.PAGE_ID,String.valueOf(pageId))
                .addParam(I.PAGE_SIZE,String.valueOf(I.PAGE_SIZE_DEFAULT))
                .targetClass(NewGoodsBean[].class)
                .execute(listener);
    }
    public void tesp(Context context){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
                .addParam(I.PAGE_SIZE,String.valueOf(20))
                .targetClass(NewGoodsBean.class)
                .execute(new OkHttpUtils.OnCompleteListener() {
                    @Override
                    public void onSuccess(Object result) {

                    }

                    @Override
                    public void onError(String error) {

                    }
                });
    }
}
