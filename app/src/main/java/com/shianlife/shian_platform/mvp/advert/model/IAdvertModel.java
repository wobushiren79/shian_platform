package com.shianlife.shian_platform.mvp.advert.model;

import android.content.Context;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertBean;

/**
 * Created by zm.
 */

public interface IAdvertModel {
    void getAdvertData(Context context, AdvertBean params, OnGetDataListener listener);
}
