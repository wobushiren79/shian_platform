package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginOutView;
import com.shianlife.shian_platform.utils.SharePerfrenceUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity implements IUserLoginOutView {

    @BindView(R.id.tv_editorder)
    TextView tvEditorder;

    private IUserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_setting), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        userLoginPresenter = new UserLoginPresenter(this);
    }

    @OnClick(R.id.tv_editorder)
    public void onExit() {
        TipsDialog mDialog = new TipsDialog(this);
        mDialog.setTitle(getString(R.string.setting_exit));
        mDialog.setTopButton(getString(R.string.dialog_true_1), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userLoginPresenter.loginOutCemetery();
                SharePerfrenceUtils.setShareAutoLogin(SettingActivity.this, false);
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        mDialog.setBottomButton(getString(R.string.dialog_false_1), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        mDialog.show();
    }

    @Override
    public Context getContent() {
        return this;
    }

    @Override
    public void loginSuccess(UserLoginResultBean result) {

    }

    @Override
    public void loginFail(String message) {

    }
}
