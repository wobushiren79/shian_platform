package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.loadbutton.LoadingButton;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginConfig;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements IUserLoginView {

    @BindView(R.id.et_login_username)
    EditText etUsername;
    @BindView(R.id.et_login_password)
    EditText etPassword;
    @BindView(R.id.cb_login_re)
    CheckBox cbLoginRe;
    @BindView(R.id.cb_login_auto)
    CheckBox cbLoginAuto;
    @BindView(R.id.btn_login)
    LoadingButton btnLogin;

    private IUserLoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        btnLogin.setOnClickListener(onViewClicked);
    }

    @Override
    protected void initData() {
        loginPresenter = new UserLoginPresenter(this);
        loginPresenter.getLoginConfig();
    }


    View.OnClickListener onViewClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_login:
                    checkLogin();
                    break;
            }
        }
    };

    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    @Override
    public void setUserName(String userName) {
        etUsername.setText(userName);
    }

    @Override
    public String getPassWord() {
        return etPassword.getText().toString();
    }

    @Override
    public void setPassWord(String passWord) {
        etPassword.setText(passWord);
    }

    @Override
    public Context getContent() {
        return LoginActivity.this;
    }

    @Override
    public void loginSuccess(UserLoginResultBean result) {
        loginPresenter.saveLoginConfig();
        btnLogin.setComplete();
        ToastUtils.showToastLong(getContent(), getString(R.string.login_success));
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFail(String message) {
        btnLogin.setNormal();
        btnLogin.setOnClickListener(onViewClicked);
        ToastUtils.showToastLong(getContent(), message);
    }

    @Override
    public boolean getIsAutoLogin() {
        return cbLoginAuto.isChecked();
    }

    @Override
    public void setIsAutoLogin(boolean isAutoLogin) {
        cbLoginAuto.setChecked(isAutoLogin);
    }

    @Override
    public boolean getIsKeepAccount() {
        return cbLoginRe.isChecked();
    }

    @Override
    public void setIsKeepAccount(boolean isKeepAccount) {
        cbLoginRe.setChecked(isKeepAccount);
    }

    @Override
    public void setLoginConfig() {

    }


    /**
     * 登陆
     */
    private void checkLogin() {
        if (getUserName().isEmpty()) {
            ToastUtils.showToastShort(getContent(), getString(R.string.login_username_empty));
            return;
        }
        if (getPassWord().isEmpty()) {
            ToastUtils.showToastShort(getContent(), getString(R.string.login_password_empty));
            return;
        }
        btnLogin.setLoading();
        btnLogin.setOnClickListener(null);
        loginPresenter.loginCemetery();
    }
}
