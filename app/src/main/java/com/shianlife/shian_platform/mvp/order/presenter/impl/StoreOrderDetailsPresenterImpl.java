package com.shianlife.shian_platform.mvp.order.presenter.impl;

import android.support.annotation.NonNull;

import com.shianlife.shian_platform.common.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrder;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrderItem;
import com.shianlife.shian_platform.mvp.order.bean.GoodsServiceInfo;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsBean;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.order.model.IStoreOrderDetailsModel;
import com.shianlife.shian_platform.mvp.order.model.impl.StoreOrderDetailsModelImpl;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreOrderDetailsPresenter;
import com.shianlife.shian_platform.mvp.order.view.IStoreOrderDetailsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by zm.
 */

public class StoreOrderDetailsPresenterImpl implements IStoreOrderDetailsPresenter {
    IStoreOrderDetailsView storeOrderDetailsView;
    IStoreOrderDetailsModel storeOrderDetailsModel;


    public StoreOrderDetailsPresenterImpl(IStoreOrderDetailsView storeOrderDetailsView) {
        this.storeOrderDetailsView = storeOrderDetailsView;
        storeOrderDetailsModel = new StoreOrderDetailsModelImpl();
    }

    @Override
    public void getStoreOrderDetails() {
        StoreOrderDetailsBean params = new StoreOrderDetailsBean();
        if (storeOrderDetailsView.getOrderId() == null || storeOrderDetailsView.getOrderId() == -1) {
            storeOrderDetailsView.showToast("数据错误");
            return;
        }
        params.setOrderId(storeOrderDetailsView.getOrderId());
        storeOrderDetailsModel.getStoreOrderDetails(storeOrderDetailsView.getContext(), params, new OnGetDataListener<StoreOrderDetailsResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderDetailsResultBean result) {
                storeOrderDetailsView.getStoreOrderDetailsSuccess(result);

                GoodsServiceInfo goodsServiceInfo = result.getGoodsServiceInfo();
                GoodsOrder goodsOrder = result.getGoodsOrder();
                List<GoodsOrderItem> goodsOrderItem = result.getGoodsOrderItem();
                if (goodsServiceInfo == null
                        || goodsOrder == null
                        || goodsOrderItem == null) {
                    storeOrderDetailsView.showToast("数据错误");
                    return;
                }

                storeOrderDetailsView.setCustomerName(goodsServiceInfo.getContact());
                storeOrderDetailsView.setCustomerPhone(goodsServiceInfo.getContactPhone());
                storeOrderDetailsView.setServiceLocation(goodsServiceInfo.getServiceLocation());
                storeOrderDetailsView.setServiceTime(goodsServiceInfo.getBookTime());
                storeOrderDetailsView.setGoodsItemNumber(goodsOrderItem.size() + "");

                Map<String, List<GoodsOrderItem>> goodsListData = getStringListMap(goodsOrderItem);
                storeOrderDetailsView.setGoodsListData(goodsListData);
            }

            @Override
            public void getDataFail(String msg) {
                storeOrderDetailsView.getStoreOrderDetailsFail(msg);
            }
        });
    }


    private Map<String, List<GoodsOrderItem>> getStringListMap(List<GoodsOrderItem> goodsOrderItem) {
        Map<String, List<GoodsOrderItem>> goodsListData = new HashMap<>();
        try {
            Map<Long, String> classList = new HashMap<>();
            for (GoodsOrderItem item : goodsOrderItem) {
                classList.put(item.getClassifyId(), item.getSpecOrderedAttr());
            }
            for (Map.Entry<Long, String> entry : classList.entrySet()) {
                List<GoodsOrderItem> listItemData = new ArrayList<>();
                for (GoodsOrderItem item : goodsOrderItem) {
                    if (item.getClassifyId() == entry.getKey()) {
                        listItemData.add(item);
                    }
                }
                goodsListData.put(entry.getValue(), listItemData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsListData;
    }
}
