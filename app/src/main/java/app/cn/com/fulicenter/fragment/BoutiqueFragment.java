package app.cn.com.fulicenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.cn.com.fulicenter.Adapter.BoutiqueAdapter;
import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.activity.MainActivity;
import app.cn.com.fulicenter.bean.BoutiqueBean;
import app.cn.com.fulicenter.net.NetDAO;
import app.cn.com.fulicenter.utils.CommonUtils;
import app.cn.com.fulicenter.utils.ConvertUtils;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.OkHttpUtils;
import app.cn.com.fulicenter.view.SpaceItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 最后时刻 on 2016/10/19.
 */
public class BoutiqueFragment extends BaseFragment {
    @BindView(R.id.tv_refresh)
    TextView tvRefresh;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    LinearLayoutManager llm;
    MainActivity mContext;
    BoutiqueAdapter mAdapter;
    ArrayList<BoutiqueBean> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_newgoods, container, false);
        ButterKnife.bind(this, layout);
        mContext = (MainActivity) getContext();
        mAdapter = new BoutiqueAdapter(mList,mContext);
        super.onCreateView(inflater,container,savedInstanceState);
        return layout;
    }
    @Override
    protected void setListener() {
        setPullDownListener();
    }

    private void setPullDownListener() {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(true);
                tvRefresh.setVisibility(View.GONE);
                downloadBoutique();
            }
        });
    }

    @Override
    protected void initData() {
        downloadBoutique();
    }

    private void downloadBoutique() {
        NetDAO.downloadBoutique(mContext, new OkHttpUtils.OnCompleteListener<BoutiqueBean[]>() {
            @Override
            public void onSuccess(BoutiqueBean[] result) {
                srl.setRefreshing(false);
                tvRefresh.setVisibility(View.VISIBLE);
                L.e("result" + result);
                if (result != null && result.length > 0) {
                    ArrayList<BoutiqueBean> list = ConvertUtils.array2List(result);
                    mAdapter.initData(list);
                }
            }

            @Override
            public void onError(String error) {
                srl.setRefreshing(false);
                tvRefresh.setVisibility(View.GONE);
                CommonUtils.showLongToast(error);
                L.e("error:" + error);
            }
        });

    }


            @Override
    protected void initView() {
        srl.setColorSchemeColors(getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_yellow),
                getResources().getColor(R.color.google_red),
                getResources().getColor(R.color.google_green));
        llm = new LinearLayoutManager(mContext);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        rv.setAdapter(mAdapter);
        rv.addItemDecoration(new SpaceItemDecoration(12));
    }

}
