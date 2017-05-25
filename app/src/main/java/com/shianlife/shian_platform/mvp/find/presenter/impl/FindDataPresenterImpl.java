package com.shianlife.shian_platform.mvp.find.presenter.impl;

import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.find.bean.FindDataBean;
import com.shianlife.shian_platform.mvp.find.model.IFindDataModel;
import com.shianlife.shian_platform.mvp.find.model.impl.FindDataModelImpl;
import com.shianlife.shian_platform.mvp.find.presenter.IFindDataPresenter;
import com.shianlife.shian_platform.mvp.find.presenter.OnFindDataListener;
import com.shianlife.shian_platform.mvp.find.view.IFindDataView;

/**
 * Created by zm.
 */

public class FindDataPresenterImpl implements IFindDataPresenter {
    IFindDataView findDataView;
    IFindDataModel findDataModel;

    public FindDataPresenterImpl(IFindDataView findDataView) {
        this.findDataView = findDataView;
        findDataModel = new FindDataModelImpl();
    }

    @Override
    public void saveData(int type, int findId) {
        FindDataBean params = new FindDataBean();
        params.setType(findDataView.getChangeType());
        params.setSiftid(findDataView.getSiftid());
        params.setUserid(Constants.userCemetery.getUserId());
        findDataModel.saveData(findDataView.getContext(), params, new OnFindDataListener() {
            @Override
            public void changeDataSuccess() {
                findDataView.changeSuccess();
            }

            @Override
            public void changeDataFail(String msg) {
                findDataView.changeFail(msg);
            }
        });
    }

}
