package com.shianlife.shian_platform.http.phpparams;


import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by Administrator on 2017/4/19.
 */

public class HpFindSaveParams extends BaseHttpParams {


    private int type;
    private long userid;
    private int siftid;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public int getSiftid() {
        return siftid;
    }

    public void setSiftid(int siftid) {
        this.siftid = siftid;
    }
}
