package com.shianlife.shian_platform.mvp.find.presenter.impl;

import com.shianlife.shian_platform.appenum.SystemTypeEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.find.bean.FindDataBean;
import com.shianlife.shian_platform.mvp.find.bean.FindDataResultBean;
import com.shianlife.shian_platform.mvp.find.model.IFindDataModel;
import com.shianlife.shian_platform.mvp.find.model.impl.FindDataModelImpl;
import com.shianlife.shian_platform.mvp.find.presenter.IFindDataPresenter;
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
        if (Constants.systemUser == null || Constants.systemUser.getUserId() == null)
            return;
        FindDataBean params = new FindDataBean();
        params.setType(findDataView.getChangeType());
        params.setSiftid(findDataView.getSiftid());
        params.setUserid(Constants.systemUser.getUserId());
        params.setUserType(SystemTypeEnum.platform.getCode());
        findDataModel.saveData(findDataView.getContext(), params, new OnGetDataListener<FindDataResultBean>() {
            @Override
            public void getDataSuccess(FindDataResultBean result) {
                findDataView.changeSuccess();
            }

            @Override
            public void getDataFail(String msg) {
                findDataView.changeFail(msg);
            }
        });
    }

}
