package com.shianlife.shian_platform.mvp.driver.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;

/**
 * Created by zm.
 */

public interface IServiceOngoingView {
    Context getContext();

    void saveServiceOngoingSuccess(ServiceOngoingResultBean result);

    void saveServiceOngoingFail(String msg);

    Long getOrderId( );

    String getLongitude( );

    String getLatitude( );

    String getAddress();

    String getFiles();//图片文件，注：以‘,’分隔


    String getKM();

    int getServiceStep();//服务步骤， 值：0待派车 1已分配/待接单 2待取车 3待出发 4去接人 5等上车 6已上车 7已送达 8成功服务

    int getLayoutType();//1没有图片布局，2有图片布局
}
