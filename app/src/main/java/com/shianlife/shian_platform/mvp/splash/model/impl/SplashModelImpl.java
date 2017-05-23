package com.shianlife.shian_platform.mvp.splash.model.impl;

import android.content.Context;
import android.content.Intent;

import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.mvp.splash.model.ISplashModel;
import com.shianlife.shian_platform.mvp.splash.presenter.OnSplashListener;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zm.
 */

public class SplashModelImpl implements ISplashModel {

    @Override
    public void delay(int delayTime, final OnSplashListener listener) {
        Observable.timer(delayTime, TimeUnit.SECONDS).subscribe(new Observer<Long>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                listener.delayOver();
            }

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }
        });
    }
}
