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
    //阿里云文件上传
    public static final String FILE_ALIYUN_UPDATA = CEMETERY_URL + "/file/upload";
    //阿里云文件查看地址
    public static final String OSSURL = "http://shianlife123.oss-cn-qingdao.aliyuncs.com/";
    //七牛文件上传
    public static final String FILE_QINIU_UPDATA = CEMETERY_URL + "/fileqiniu/upload";
    //七牛文件查看地址
    public static final String QINIUURL = "http://oq6rkq859.bkt.clouddn.com/";

    public static final String siftsPHPURL = PHP_URL + "/home/index/sifts";//精选
    public static final String helpsPHPURL = PHP_URL + "/home/index/helps";//帮助
    public static final String dynamicsPHPURL = PHP_URL + "/home/index/dynamics";//动态
    public static final String phonePHPURL = PHP_URL + "/home/index/phone";//通讯宝
    public static final String DiDichannel = "55455";//滴滴渠道号

    //公墓账号
    public static UserLoginResultBean userCemetery = null;
    //当前的sessionId
    public static String sessionId = null;
    //当前的用户ID
    public static long userId;

    //跳转页停留时间
    public static long SPLASH_TIME = 2000;

    //客户电话
    public static String helpPhone = "4009679678";


    public static String LocalString;
    public static String LOCAL_PROVINCE = "";
    public static String LOCAL_CITY = "";
    public static String LOCAL_COUNTY = "";
    public static String LOCAL_STREET = "";
    public static String LOCAL_STREETNUM = "";
    public static String LOCAL_ADDRESS = "";
    public static double LOCAL_latitude = 30.6634450000;//纬度;
    public static double LOCAL_longitude = 104.0722210000;//经度;
}
