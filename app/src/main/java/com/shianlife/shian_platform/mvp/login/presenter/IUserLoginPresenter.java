package com.shianlife.shian_platform.mvp.login.presenter;

/**
 * Created by zm.
 */

public interface IUserLoginPresenter {
    /**
     * 登陆平台
     */
    void loginSystem();

    /**
     * 退出登陸
     */
    void loginOutSystem();

    /**
     * 保存配置信息
     */
    void saveLoginConfig();

    /**
     * 获取配置信息
     */
    void getLoginConfig();


    void loginCemetery();

    void loginOutCemetery();

}
