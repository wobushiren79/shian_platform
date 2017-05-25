package com.shianlife.shian_platform.mvp.find.presenter;

import com.shianlife.shian_platform.http.base.BaseDataResult;

/**
 * Created by zm.
 */

public interface OnFindListener {
    void getDataSuccess(BaseDataResult result);

    void getDataFail(String msg);
}
