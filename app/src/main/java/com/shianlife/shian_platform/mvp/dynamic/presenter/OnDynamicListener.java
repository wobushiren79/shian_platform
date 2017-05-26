package com.shianlife.shian_platform.mvp.dynamic.presenter;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface OnDynamicListener {
    void getDataSuccess(BaseDataResult result);

    void getDataFail(String msg);
}
