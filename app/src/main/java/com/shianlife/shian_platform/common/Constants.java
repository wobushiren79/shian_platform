package com.shianlife.shian_platform.common;

import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

/**
 * Created by zm.
 */

public class Constants {
    //公墓地址
    public static final String CEMETERY_URL = "http://115.28.163.211:7088/shianlife-advisor-cemetery-1.0-SNAPSHOT";
    //PHP地址
    public static final String PHP_URL = "http://app.e-funeral.cn";

    public static final String siftsPHPURL = PHP_URL + "/home/index/sifts";//精选
    public static final String helpsPHPURL = PHP_URL + "/home/index/helps";//帮助
    public static final String dynamicsPHPURL = PHP_URL + "/home/index/dynamics";//动态
    public static final String phonePHPURL = PHP_URL + "/home/index/phone";//通讯宝
    public static final String DiDichannel = "55455";//滴滴渠道号

    //公墓账号
    public static UserLoginResultBean userCemetery = null;
    //跳转页停留时间
    public static long SPLASH_TIME = 2000;
}
