package app.cn.com.fulicenter.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.cn.com.fulicenter.FuLiCenterApplication;
import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.User;
import app.cn.com.fulicenter.dao.SharePrefrenceUtils;
import app.cn.com.fulicenter.utils.CommonUtils;
import app.cn.com.fulicenter.utils.ImageLoader;
import app.cn.com.fulicenter.utils.MFGT;
import app.cn.com.fulicenter.view.DisplayUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProfileActivity extends BaseActivity {

    @BindView(R.id.iv_user_profile_avatar)
    ImageView mIvUserProfileAvatar;
    @BindView(R.id.tv_user_profile_name)
    TextView mTvUserProfileName;
    @BindView(R.id.tv_user_profile_nick)
    TextView mTvUserProfileNick;

    UserProfileActivity mContext;
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        mContext = this;
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        DisplayUtils.initBackWiththTiltle(mContext,getResources().getString(R.string.user_profile));
    }

    @Override
    protected void initData() {
        user = FuLiCenterApplication.getUser();
        if (user!=null){
            ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user),mContext,mIvUserProfileAvatar);
            mTvUserProfileName.setText(user.getMusername());
            mTvUserProfileNick.setText(user.getMuserNick());
        }else {
            if (user!=null){
                finish();
                return;
            }
            showInfo();
        }
    }



    @Override
    protected void setListener() {

    }

    @OnClick({R.id.layout_user_profile_username, R.id.layout_user_profile_nickname})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_user_profile_avatar:
                break;
            case R.id.layout_user_profile_username:
                CommonUtils.showLongToast(R.string.username_connot_be_modify);
                break;
            case R.id.layout_user_profile_nickname:
                break;
            case R.id.btn_logout:
                logout();
                break;
        }
    }

    private void logout() {
        if (user!=null){
            SharePrefrenceUtils.getInstance(mContext).removeUser();
            FuLiCenterApplication.setUser(null);
            MFGT.gotoMainActivity(mContext);
        }
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showInfo();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_OK && requestCode == I.REQUEST_CODE_NICK){
            CommonUtils.showLongToast(R.string.update_user_nick_success);
        }
    }

    private void showInfo() {
        user  = FuLiCenterApplication.getUser();
        if (user!=null){
            ImageLoader.setAvatar(ImageLoader.getAvatarUrl(user),mContext,mIvUserProfileAvatar);
            mTvUserProfileName.setText(user.getMusername());
            mTvUserProfileNick.setText(user.getMuserNick());
        }
    }
}
