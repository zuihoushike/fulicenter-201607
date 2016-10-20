package app.cn.com.fulicenter.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.BoutiqueBean;
import app.cn.com.fulicenter.utils.ImageLoader;
import app.cn.com.fulicenter.view.FooterViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BoutiqueAdapter extends Adapter<BoutiqueAdapter.BoutqueViewHolder> {
    Context mContext;
    ArrayList<BoutiqueBean> mList;

    public BoutiqueAdapter(ArrayList<BoutiqueBean> mList, Context mContext) {
        mList = new ArrayList<>();
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public BoutqueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BoutqueViewHolder holder = new BoutqueViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_boutique, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BoutqueViewHolder holder, int position) {
        BoutiqueBean boutiqueBean = mList.get(position);
        ImageLoader.downloadImg(mContext,holder.ivBoutiqueImg,boutiqueBean.getImageurl());
        holder.ivBoutiqueTitle.setText(boutiqueBean.getTitle());
        holder.tvBoutiqueName.setText(boutiqueBean.getName());
        holder.tvBoutiqueDescription.setText(boutiqueBean.getDescription());
        holder.mLayoutBoutiqueItem();
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public void initData(ArrayList<BoutiqueBean> list) {
        if (mList!=null){
            mList.clear();
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }


    static class BoutqueViewHolder  extends RecyclerView.ViewHolder{
        @BindView(R.id.ivBoutiqueImg)
        ImageView ivBoutiqueImg;
        @BindView(R.id.ivBoutiqueTitle)
        TextView ivBoutiqueTitle;
        @BindView(R.id.tvBoutiqueName)
        TextView tvBoutiqueName;
        @BindView(R.id.tvBoutiqueDescription)
        TextView tvBoutiqueDescription;

        BoutqueViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
