package com.shianlife.shian_platform.ui.order.driver;

import android.content.Context;

import com.shianlife.shian_platform.base.BaseOrderListLayout;

/**
 * Created by zm.
 */

public abstract class BaseDriverLayout extends BaseOrderListLayout {
     CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public BaseDriverLayout(Context context, int layoutId) {
        super(context, layoutId);
    }

    public interface CallBack {
        void refeshAll();
    }
}
