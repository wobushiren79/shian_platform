package com.shianlife.shian_platform.mvp.order.model;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.OrderShowResultBean;

/**
 * Created by zm.
 */

public interface IOrderShowModel {
    void getOrderShowItems(OnGetDataListener<OrderShowResultBean> listener);
}
