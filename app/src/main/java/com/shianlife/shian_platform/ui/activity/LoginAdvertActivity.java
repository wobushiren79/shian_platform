package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.AdvertisementEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.advert.presenter.IAdvertPresenter;
import com.shianlife.shian_platform.mvp.advert.presenter.impl.AdvertPresenterImpl;
import com.shianlife.shian_platform.mvp.advert.view.IAdvertView;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginAdvertActivity extends BaseActivity implements IAdvertView {

    @BindView(R.id.iv_advert)
    ImageView ivAdvert;
    @BindView(R.id.bt_jump)
    Button btJump;
    @BindView(R.id.ll_advert)
    RelativeLayout llAdvert;


    public final static int LOGIN = 0;//結束之後需登陸
    public final static int MAIN = 1;//结束之后无需登录

    private int type = -1;
    private boolean isForceOver = false;//是否强制结束
    private int advertSleepTime = 5000;//廣告暫停時間
    private AdvertResultBean.AdvertisementData advertData;
    private Timer timerIntent;//定时跳转

    private IAdvertPresenter advertPresenter;
    private int pagerSize = 1;
    private int pagerNum = 0;
    private int advertType = AdvertisementEnum.LOADING.getCode();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_advert);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isForceOver = true;
    }

    @Override
    public void initView() {
        llAdvert.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {
        type = getIntent().getIntExtra(IntentUtils.INTENT_ADEVERT, -1);
        advertPresenter = new AdvertPresenterImpl(this);
        advertPresenter.getAdvertData();
    }


    private void startThread() {
        timerIntent = new Timer();
        timerIntent.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isForceOver) {
                    checkAndJump();
                }
            }
        }, advertSleepTime);
    }


    private void checkAndJump() {
        if (type == LOGIN) {
            jumpLogin();
        } else if (type == MAIN) {
            jumpMain();
        }
        finish();
    }

    private void jumpMain() {
        new IntentUtils.Build(this, MainActivity.class).start();
    }

    private void jumpLogin() {
        new IntentUtils.Build(this, LoginActivity.class).start();
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public int getAdvertType() {
        return advertType;
    }

    @Override
    public int getPagerSize() {
        return pagerSize;
    }

    @Override
    public int getPagerNum() {
        return pagerNum;
    }

    @Override
    public void showData(AdvertResultBean result) {
        if (result.getItems() != null && result.getItems().size() > 0) {
            llAdvert.setVisibility(View.VISIBLE);
            advertData = result.getItems().get(0);
            AppUtils.loadPic(this, ivAdvert, Constants.PHP_BaseUrl + result.getItems().get(0).getBanner());
            startThread();
        } else {
            checkAndJump();
        }
    }

    @Override
    public void showMsg(String msg) {
        checkAndJump();
        llAdvert.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.iv_advert, R.id.bt_jump})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_advert:
                if (advertData == null)
                    return;
                if (timerIntent != null)
                    timerIntent.cancel();
                isForceOver = true;
                checkAndJump();
                new IntentUtils.Build(this, WebActivity.class)
                        .setString(IntentUtils.INTENT_URL, advertData.getUrl())
                        .start();

                break;
            case R.id.bt_jump:
                if (timerIntent != null)
                    timerIntent.cancel();
                isForceOver = true;
                checkAndJump();
                break;
        }
    }
}
