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
     * 保存配置信息
     */
    void saveLoginConfig();

    /**
     * 获取配置信息
     */
    void getLoginConfig();

}
