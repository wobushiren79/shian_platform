package com.shianlife.shian_platform.mvp.userinfo.view;


import com.shianlife.shian_platform.mvp.base.BaseMVPView;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoSignResultBean;

/**
 * Created by zm.
 */

public interface IUserInfoSignView extends BaseMVPView {
    void userInfoSignSuccess(UserInfoSignResultBean resultBean);

    void userInfoSignFail(String msg);
}
