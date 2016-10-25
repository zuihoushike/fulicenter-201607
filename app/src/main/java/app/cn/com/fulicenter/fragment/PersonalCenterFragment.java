package app.cn.com.fulicenter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.cn.com.fulicenter.FuLiCenterApplication;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.activity.MainActivity;
import app.cn.com.fulicenter.bean.User;
import app.cn.com.fulicenter.utils.ImageLoader;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.MFGT;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 最后时刻 on 2016/10/24.
 */

public class PersonalCenterFragment extends BaseFragment {
    private static final String TAG = PersonalCenterFragment.class.getSimpleName();
    @BindView(R.id.iv_user_avatar)
    ImageView mIvUserAvatar;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;

    MainActivity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_presonal_center, container, false);
        ButterKnife.bind(this, layout);
        mContext = (MainActivity) getActivity();
        super.onCreateView(inflater, container, savedInstanceState);
        return layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        User user = FuLiCenterApplication.getUser();
        L.e(TAG,"user="+user);
        if (user==null){
            MFGT.gotoLogin(mContext);
        }else {
            ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user),mContext,mIvUserAvatar);
            mTvUserName.setText(user.getMuserNick());
        }
    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.tv_center_settings,R.id.center_user_info})
    public void gotoSettings(){
        MFGT.gotoSettings(mContext);
    }


}
