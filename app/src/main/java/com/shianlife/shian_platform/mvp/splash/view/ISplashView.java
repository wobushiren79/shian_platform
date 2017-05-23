package com.shianlife.shian_platform.mvp.splash.view;

import android.content.Context;

/**
 * Created by zm.
 */

public interface ISplashView {


    Context getContent();

    Class<?> getIntentClass();

    int getDelayTime();

    void delayOver();
}
