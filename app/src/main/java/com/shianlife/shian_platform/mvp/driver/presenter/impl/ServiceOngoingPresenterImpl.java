package com.shianlife.shian_platform.mvp.driver.presenter.impl;

import android.content.Context;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IServiceOngoingModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.ServiceOngoingModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IServiceOngoingPresenter;
import com.shianlife.shian_platform.mvp.driver.view.IServiceOngoingRequestView;
import com.shianlife.shian_platform.mvp.driver.view.IServiceOngoingView;
import com.shianlife.shian_platform.utils.ToastUtils;

/**
 * Created by zm.
 */

public class ServiceOngoingPresenterImpl implements IServiceOngoingPresenter {
    IServiceOngoingModel serviceOngoingModel;
    IServiceOngoingView serviceOngoingView;
    IServiceOngoingRequestView serviceOngoingRequestView;

    public ServiceOngoingPresenterImpl(IServiceOngoingRequestView serviceOngoingRequestView) {
        this.serviceOngoingRequestView = serviceOngoingRequestView;
        serviceOngoingModel = new ServiceOngoingModelImpl();
    }

    public ServiceOngoingPresenterImpl(IServiceOngoingView serviceOngoingView) {
        this.serviceOngoingView = serviceOngoingView;
        serviceOngoingModel = new ServiceOngoingModelImpl();
    }

    @Override
    public void saveServiceOngoing() {
        if (serviceOngoingView == null)
            return;
        ServiceOngoingBean params = new ServiceOngoingBean();
        if (serviceOngoingView.getAddress() == null || serviceOngoingView.getAddress().isEmpty()) {
            ToastUtils.showToastShort(serviceOngoingView.getContext(), serviceOngoingView.getContext().getString(R.string.driver_order_check_1));
            return;
        }
        if (serviceOngoingView.getKM() == null || serviceOngoingView.getKM().isEmpty()) {
            ToastUtils.showToastShort(serviceOngoingView.getContext(), serviceOngoingView.getContext().getString(R.string.driver_order_check_2));
            return;
        }
        if (serviceOngoingView.getLayoutType() == 2) {
            if (serviceOngoingView.getFiles() == null || serviceOngoingView.getFiles().isEmpty()) {
                ToastUtils.showToastShort(serviceOngoingView.getContext(), serviceOngoingView.getContext().getString(R.string.driver_order_check_3));
                return;
            }
        }
        params.setOrderId(serviceOngoingView.getOrderId());
        params.setAddress(serviceOngoingView.getAddress());
        params.setLatitude(serviceOngoingView.getLatitude());
        params.setLongitude(serviceOngoingView.getLongitude());
        params.setFiles(serviceOngoingView.getFiles());
        params.setKm(serviceOngoingView.getKM());
        params.setServiceStep(serviceOngoingView.getServiceStep());
        serviceOngoingModel.saveServiceOngoing(serviceOngoingView.getContext(), params, new OnGetDataListener<ServiceOngoingResultBean>() {
            @Override
            public void getDataSuccess(ServiceOngoingResultBean result) {
                serviceOngoingView.saveServiceOngoingSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                serviceOngoingView.saveServiceOngoingFail(msg);
            }
        });
    }

    @Override
    public void saveServiceOngoing(ServiceOngoingBean param) {
        if (serviceOngoingRequestView == null)
            return;
        serviceOngoingModel.saveServiceOngoing(serviceOngoingRequestView.getContext(), param, new OnGetDataListener<ServiceOngoingResultBean>() {
            @Override
            public void getDataSuccess(ServiceOngoingResultBean result) {
                serviceOngoingRequestView.saveServiceOngoingSuccess(result);
            }

            @Override
            public void getDataFail(String msg) {
                serviceOngoingRequestView.saveServiceOngoingFail(msg);
            }
        });
    }
}
