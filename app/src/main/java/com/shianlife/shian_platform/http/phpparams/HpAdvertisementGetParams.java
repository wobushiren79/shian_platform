package com.shianlife.shian_platform.http.phpparams;


import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by Administrator on 2017/4/19.
 */

public class HpAdvertisementGetParams extends BaseHttpParams {

    private int type;
    private int number;
    private int pagerNumber;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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
