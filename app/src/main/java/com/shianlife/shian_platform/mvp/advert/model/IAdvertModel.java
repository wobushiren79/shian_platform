package com.shianlife.shian_platform.mvp.advert.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.advert.bean.AdvertBean;
import com.shianlife.shian_platform.mvp.advert.presenter.OnAdvertListener;

/**
 * Created by zm.
 */

public interface IAdvertModel {
    void getAdvertData(Context context, AdvertBean params, OnAdvertListener listener);
}
