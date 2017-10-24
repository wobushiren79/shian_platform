package com.shianlife.shian_platform.common;

import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.login.bean.UserLoginResultBean;

import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;

/**
 * Created by zm.
 */

public class Constants {
    //公墓地址
    public static final String Cemetery_BaseUrl = "http://115.28.163.211:7088/shianlife-advisor-cemetery-1.0-SNAPSHOT";
//    public static final String Cemetery_BaseUrl  = "http://192.168.0.200:8000/shianlife-advisor-cemetery-1.0-SNAPSHOT";


    //登陆地址
//    public static final String Login_BaseUrl = "https://platform.shianlife.cn";
//    public static final String Login_BaseUrl = "http://prd-platform.xicp.cn";
//      public static final String Login_BaseUrl = "http://192.168.0.71:8099/ki4so-web";
    public static final String Login_BaseUrl = "http://192.168.0.86:8080/ki4so-web";

    //单项地址
//    public static final String Store_BaseUrl = "https://goods.shianlife.cn";
//    public static final String Store_BaseUrl = "http://prd-goods.xicp.cn";
//        public static final String Store_BaseUrl = "http://192.168.0.71:8080/goods";
    public static final String Store_BaseUrl = "http://192.168.0.86:8089/goods";

    //分单地址
    public static final String OrderCenter_BaseUrl = "http://192.168.0.86:8090/order";

    //PHP地址
    public static final String PHP_BaseUrl = "http://app.e-funeral.cn";
    //阿里云文件上传
    public static final String FILE_ALIYUN_UPDATA = Cemetery_BaseUrl + "/file/upload";
    //阿里云文件查看地址
    public static final String OSSURL = "http://shianlife123.oss-cn-qingdao.aliyuncs.com/";
    //七牛文件上传
    public static final String FILE_QINIU_UPDATA = Cemetery_BaseUrl + "/fileqiniu/upload";
    //七牛文件查看地址
    public static final String QINIUURL = "http://oq6rkq859.bkt.clouddn.com/";
    //商品地址
//    public static final String Goods_BaseUrl = "http://192.168.0.89/shian_goods";
    public static final String Goods_BaseUrl = "http://goodsmgr.e-funeral.cn";
    //商品图片地址
    public static final String Goods_PicUrl = Goods_BaseUrl + "/Public/Uploads";


    public static final String siftsPHPURL = PHP_BaseUrl + "/home/index/sifts";//精选
    public static final String helpsPHPURL = PHP_BaseUrl + "/home/index/helps";//帮助
    public static final String dynamicsPHPURL = PHP_BaseUrl + "/home/index/dynamics";//动态
    public static final String phonePHPURL = PHP_BaseUrl + "/home/index/phone";//通讯宝
    public static final String DiDichannel = "55455";//滴滴渠道号

    //子系统-单项  登陆地址
    public static final String Login_Store_Url = Store_BaseUrl + "/login_sys_api";
    //子系统-分单  登陆地址
    public static final String Login_OrderCenter_Url = OrderCenter_BaseUrl + "/login_subsystem_api";

    public static String ChannelId = "";

    //平台账号
    public static SystemLoginResultBean systemUser = null;


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

    //默认地图中心
    private final static double mapCenterlatitude = 30.6634450000;
    private final static double mapCenterlongitude = 104.0722210000;


    //登陆系统KEY
    public static String System_Ki4so_Client_Ec;

    //cookie保存
    public static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    //招商图片
    public static final String Cooperation_Pic_1 = "http://ovjs2f1iz.bkt.clouddn.com/index1.png";
    public static final String Cooperation_Pic_2 = "http://ovjs2f1iz.bkt.clouddn.com/index2.png";
    public static final String Cooperation_Pic_3 = "http://ovjs2f1iz.bkt.clouddn.com/index3.png";
}
