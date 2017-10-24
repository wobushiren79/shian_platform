package com.shianlife.shian_platform.mvp.store.model;

import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.store.bean.OrderShowResultBean;

/**
 * Created by zm.
 */

public interface IOrderShowModel {
    void getOrderShowItems(OnGetDataListener<OrderShowResultBean> listener);
}
