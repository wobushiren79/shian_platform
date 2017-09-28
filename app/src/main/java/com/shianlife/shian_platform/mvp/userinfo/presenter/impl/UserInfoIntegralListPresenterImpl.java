package com.shianlife.shian_platform.mvp.userinfo.presenter.impl;


import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListBean;
import com.shianlife.shian_platform.mvp.userinfo.bean.UserInfoIntegralListResultBean;
import com.shianlife.shian_platform.mvp.userinfo.model.IUserInfoIntegralListModel;
import com.shianlife.shian_platform.mvp.userinfo.model.impl.UserInfoIntegralListModelImpl;
import com.shianlife.shian_platform.mvp.userinfo.presenter.IUserInfoIntegralListPresenter;
import com.shianlife.shian_platform.mvp.userinfo.view.IUserInfoIntegralListView;

/**
 * Created by zm.
 */

public class UserInfoIntegralListPresenterImpl implements IUserInfoIntegralListPresenter {
    private IUserInfoIntegralListView userInfoIntegralListView;
    private IUserInfoIntegralListModel userInfoIntegralListModel;

    public UserInfoIntegralListPresenterImpl(IUserInfoIntegralListView userInfoIntegralListView) {
        this.userInfoIntegralListView = userInfoIntegralListView;
        userInfoIntegralListModel = new UserInfoIntegralListModelImpl();
    }

    @Override
    public void getIntegralList() {
        if (userInfoIntegralListView.getContext() == null) {
            userInfoIntegralListView.showToast("数据错误");
            return;
        }

        if (userInfoIntegralListView.getPageNumber() == null) {
            userInfoIntegralListView.showToast("没有页数");
            return;
        }
        if (userInfoIntegralListView.getPageSize() == null) {
            userInfoIntegralListView.showToast("没有页大小");
            return;
        }
        UserInfoIntegralListBean params = new UserInfoIntegralListBean();
        params.setPageSize(userInfoIntegralListView.getPageSize());
        params.setPageNumber(userInfoIntegralListView.getPageNumber());
        userInfoIntegralListModel.getIntegralList(userInfoIntegralListView.getContext(), params, new OnGetDataListener<UserInfoIntegralListResultBean>() {
            @Override
            public void getDataSuccess(UserInfoIntegralListResultBean result) {
                userInfoIntegralListView.getIntegralListSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                userInfoIntegralListView.getIntegralListFail(msg);
            }
        });
    }
}
