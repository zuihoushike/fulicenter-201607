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
import app.cn.com.fulicenter.bean.MessageBean;
import app.cn.com.fulicenter.bean.Result;
import app.cn.com.fulicenter.bean.User;
import app.cn.com.fulicenter.dao.UserDao;
import app.cn.com.fulicenter.net.NetDAO;
import app.cn.com.fulicenter.net.OkHttpUtils;
import app.cn.com.fulicenter.utils.ImageLoader;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.MFGT;
import app.cn.com.fulicenter.utils.ResultUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 最后时刻 on 2016/10/26.
 */

public class PersonalCenterFragment extends BaseFragment {
    private static final String TAG = PersonalCenterFragment.class.getSimpleName();
    @BindView(R.id.iv_user_avatar)
    ImageView mIvUserAvatar;
    @BindView(R.id.tv_user_name)
    TextView mTvUserName;

    User user = null;
    @BindView(R.id.tv_collect_count)
    TextView mTvCollectCount;
    MainActivity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_presonal_center,container,false);
        ButterKnife.bind(this,layout);
        mContext = (MainActivity) getActivity();
        super.onCreateView(inflater, container, savedInstanceState);
        return layout;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        user = FuLiCenterApplication.getUser();
        L.e(TAG,"user="+user);
        if (user==null){
            MFGT.gotoLogin(mContext);
        }else {
            ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user),mContext,mIvUserAvatar);
            mTvUserName.setText(user.getMuserNick());
            syncUserInfo();
            syncCollectsCount();
        }
    }

    private void syncUserInfo(){
        NetDAO.syncUserInfo(mContext, user.getMuserName(), new OkHttpUtils.OnCompleteListener<String>() {
            @Override
            public void onSuccess(String s) {
                Result result = ResultUtils.getResultFromJson(s, User.class);
                if(result!=null){
                    User u = (User) result.getRetData();
                    if(!user.equals(u)){
                        UserDao dao = new UserDao(mContext);
                        boolean b = dao.saveUser(u);
                        if(b){
                            FuLiCenterApplication.setUser(u);
                            user = u;
                            ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user), mContext, mIvUserAvatar);
                            mTvUserName.setText(user.getMuserNick());
                        }
                    }
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    protected void setListener() {

    }

    @OnClick(R.id.tv_center_settings)
    public void onClick(){

    }


    private void syncCollectsCount() {
        NetDAO.getCollectsCount(mContext, user.getMuserName(), new OkHttpUtils.OnCompleteListener<MessageBean>() {
            @Override
            public void onSuccess(MessageBean result) {
                if (result != null && result.isSuccess()) {
                    mTvCollectCount.setText(result.getMsg());
                }else{
                    mTvCollectCount.setText(String.valueOf(0));
                }
            }

            @Override
            public void onError(String error) {
                mTvCollectCount.setText(String.valueOf(0));
                L.e(TAG,"error="+error);
            }
        });
    }
}
