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
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginOutResultBean;
import com.shianlife.shian_platform.mvp.login.presenter.IUserLoginPresenter;
import com.shianlife.shian_platform.mvp.login.presenter.impl.UserLoginPresenterImpl;
import com.shianlife.shian_platform.mvp.login.view.IUserLoginOutView;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.SharePerfrenceUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_editorder)
    TextView tvEditorder;

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
    }

    @OnClick(R.id.tv_editorder)
    public void onExit() {
        TipsDialog mDialog = new TipsDialog(this);
        mDialog.setTitle(getString(R.string.setting_exit));
        mDialog.setTopButton(getString(R.string.dialog_true_1), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharePerfrenceUtils.setShareAutoLogin(SettingActivity.this, false);
                AppUtils.jumpLogin(SettingActivity.this);
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

}
