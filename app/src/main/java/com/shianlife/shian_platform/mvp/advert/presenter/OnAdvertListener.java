package com.shianlife.shian_platform.mvp.advert.presenter;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface OnAdvertListener {
    void getDataSuccess(BaseDataResult result);

    void getDataFail(String msg);
}
