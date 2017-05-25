package com.shianlife.shian_platform.mvp.find.bean;

import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by zm.
 */

public class FindDataBean extends BaseHttpParams {
    private int type;
    private long userid;
    private int siftid;
    private int userType;// (1.殡仪，2公墓,  3平台, 4,其它备用)


    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

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
