package com.shianlife.shian_platform.mvp.dynamic.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface IDynamicView {
    Context getContext();

    int getPagerSize();

    int getPagerNum();

    void showData(BaseDataResult result);

    void showMsg(String msg);
}
