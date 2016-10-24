package app.cn.com.fulicenter.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.CategoryChildBean;
import app.cn.com.fulicenter.bean.CategoryGroupBean;
import app.cn.com.fulicenter.utils.ImageLoader;
import app.cn.com.fulicenter.utils.MFGT;
import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryAdapter extends BaseExpandableListAdapter {
    Context mContext;
    ArrayList<CategoryGroupBean> mGroupList;
    ArrayList<ArrayList<CategoryGroupBean>> mChildList;

    public CategoryAdapter(Context context, List<CategoryGroupBean>
            groupList, ArrayList<ArrayList<CategoryGroupBean>> ChildList) {
        mContext = context;
        mGroupList = new ArrayList<>();
        mGroupList.addAll(groupList);
        mChildList = new ArrayList<>();
        mChildList.addAll(ChildList);

    }

    @Override
    public int getGroupCount() {
        return mGroupList != null ? mGroupList.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildList != null && mChildList
                .get(groupPosition) != null ? mChildList.get(groupPosition).size() : 0;
    }

    @Override
    public CategoryGroupBean getGroup(int groupPosition) {
        return mGroupList != null ? mGroupList.get(groupPosition) : null;
    }

    @Override
    public CategoryChildBean getChild(int groupPosition, int childPosition) {
        return mChildList != null && mChildList.get(groupPosition) !=
                null ? mChildList.get(groupPosition).get(childPosition) : null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpand, View view, ViewGroup viewGroup) {
        GroupViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_category_group, null);
            holder = new GroupViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (GroupViewHolder) view.getTag();
        }
        CategoryGroupBean group = getGroup(groupPosition);
        if (group != null) {
            ImageLoader.downloadImg(mContext, holder.ivGroupThumb, group.getImageUrl());
            holder.tvGroupName.setText(group.getName());
            holder.ivIndicator.setImageResource(isExpand ? R.mipmap.expand_off : R.mipmap.expand_on);
        }
        return view;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item_category_child, null);
            holder=new ChildViewHolder(view);
            holder.layoutCategoryChild=(RelativeLayout)view.findViewById(R.id.layout_category_child);
            view.setTag(holder);
        } else {
            holder= (ChildViewHolder) view.getTag();
        }
        final CategoryChildBean child=getChild(groupPosition,childPosition);
        if (child!=null){
            ImageLoader.downloadImg(mContext,holder.ivCategoryChildThumb,child.getImageUrl());
            holder.tvCategoryChildName.setText(child.getName());
            holder.layoutCategoryChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<CategoryGroupBean> list=mChildList.get(groupPosition);
                    String groupName=mGroupList.get(groupPosition).getName();
                    MFGT.gotoCategoryChildActivity(mContext,child.getId(),groupName,list);

                }
            });
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public void initDate(ArrayList<CategoryGroupBean> groupList,
                         ArrayList<ArrayList<CategoryGroupBean>> childList) {
        if (mGroupList!=null){
            mGroupList.clear();
        }
        mGroupList.addAll(groupList);
        if (mChildList!=null){
            mChildList.clear();
        }
        mChildList.addAll(childList);
        notifyDataSetChanged();

    }

    public void initData(ArrayList<CategoryGroupBean> mGroupList, ArrayList<ArrayList<CategoryGroupBean>> mChildList) {
    }

    class GroupViewHolder {
        @BindView(R.id.iv_group_thumb)
        ImageView ivGroupThumb;
        @BindView(R.id.tv_group_thumb)
        TextView tvGroupName;
        @BindView(R.id.iv_indicator)
        ImageView ivIndicator;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class ChildViewHolder{
        @BindView(R.id.iv_category_child_thumb)
        ImageView ivCategoryChildThumb;
        @BindView(R.id.tv_category_child_name)
        TextView tvCategoryChildName;
        @BindView(R.id.layout_category_child)
        RelativeLayout layoutCategoryChild;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
