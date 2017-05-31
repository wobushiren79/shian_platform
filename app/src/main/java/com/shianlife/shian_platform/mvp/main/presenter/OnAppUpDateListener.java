package com.shianlife.shian_platform.mvp.main.presenter;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface OnAppUpDateListener {
    void getAppUpDateSuccess(BaseDataResult result);

    void getAppUpDateFail(String msg);
}
