package com.shianlife.shian_platform.mvp.splash.presenter.impl;

import android.content.Context;

import com.shianlife.shian_platform.mvp.splash.model.ISplashModel;
import com.shianlife.shian_platform.mvp.splash.model.impl.SplashModelImpl;
import com.shianlife.shian_platform.mvp.splash.presenter.ISplashPresenter;
import com.shianlife.shian_platform.mvp.splash.presenter.OnSplashListener;
import com.shianlife.shian_platform.mvp.splash.view.ISplashView;

/**
 * Created by zm.
 */

public class SplashPresenterImpl implements ISplashPresenter {

    private ISplashView splashView;
    private ISplashModel splashModel;

    public SplashPresenterImpl(ISplashView splashView) {
        this.splashView = splashView;
        this.splashModel = new SplashModelImpl();
    }

    @Override
    public void delay() {
        splashModel.delay(splashView.getDelayTime(), new OnSplashListener() {
            @Override
            public void delayOver() {
                splashView.delayOver();
            }
        });
    }
}
