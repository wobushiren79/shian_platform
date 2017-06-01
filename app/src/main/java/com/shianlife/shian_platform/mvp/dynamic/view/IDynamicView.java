package com.shianlife.shian_platform.mvp.dynamic.view;

import android.content.Context;

import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;

/**
 * Created by zm.
 */

public interface IDynamicView {
    Context getContext();

    int getPagerSize();

    int getPagerNum();

    void showData(DynamicResultBean result);

    void showMsg(String msg);
}
