package app.cn.com.fulicenter.net;

import android.content.Context;

import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.bean.BoutiqueBean;
import app.cn.com.fulicenter.bean.CategoryGroupBean;
import app.cn.com.fulicenter.bean.GoodsDetailsBean;
import app.cn.com.fulicenter.bean.NewGoodsBean;
import app.cn.com.fulicenter.utils.OkHttpUtils;

/**
 * Created by 最后时刻 on 2016/10/18.
 */
public class NetDAO {
    public static void downLoadNewGoods(Context context,int catId,int pageId,OkHttpUtils.OnCompleteListener<NewGoodsBean[]> listener){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
                .addParam(I.NewAndBoutiqueGoods.CAT_ID,String.valueOf(catId))
                .addParam(I.PAGE_ID,String.valueOf(pageId))
                .addParam(I.PAGE_SIZE,String.valueOf(I.PAGE_SIZE_DEFAULT))
                .targetClass(NewGoodsBean[].class)
                .execute(listener);
    }

   public static void downloadGoodsDetail(Context context, int goodsId, OkHttpUtils.OnCompleteListener<GoodsDetailsBean> listener){
       OkHttpUtils utils = new OkHttpUtils(context);
       utils.setRequestUrl(I.REQUEST_FIND_GOOD_DETAILS)
               .addParam(I.GoodsDetails.KEY_GOODS_ID,String.valueOf(goodsId))
               .targetClass(GoodsDetailsBean.class)
               .execute(listener);
   }
    public static void downloadBoutique(Context context, OkHttpUtils.OnCompleteListener<BoutiqueBean> listener){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_BOUTIQUES)
                .targetClass(BoutiqueBean[].class)
                .execute(listener);
    }
    public static void downloadCategoryGroup(Context context, OkHttpUtils.OnCompleteListener<CategoryGroupBean[]> listener){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_CATEGORY_GROUP)
                .targetClass(CategoryGroupBean[].class)
                .execute(listener);
    }
    public static void downloadCategoryChild(Context context,int parentId,OkHttpUtils.OnCompleteListener<CategoryGroupBean[]> listener){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_CATEGORY_CHILDREN)
                .addParam(I.CategoryChild.PARENT_ID,String.valueOf(parentId))
                .targetClass(CategoryGroupBean[].class)
                .execute(listener);
    }
    //
    public static void downCategoryGoods(Context context,int catId,int pageId,OkHttpUtils.OnCompleteListener<NewGoodsBean[]> listener){
        OkHttpUtils utils = new OkHttpUtils(context);
        utils.setRequestUrl(I.REQUEST_FIND_GOODS_DETAILS)
                .addParam(I.NewAndBoutiqueGoods.CAT_ID,String.valueOf(catId))
                .addParam(I.PAGE_ID,String.valueOf(pageId))
                .addParam(I.PAGE_SIZE,String.valueOf(I.PAGE_SIZE_DEFAULT))
                .targetClass(NewGoodsBean[].class)
                .execute(listener);
    }
}
