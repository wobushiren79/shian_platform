package com.shianlife.shian_platform.mvp.login.bean;


import com.shianlife.shian_platform.http.base.BaseHttpParams;

/**
 * Created by Administrator on 2017/4/7.
 */

public class UserLoginBean extends BaseHttpParams {
    private String username;
    private String password;
    private String channelId;
    private String systemType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }
}
