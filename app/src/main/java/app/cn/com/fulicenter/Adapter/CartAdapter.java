package app.cn.com.fulicenter.Adapter;

/**
 * Created by 最后时刻 on 2016/10/30.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.CartBean;
import app.cn.com.fulicenter.bean.GoodsDetailsBean;
import app.cn.com.fulicenter.utils.ImageLoader;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends Adapter<CartAdapter.CartViewHolder> {
    Context mContext;
    ArrayList<CartBean> mList;

    public CartAdapter(Context context, ArrayList<CartBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CartViewHolder holder = new CartViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_cart, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        final CartBean cartBean = mList.get(position);
//        ImageLoader.downloadImg(mContext,holder.mIvBoutiqueImg,boutiqueBean.getImageurl());
//        holder.mTvBoutiqueTitle.setText(boutiqueBean.getTitle());
//        holder.mTvBoutiqueName.setText(boutiqueBean.getName());
//        holder.mTvBoutiqueDescription.setText(boutiqueBean.getDescription());
//        holder.mLayoutBoutiqueItem.setTag(boutiqueBean);
        GoodsDetailsBean goods = cartBean.getGoods();
        if(goods!=null) {
            ImageLoader.downloadImg(mContext, holder.mIvCartThumb, goods.getGoodsThumb());
            holder.mTvCartGoodName.setText(goods.getGoodsName());
            holder.mTvCartPrice.setText(goods.getCurrencyPrice());
        }
        holder.mTvCartCount.setText("("+cartBean.getCount()+")");
        holder.mCbCartSelected.setChecked(false);
        holder.mCbCartSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cartBean.setChecked(b);
                mContext.sendBroadcast(new Intent(I.BROADCAST_UPDATA_CART));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public void initData(ArrayList<CartBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    class CartViewHolder extends ViewHolder {
        @BindView(R.id.cb_cart_selected)
        CheckBox mCbCartSelected;
        @BindView(R.id.iv_cart_thumb)
        ImageView mIvCartThumb;
        @BindView(R.id.tv_cart_good_name)
        TextView mTvCartGoodName;
        @BindView(R.id.iv_cart_add)
        ImageView mIvCartAdd;
        @BindView(R.id.tv_cart_count)
        TextView mTvCartCount;
        @BindView(R.id.iv_cart_del)
        ImageView mIvCartDel;
        @BindView(R.id.tv_cart_price)
        TextView mTvCartPrice;

        CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}