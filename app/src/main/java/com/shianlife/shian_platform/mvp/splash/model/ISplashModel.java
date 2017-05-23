package com.shianlife.shian_platform.mvp.splash.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.splash.presenter.OnSplashListener;

/**
 * Created by zm.
 */

public interface ISplashModel {
    /**
     * 延时跳转
     */
    void delay(int delayTime, final OnSplashListener listener);
}
