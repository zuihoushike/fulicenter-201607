package app.cn.com.fulicenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.cn.com.fulicenter.utils.L;


/**
 * Created by 最后时刻 on 2016/10/19.
 */
public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        L.e("BaseFragment.onCreate");
        initView();
        initData();
        setListener();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void  initView();
    protected  abstract  void initData();
    protected abstract void setListener();

}
