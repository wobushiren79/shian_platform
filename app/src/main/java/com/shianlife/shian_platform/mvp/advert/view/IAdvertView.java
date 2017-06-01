package com.shianlife.shian_platform.mvp.advert.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;

/**
 * Created by zm.
 */

public interface IAdvertView {
    Context getContext();

    int getAdvertType();

    int getPagerSize();

    int getPagerNum();

    void showData(AdvertResultBean result);

    void showMsg(String msg);
}
