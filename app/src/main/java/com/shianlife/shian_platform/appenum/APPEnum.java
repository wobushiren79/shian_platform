package com.shianlife.shian_platform.appenum;


import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.common.Constants;

/**
 * Created by Administrator on 2017/3/6.
 */

public enum APPEnum {
    ALL("全部应用", R.drawable.zhy_myapp_allapp, "all"),//其他APP
    ZSPROJECT("治丧产品", R.drawable.zhy_myapp_zsproject, "http://m.e-funeral.cn/Plan/index.html"),//治丧产品
    CEMETERY("公墓", R.drawable.zhy_myapp_cemetery, "http://m.e-funeral.cn/Goods/index.html"),//公墓
    BEFORECONTRACT("培训", R.drawable.zhy_myapp_beforecontract, "https://mp.weixin.qq.com/mp/homepage?__biz=MzIwNjgyNTcxNQ==&hid=6&sn=7cb3c4cb1c791fbeb79c0784d4da859a&scene=18#wechat_redirect"),//培训
    MICROMALL("微商城", R.drawable.zhy_myapp_micromall, "https://kdt.im/AHSojr"),//微商城
    NAVIGATION("导航", R.drawable.zhy_myapp_navigation, "navigation"),//导航
    CALENDAR("万年历", R.drawable.zhy_myapp_calendar, "calendar"),//万年历
    CALCULATOR("计算器", R.drawable.zhy_myapp_calculator, "calculator"),//计算器
    COMMUNICATION("通讯宝", R.drawable.zhy_myapp_phone, Constants.phonePHPURL),//通讯宝
    DIDI("滴滴打车", R.drawable.zhy_myapp_didi, "http://webapp.diditaxi.com.cn"),//
    INTEGRALMALL("积分商城", R.drawable.zhy_myapp_integralmall, ""), //积分商城
    VRCEMETERY("VR看墓", R.drawable.zhy_myapp_vrcemetery, "http://x.eqxiu.com/s/c47nsoiO"); //VR看墓

    private String name;
    private int picId;
    private String url;

    private APPEnum(String name, int picId, String url) {
        this.name = name;
        this.picId = picId;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
