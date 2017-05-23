package com.shianlife.shian_platform.http.phpparams;


import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by Administrator on 2017/4/19.
 */

public class HpDynamicGetParams extends BaseHttpParams {
    private int number;
    private int pagerNumber;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPagerNumber() {
        return pagerNumber;
    }

    public void setPagerNumber(int pagerNumber) {
        this.pagerNumber = pagerNumber;
    }
}
