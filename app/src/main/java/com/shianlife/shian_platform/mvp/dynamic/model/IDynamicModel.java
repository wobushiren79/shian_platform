package com.shianlife.shian_platform.mvp.dynamic.model;

import android.content.Context;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicBean;

/**
 * Created by zm.
 */

public interface IDynamicModel {
    void getDynamicData(Context context, DynamicBean params, OnGetDataListener listener);
}
