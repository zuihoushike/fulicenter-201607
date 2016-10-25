package app.cn.com.fulicenter.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import app.cn.com.fulicenter.FuLiCenterApplication;
import app.cn.com.fulicenter.I;
import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.bean.Result;
import app.cn.com.fulicenter.bean.User;
import app.cn.com.fulicenter.dao.UserDao;
import app.cn.com.fulicenter.net.NetDAO;
import app.cn.com.fulicenter.utils.CommonUtils;
import app.cn.com.fulicenter.utils.L;
import app.cn.com.fulicenter.utils.MFGT;
import app.cn.com.fulicenter.utils.OkHttpUtils;
import app.cn.com.fulicenter.utils.ResultUtils;
import app.cn.com.fulicenter.view.DisplayUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateNickActivity extends BaseActivity {
    private static final String TAG = UpdateNickActivity.class.getSimpleName();

    @BindView(R.id.et_update_user_name)
    EditText mEtUpdateUserName;
    UpdateNickActivity mContext;
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_update_nick);
        ButterKnife.bind(this);
        mContext = this;
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        DisplayUtils.initBackWiththTiltle(mContext,getResources().getString(R.string.update_user_nick));
    }

    @Override
    protected void initData() {
        user = FuLiCenterApplication.getUser();
        if (user!=null){
            mEtUpdateUserName.setText(user.getMuserNick());
            mEtUpdateUserName.setSelectAllOnFocus(true);
        }else {
            finish();
        }
    }

    @Override
    protected void setListener() {

    }

    @OnClick(R.id.btn_save)
    public void checkNick(){
        if (user!=null){
            String nick = mEtUpdateUserName.getText().toString().trim();
            if (nick.equals(user.getMuserNick())){
                CommonUtils.showLongToast(R.string.update_nick_fail_unmodify);
            }else if (TextUtils.isEmpty(nick)){
                CommonUtils.showLongToast(R.string.nick_name_connot_be_empty);
            }else {
                updateNick(nick);
            }
        }
    }

    private void updateNick(String nick) {
        final ProgressDialog pd = new ProgressDialog(mContext);
        pd.setMessage(getResources().getString(R.string.update_user_nick));
        pd.show();
        NetDAO.updateNick(mContext, user.getMusername(), nick, new OkHttpUtils.OnCompleteListener<String>() {
            @Override
            public void onSuccess(String s) {
                Result result = ResultUtils.getResultFromJson(s,User.class);
                L.e(TAG,"result="+result);
                if (result== null){
                    CommonUtils.showLongToast(R.string.update_fail);
                }else {
                    if (result.isRetMsg()){
                        User u= (User) result.getRetData();
                        L.e(TAG,"user="+user);
                        UserDao dao = new UserDao(mContext);
                        boolean isSuccess = dao.updateUser(u);
                        if (isSuccess){
                            FuLiCenterApplication.setUser(u);
                            setResult(RESULT_OK);
                            MFGT.finish(mContext);
                        }else {
                            CommonUtils.showLongToast(R.string.user_database_error);
                        }
                    }else {
                        if (result.getRetCode()== I.MSG_USER_SAME_NICK){
                            CommonUtils.showLongToast(R.string.update_nick_fail_unmodify);
                        }else if (result.getRetCode()==I.MSG_USER_UPDATE_NICK_FAIL){
                            CommonUtils.showLongToast(R.string.update_fail);
                        }else {
                            CommonUtils.showLongToast(R.string.update_fail);
                        }
                    }
                }
                pd.dismiss();
            }

            @Override
            public void onError(String error) {
                pd.dismiss();
                CommonUtils.showLongToast(error);
                L.e(TAG,"error="+error);
            }
        });
    }
}
