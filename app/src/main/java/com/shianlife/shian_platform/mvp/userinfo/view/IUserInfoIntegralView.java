package com.shianlife.shian_platform.mvp.userinfo.view;


import com.shianlife.shian_platform.mvp.base.BaseMVPView;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralResultBean;

/**
 * Created by zm.
 */

public interface IUserInfoIntegralView extends BaseMVPView {

    void getUserInfoIntegralSuccess(UserInfoIntegralResultBean resultBean);

    void getUserInfoIntegralFail(String msg);

    void setUserInfoIntegral(Integer integral);

    void setUserInfoContinuousDay(Integer day);

    void setUserInfoCanSign(boolean isSign);
}
