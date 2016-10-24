package app.cn.com.fulicenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.activity.CategoryAdapter;
import app.cn.com.fulicenter.activity.MainActivity;
import app.cn.com.fulicenter.bean.CategoryGroupBean;
import app.cn.com.fulicenter.net.NetDAO;
import app.cn.com.fulicenter.utils.ConvertUtils;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.OkHttpUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 最后时刻 on 2016/10/21.
 */
public class CategoryFragment extends BaseFragment {

    @BindView(R.id.elv_category)
    ExpandableListView mElvCategory;

    CategoryAdapter mAdapter;
    MainActivity mContext;
    ArrayList<CategoryGroupBean> mGroupList;
    ArrayList<ArrayList<CategoryGroupBean>> mChildList;

    int groupCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fargment_category, container, false);
        ButterKnife.bind(this, layout);
        mContext = (MainActivity) getContext();
        mGroupList = new ArrayList<>();
        mChildList = new ArrayList<>();
        mAdapter = new CategoryAdapter(mContext,mGroupList,mChildList);
        super.onCreateView(inflater, container, savedInstanceState);
        return layout;

    }

    @Override
    protected void initView() {
        mElvCategory.setGroupIndicator(null);
        mElvCategory.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        downloadGroup();
    }

    private void downloadGroup() {
        NetDAO.downloadCategoryGroup(mContext, new OkHttpUtils.OnCompleteListener<CategoryGroupBean[]>() {
            @Override
            public void onSuccess(CategoryGroupBean[] result) {
                L.e("downloadGroup,result="+result);
                if (result!=null&& result.length>0){
                    ArrayList<CategoryGroupBean> groupList = ConvertUtils.array2List(result);
                    L.e("groupList="+groupList.size());
                    mGroupList.addAll(groupList);
                    for (int i=0;i<groupList.size();i++){
                        mChildList.add(new ArrayList<CategoryGroupBean>());
                        CategoryGroupBean g=groupList.get(i);
                        downloadChild(g.getId(),i);
                    }
                }
            }

            @Override
            public void onError(String error) {
                L.e("error="+error);
            }
        });
    }

    private void downloadChild(int id,final int index) {
        NetDAO.downloadCategoryChild(mContext, id, new OkHttpUtils.OnCompleteListener<CategoryGroupBean[]>() {
            @Override
            public void onSuccess(CategoryGroupBean[] result) {
                groupCount++;
                L.e("downloadChild,result="+result);
                if (result!=null&&result.length>0){
                    ArrayList<CategoryGroupBean> childList = ConvertUtils.array2List(result);
                    L.e("childList="+childList.size());
                     mChildList.set(index,childList);
                }
                if (groupCount==mGroupList.size()){
                    mAdapter.initData(mGroupList,mChildList);
                }
            }

            @Override
            public void onError(String error) {
                L.e("error="+error);
            }
        });
    }

    @Override
    protected void setListener() {
        mElvCategory.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }
}
