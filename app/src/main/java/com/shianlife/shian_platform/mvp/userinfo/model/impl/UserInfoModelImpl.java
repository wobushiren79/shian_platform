package com.shianlife.shian_platform.mvp.userinfo.model.impl;

import android.content.Context;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.login.bean.SystemLoginResultBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IUserInfoModel;


/**
 * Created by zm.
 */

public class UserInfoModelImpl implements IUserInfoModel {
    @Override
    public void getUserInfoData(Context context, UserInfoBean params, final OnGetDataListener<SystemLoginResultBean.UserObject> listener) {
//        MHttpManagerFactory.getFuneralManager().getUserInfoData(context, new HttpResponseHandler<UserInfoResultBean>() {
//
//            @Override
//            public void onStart(Request request, int id) {
//
//            }
//
//            @Override
//            public void onSuccess(final UserInfoResultBean result) {
//                listener.getDataSuccess(result);
//            }
//
//            @Override
//            public void onError(String message) {
//                listener.getDataFail(message);
//            }
//        });
        if (Constants.systemUser != null && Constants.systemUser.getUserObj() != null) {
            listener.getDataSuccess(Constants.systemUser.getUserObj());
        } else {
            listener.getDataFail("获取个人资料失败");
        }
    }
}
