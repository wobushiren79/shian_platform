package com.shianlife.shian_platform.mvp.splash.view;

import android.content.Context;

/**
 * Created by zm.
 */

public interface ISplashView {
    Context getContext();

    int getDelayTime();

    void delayOver(int typeNum);
}
