package com.shianlife.shian_platform.mvp.advert.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface IAdvertView {
    Context getContext();

    int getAdvertType();

    int getPagerSize();

    int getPagerNum();

    void showData(BaseDataResult result);

    void showMsg(String msg);
}
