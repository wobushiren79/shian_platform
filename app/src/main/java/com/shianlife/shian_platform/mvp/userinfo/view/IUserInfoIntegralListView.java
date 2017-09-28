package com.shianlife.shian_platform.mvp.userinfo.view;


import com.shianlife.shian_platform.mvp.base.BaseMVPView;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListResultBean;

/**
 * Created by zm.
 */

public interface IUserInfoIntegralListView extends BaseMVPView {

    void getIntegralListSuccess(UserInfoIntegralListResultBean resultBean);

    void getIntegralListFail(String msg);

    Integer getPageNumber();

    Integer getPageSize();

}
