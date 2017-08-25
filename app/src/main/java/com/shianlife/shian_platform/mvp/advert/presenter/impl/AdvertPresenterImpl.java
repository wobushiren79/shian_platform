package com.shianlife.shian_platform.mvp.advert.presenter.impl;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertBean;
import com.shianlife.shian_platform.mvp.advert.bean.AdvertResultBean;
import com.shianlife.shian_platform.mvp.advert.model.IAdvertModel;
import com.shianlife.shian_platform.mvp.advert.model.impl.AdvertModelImpl;
import com.shianlife.shian_platform.mvp.advert.presenter.IAdvertPresenter;
import com.shianlife.shian_platform.mvp.advert.view.IAdvertView;

/**
 * Created by zm.
 */

public class AdvertPresenterImpl implements IAdvertPresenter {
    IAdvertModel advertModel;
    IAdvertView advertView;

    public AdvertPresenterImpl(IAdvertView advertView) {
        this.advertView = advertView;
        advertModel = new AdvertModelImpl();
    }


    @Override
    public void getAdvertData() {
        AdvertBean params = new AdvertBean();
        params.setType(advertView.getAdvertType());
        params.setNumber(advertView.getPagerSize());
        params.setPagerNumber(advertView.getPagerNum());
        advertModel.getAdvertData(advertView.getContext(), params, new OnGetDataListener<AdvertResultBean>() {

            @Override
            public void getDataSuccess(AdvertResultBean result) {
                advertView.showData(result);
            }

            @Override
            public void getDataFail(String msg) {
                advertView.showMsg(msg);
            }
        });
    }
}
