package com.shianlife.shian_platform.mvp.find.presenter.impl;

import android.content.Context;

import com.shianlife.shian_platform.appenum.SystemTypeEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.find.bean.FindBean;
import com.shianlife.shian_platform.mvp.find.bean.FindResultBean;
import com.shianlife.shian_platform.mvp.find.model.IFindModel;
import com.shianlife.shian_platform.mvp.find.model.impl.FindModelImpl;
import com.shianlife.shian_platform.mvp.find.presenter.IFindPresenter;
import com.shianlife.shian_platform.mvp.find.view.IFindView;

/**
 * Created by zm.
 */

public class FindPresenterImpl implements IFindPresenter {
    IFindView findView;
    IFindModel findModel;

    public FindPresenterImpl(IFindView findView) {
        this.findView = findView;
        findModel = new FindModelImpl();
    }

    @Override
    public void getFindData() {
        Context context = findView.getContext();
        FindBean params = new FindBean();
        params.setNumber(findView.getPagerSize());
        params.setPagerNumber(findView.getPagerNum());
        params.setType(findView.getFindType());
        params.setUserid(Constants.userId);
        params.setUserType(SystemTypeEnum.platform.getCode());
        findModel.getFindData(context, params, new OnGetDataListener<FindResultBean>() {
            @Override
            public void getDataSuccess(FindResultBean result) {
                findView.showData(result);
            }

            @Override
            public void getDataFail(String msg) {
                findView.showMsg(msg);
            }
        });
    }
}
