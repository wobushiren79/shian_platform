package com.shianlife.shian_platform.http.phpparams;


import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class HpGetVersion extends BaseHttpParams {
    int appId;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }
}
