package com.shianlife.shian_platform.mvp.order.view;

import android.content.Context;

import com.shianlife.shian_platform.mvp.order.bean.GoodsOrderItem;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsResultBean;

import java.util.List;
import java.util.Map;

/**
 * Created by zm.
 */

public interface IStoreOrderDetailsView {
    Context getContext();

    void getStoreOrderDetailsSuccess(StoreOrderDetailsResultBean resultBean);

    void getStoreOrderDetailsFail(String msg);

    Long getOrderId();

    void showToast(String msg);


    void setCustomerName(String name);

    void setCustomerPhone(String phone);

    void setServiceLocation(String location);

    void setServiceTime(String time);

    void setGoodsItemNumber(String number);

    void setGoodsListData(Map<String, List<GoodsOrderItem>> listData);

}
