package app.cn.com.fulicenter.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import app.cn.com.fulicenter.Adapter.GoodsAdapter;
import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.activity.MainActivity;
import app.cn.com.fulicenter.bean.NewGoodsBean;
import app.cn.com.fulicenter.utils.CommonUtils;
import app.cn.com.fulicenter.utils.ConvertUtils;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.OkHttpUtils;
import app.cn.com.fulicenter.view.SpaceItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;
import app.cn.com.fulicenter.net.NetDAO;


public class NewGoodsFragment extends BaseFragment {


    @BindView(R.id.tv_refresh)
    TextView tvRefresh;

    RecyclerView rvNewGoods;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    MainActivity mContext;
    GoodsAdapter mAdapter;
    ArrayList<NewGoodsBean>mList;
    int pageId=1;
    GridLayoutManager glm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        L.e("NewGoodsFragment.onCreateView");
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_newgoods, container, false);
        ButterKnife.bind(this, layout);
        mContext= (MainActivity) getContext();
        mList=new ArrayList<>();
        mAdapter=new GoodsAdapter(mList,mContext);
        super.onCreateView(inflater,container,savedInstanceState);
        return layout;
    }
    @Override
    protected void setListener(){
        setPullUpListener();
        setPullDownListener();

    }

    private void setPullDownListener() {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(true);
                tvRefresh.setVisibility(View.GONE);
                pageId=1;
                downloadNewGoods(I.ACTION_PULL_DOWN);
            }
        });
    }
    private void downloadNewGoods(final int action) {
        NetDAO.downLoadNewGoods(mContext, pageId, new OkHttpUtils.OnCompleteListener<NewGoodsBean[]>() {
            @Override
            public void onSuccess(NewGoodsBean[] result) {
                srl.setRefreshing(false);
                tvRefresh.setVisibility(View.VISIBLE);
                mAdapter.setMore(true);
                L.e("result"+result);
                if(result!=null && result.length>0){
                    ArrayList<NewGoodsBean> list= ConvertUtils.array2List(result);
                    if (action== I.ACTION_DOWNLOAD||action==I.ACTION_PULL_DOWN){
                        mAdapter.initData(list);
                    }else {
                        mAdapter.addData(list);
                    }
                    mAdapter.setMore(false);
                    if (list.size()<I.PAGE_ID_DEFAULT){
                        mAdapter.setMore(false);
                    }
                }else {
                    mAdapter.setMore(false);
                }
            }

            @Override
            public void onError(String error) {
                srl.setRefreshing(false);
                tvRefresh.setVisibility(View.GONE);
                mAdapter.setMore(false);
                CommonUtils.showLongToast(error);
                L.e("error:"+error);
            }
        });
    }
    private void setPullUpListener() {
        rvNewGoods.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPosition= glm.findFirstVisibleItemPosition();
                if (newState==RecyclerView.SCROLL_STATE_IDLE
                        &&lastPosition== mAdapter.getItemCount()-1
                        &&mAdapter.isMore()){
                    pageId++;
                    downloadNewGoods(I.ACTION_PULL_UP);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition=glm.findFirstVisibleItemPosition();
                srl.setEnabled(firstPosition==0);
            }
        });
    }

    @Override
    protected void initData() {
        downloadNewGoods(I.ACTION_DOWNLOAD);
    }

    @Override
    protected void initView() {
        srl.setColorSchemeColors(getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_yellow),
                getResources().getColor(R.color.google_red),
                getResources().getColor(R.color.google_green));
        glm = new GridLayoutManager(mContext, I.COLUM_NUM);
        rvNewGoods.setLayoutManager(glm);
        rvNewGoods.setHasFixedSize(true);
        rvNewGoods.setAdapter(mAdapter);
        rvNewGoods.addItemDecoration(new SpaceItemDecoration(12));
    }

}
