package com.shianlife.shian_platform.mvp.order.model.impl;

import com.shianlife.shian_platform.appenum.OrderItemShowEnum;
import com.shianlife.shian_platform.appenum.RoleEnum;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.OrderShowResultBean;
import com.shianlife.shian_platform.mvp.order.model.IOrderShowModel;
import com.shianlife.shian_platform.ui.activity.StoreOrderAuditListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zm.
 */

public class OrderShowModelImpl implements IOrderShowModel {
    @Override
    public void getOrderShowItems(OnGetDataListener<OrderShowResultBean> listener) {
        OrderShowResultBean resultBean = new OrderShowResultBean();
        List<OrderShowResultBean.Item> listData = new ArrayList<>();

//        listData.add(getItem(OrderItemShowEnum.funeral));
        if (Constants.systemUser != null) {
            for (String role : Constants.systemUser.getResourceCodes()) {
                if (role.equals(RoleEnum.Goods_Audit.getCode())) {
                    listData.add(getItem(OrderItemShowEnum.store, StoreOrderAuditListActivity.class));
                }
            }
        }

        resultBean.setList(listData);
        listener.getDataSuccess(resultBean);
    }

    private OrderShowResultBean.Item getItem(OrderItemShowEnum itemShowEnum, Class cls) {
        OrderShowResultBean.Item item = new OrderShowResultBean.Item();
        item.setName(itemShowEnum.getName());
        item.setPicId(itemShowEnum.getItemPic());
        item.setIntentClass(cls);
        return item;
    }
}
