package app.cn.com.fulicenter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.activity.GoodsDetailActivity;
import app.cn.com.fulicenter.activity.MainActivity;
import app.cn.com.fulicenter.bean.NewGoodsBean;
import app.cn.com.fulicenter.utils.ImageLoader;
import app.cn.com.fulicenter.utils.MFGT;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 最后时刻 on 2016/10/17.
 */
public class GoodsAdapter extends Adapter {
    List<NewGoodsBean> mlist;
    Context mContext;
    boolean isMore;


    public GoodsAdapter(List<NewGoodsBean> list, Context mContext) {
        mlist = new ArrayList<>();
        mlist.addAll(list);
        this.mContext = mContext;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = null;
        if (viewType == I.TYPE_FOOTER) {
            holder = new FooterViewHolder(View.inflate(mContext,R.layout.item_footer,null));
        } else {
            holder = new GoodsViewHolder(View.inflate(mContext, R.layout.item_goods, null));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position)==I.TYPE_FOOTER){
            FooterViewHolder vh = (FooterViewHolder) holder;
            vh.tvFooter.setText(getFootString());
        }else {
            GoodsViewHolder vh = (GoodsViewHolder) holder;
            NewGoodsBean goods = mlist.get(position);
            ImageLoader.downloadImg(mContext,vh.ivGoodsThumb,goods.getGoodsThumb());
            vh.ivGoodsName.setText(goods.getGoodsName());
            vh.tvGoodsPrice.setText(goods.getCurrencyPrice());
            vh.layoutGoods.setTag(goods.getId());
        }
    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() + 1 : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return I.TYPE_FOOTER;
        }
        return I.TYPE_ITEM;
    }

    public void initData(ArrayList<NewGoodsBean> list) {
        if (mlist!=null){
            mlist.clear();
        }
        mlist.addAll(list);
        notifyDataSetChanged();
    }

    public int getFootString(){
        return isMore?R.string.load_more:R.string.no_more;
    }

    public void addData(ArrayList<NewGoodsBean> list) {
        mlist.addAll(list);
        notifyDataSetChanged();
    }


     class GoodsViewHolder extends ViewHolder{
        @BindView(R.id.ivGoodsThumb)
        ImageView ivGoodsThumb;
        @BindView(R.id.ivGoodsName)
        TextView ivGoodsName;
        @BindView(R.id.tvGoodsPrice)
        TextView tvGoodsPrice;
        @BindView(R.id.layout_goods)
        LinearLayout layoutGoods;

        GoodsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        @OnClick(R.id.layout_goods)
        public void onGoodsItemClick(){
            int goodsId = (int) layoutGoods.getTag();
            MFGT.gotoGoodsDetailsActivity(mContext,goodsId);
        }
    }

    static class FooterViewHolder extends ViewHolder{
        @BindView(R.id.tvFooter)
        TextView tvFooter;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
