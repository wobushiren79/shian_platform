package com.shianlife.shian_platform.mvp.login.presenter;

/**
 * Created by zm.
 */

public interface IUserLoginPresenter {
    /**
     * 登陆公墓
     */
    void loginCemetery();

    /**
     * 退出公墓
     */
    void loginOutCemetery();

    /**
     * 保存配置信息
     */
    void saveLoginConfig();

    /**
     * 获取配置信息
     */
    void getLoginConfig();

}
