package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.TakeCarBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakeCarResultBean;
import com.shianlife.shian_platform.mvp.driver.model.ITakeCarModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.TakeCarModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.ITakeCarPresenter;
import com.shianlife.shian_platform.mvp.driver.view.ITakeCarView;

/**
 * Created by zm.
 */

public class TalkCarPresenterImpl implements ITakeCarPresenter {
    ITakeCarModel takeCarModel;
    ITakeCarView takeCarView;

    public TalkCarPresenterImpl(ITakeCarView takeCarView) {
        this.takeCarView = takeCarView;
        takeCarModel = new TakeCarModelImpl();
    }

    @Override
    public void saveTakeCarData() {
        TakeCarBean params = new TakeCarBean();
        takeCarModel.saveTakeCarData(takeCarView.getContext(), params, new OnGetDataListener<TakeCarResultBean>() {
            @Override
            public void getDataSuccess(TakeCarResultBean result) {
                takeCarView.saveTalkCarDataSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                takeCarView.saveTalkCarDataFail(msg);
            }
        });
    }
}
