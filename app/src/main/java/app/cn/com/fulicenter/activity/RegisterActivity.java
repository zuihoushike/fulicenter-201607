package app.cn.com.fulicenter.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import app.cn.com.fulicenter.R;
import app.cn.com.fulicenter.view.DisplayUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.nickname)
    EditText nickname;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.confirmPassword)
    EditText confirmPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        DisplayUtils.initBackWiththTiltle(this,"账户注册");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }
}
