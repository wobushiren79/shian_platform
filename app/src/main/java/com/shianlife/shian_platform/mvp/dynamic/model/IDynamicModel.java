package com.shianlife.shian_platform.mvp.dynamic.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicBean;
import com.shianlife.shian_platform.mvp.dynamic.presenter.OnDynamicListener;

/**
 * Created by zm.
 */

public interface IDynamicModel {
    void getDynamicData(Context context, DynamicBean params, OnDynamicListener listener);
}
