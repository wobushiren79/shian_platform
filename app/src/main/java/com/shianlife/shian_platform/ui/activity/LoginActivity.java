package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.view.loadbutton.LoadingButton;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenterImpl;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginView;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.mvp.main.presenter.IAppUpDatePresenter;
import com.shianlife.shian_platform.mvp.main.presenter.impl.AppUpDatePresenterImpl;
import com.shianlife.shian_platform.mvp.main.view.IAppUpDateView;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.CheckUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements IUserLoginView, IAppUpDateView {

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

    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.tv_no_password)
    TextView tvNoPassword;


    private IUserLoginPresenter loginPresenter;
    private IAppUpDatePresenter appUpDatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        btnLogin.setOnClickListener(onViewClicked);
        tvForgetPassword.setOnClickListener(onViewClicked);
        tvNoPassword.setOnClickListener(onViewClicked);
    }

    @Override
    protected void initData() {
        loginPresenter = new UserLoginPresenterImpl(this, null);
        loginPresenter.getLoginConfig();

        appUpDatePresenter = new AppUpDatePresenterImpl(this);
        appUpDatePresenter.getAppUpDateInfo();
    }


    View.OnClickListener onViewClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_login:
                    checkLogin();
                    break;
                case R.id.tv_forget_password:
                    forgetPassWord();
                    break;
                case R.id.tv_no_password:
                    noPassWord();
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
    public Context getContext() {
        return LoginActivity.this;
    }

    @Override
    public void getAppUpDateInfoSuccess(AppUpDateResultBean result) {
        CheckUtils.checkAppUpDate(this, result, false);
    }

    @Override
    public void getAppUpDateInfoFail(String msg) {

    }

    @Override
    public void loginSystemSuccess(SystemLoginResultBean result) {
        Constants.systemUser = result;
        loginPresenter.saveLoginConfig();
        btnLogin.setComplete();
        new IntentUtils.Build(LoginActivity.this, MainActivity.class).start();
        finish();
//        ToastUtils.showToastLong(getContext(), getString(R.string.login_success));
    }

    @Override
    public void loginSystemFail(String message) {
        btnLogin.setNormal();
        btnLogin.setOnClickListener(onViewClicked);
        ToastUtils.showToastLong(getContext(), message);
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


    /**
     * 登陆
     */
    private void checkLogin() {
        if (getUserName().isEmpty()) {
            ToastUtils.showToastShort(getContext(), getString(R.string.login_username_empty));
            return;
        }
        if (getPassWord().isEmpty()) {
            ToastUtils.showToastShort(getContext(), getString(R.string.login_password_empty));
            return;
        }
        btnLogin.setLoading();
        btnLogin.setOnClickListener(null);
        loginPresenter.loginSystem();
    }


    /**
     * 忘记密码
     */
    private void forgetPassWord() {
        Intent intent = new Intent(this, LoginPhoneActivity.class);
        startActivity(intent);
    }

    /**
     * 没有密码
     */
    private void noPassWord() {
        Intent intent = new Intent(this, PicShowActivity.class);
        ArrayList<String> listData = new ArrayList<>();
        listData.add(Constants.Cooperation_Pic_1);
        listData.add(Constants.Cooperation_Pic_2);
        listData.add(Constants.Cooperation_Pic_3);
        intent.putExtra(IntentUtils.INTENT_LIST_DATA, listData);
        intent.putExtra(IntentUtils.INTENT_DATA, "招商");
        startActivity(intent);
    }
}
