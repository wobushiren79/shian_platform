package com.shianlife.shian_platform.mvp.order.presenter.impl;

import com.shianlife.shian_platform.appenum.GoodsFinanceDeliveryEnum;
import com.shianlife.shian_platform.appenum.GoodsInvoiceTitleTypeEnum;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.order.bean.GoodsFinance;
import com.shianlife.shian_platform.mvp.order.bean.GoodsInvoice;
import com.shianlife.shian_platform.mvp.order.bean.GoodsInvoiceDetailsItem;
import com.shianlife.shian_platform.mvp.order.bean.GoodsItemPerform;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrder;
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
import java.util.LinkedList;
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
        params.setId(storeOrderDetailsView.getOrderId());
        storeOrderDetailsModel.getStoreOrderDetails(storeOrderDetailsView.getContext(), params, new OnGetDataListener<StoreOrderDetailsResultBean>() {
            @Override
            public void getDataSuccess(StoreOrderDetailsResultBean result) {
                storeOrderDetailsView.getStoreOrderDetailsSuccess(result);

                GoodsServiceInfo goodsServiceInfo = result.getGoodsServiceInfo();
                GoodsOrder goodsOrder = result.getGoodsOrder();
                GoodsInvoice goodsInvoice = result.getGoodsInvoice();
                List<GoodsItemPerform> goodsItemPerforms = result.getGoodsItemPerforms();
                if (goodsServiceInfo == null
                        || goodsOrder == null
                        || goodsItemPerforms == null) {
                    storeOrderDetailsView.showToast("数据错误");
                    return;
                }
                //服务信息
                if (goodsServiceInfo.getContact() != null)
                    storeOrderDetailsView.setCustomerName(goodsServiceInfo.getContact());
                if (goodsServiceInfo.getContactPhone() != null)
                    storeOrderDetailsView.setCustomerPhone(goodsServiceInfo.getContactPhone());
                if (goodsServiceInfo.getServiceLocation() != null)
                    storeOrderDetailsView.setServiceLocation(goodsServiceInfo.getServiceLocation());
                if (goodsServiceInfo.getBookTime() != null)
                    storeOrderDetailsView.setServiceTime(goodsServiceInfo.getBookTime());
                storeOrderDetailsView.setGoodsItemNumber(goodsItemPerforms.size() + "");
                //商品信息
                Map<String, List<GoodsItemPerform>> goodsListData = getStringListMap(goodsItemPerforms);
                storeOrderDetailsView.setGoodsListData(goodsListData);
                //是否需要发票
                if (goodsOrder.getNeedInvoice() == GoodsFinanceDeliveryEnum.notinvoicement.getCode()) {
                    storeOrderDetailsView.setIsNeedInvoice(GoodsFinanceDeliveryEnum.notinvoicement.getName());
                } else if (goodsOrder.getNeedInvoice() == GoodsFinanceDeliveryEnum.hasinvoicement.getCode()) {
                    storeOrderDetailsView.setIsNeedInvoice(GoodsFinanceDeliveryEnum.hasinvoicement.getName());
                }
                //发票信息
                List<GoodsInvoiceDetailsItem> listInvoiceData = new ArrayList<>();
                if (goodsInvoice != null) {
                    String titleType = GoodsInvoiceTitleTypeEnum.getValueText(goodsInvoice.getTitleType());
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("抬头类型", titleType));

                    String title = goodsInvoice.getTitle();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("发票抬头", title));

                    String companyTaxId = goodsInvoice.getCompanyTaxId();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("公司税号", companyTaxId));

                    String checkInvoiceTime = goodsInvoice.getCheckInvoiceTime();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("确认开发票时间", checkInvoiceTime));

                    String deliveryWay = goodsInvoice.getDeliveryWay();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("发票配送方式", deliveryWay));

                    String expressName = goodsInvoice.getExpressName();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("快递公司名称", expressName));

                    String deliveryNumber = goodsInvoice.getDeliveryNumber();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("配送单号", deliveryNumber));

                    String invoiceRemark = goodsInvoice.getInvoiceRemark();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("发票备注", invoiceRemark));

                    String receiptName = goodsInvoice.getReceiptName();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("收件人", receiptName));

                    String receiptPhone = goodsInvoice.getReceiptPhone();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("收件人电话", receiptPhone));

                    String receiptLocation = goodsInvoice.getReceiptLocation();
                    listInvoiceData.add(new GoodsInvoiceDetailsItem("收件人地址", receiptLocation));
                }
                storeOrderDetailsView.setInvoiceData(listInvoiceData);
                //订单备注
                storeOrderDetailsView.setRemark(goodsOrder.getOrderComment());
                //设置价钱
                storeOrderDetailsView.setCustomerMoney("￥" + (float) goodsOrder.getShowTotalPrice() / 100f);
                storeOrderDetailsView.setCounselorMoney("￥" + (float) goodsOrder.getTotalPrice() / 100f);
                //设置订单数据
                storeOrderDetailsView.setOrderNumber("订单编号：" + goodsOrder.getOrderNumber());
                storeOrderDetailsView.setOrderTime("订单时间：" + goodsOrder.getCreatedAt());
                if (result.getGoodsFinance() != null) {
                    GoodsFinance goodsFinance = result.getGoodsFinance();
                    if (goodsFinance.getPaymentTime() != null) {
                        storeOrderDetailsView.setOrderPayTime("付款时间：" + goodsFinance.getPaymentTime());
                    } else {
                        storeOrderDetailsView.setOrderPayTime("付款时间：暂无");
                    }
                    if (goodsFinance.getPaymentNumber() != null) {
                        storeOrderDetailsView.setOrderPayNumber("付款流水：" + goodsFinance.getPaymentNumber());
                    } else {
                        storeOrderDetailsView.setOrderPayNumber("付款流水：暂无");
                    }

                }

            }

            @Override
            public void getDataFail(String msg) {
                storeOrderDetailsView.getStoreOrderDetailsFail(msg);
            }
        });
    }


    private Map<String, List<GoodsItemPerform>> getStringListMap(List<GoodsItemPerform> goodsItemPerforms) {
        Map<String, List<GoodsItemPerform>> goodsListData = new HashMap<>();
        try {
//            Map<Long, String> classList = new HashMap<>();
//            for (GoodsOrderItem item : goodsOrderItem) {
//                classList.put(item.getClassifyId(), item.getSpecOrderedAttr());
//            }
//            for (Map.Entry<Long, String> entry : classList.entrySet()) {
//                List<GoodsOrderItem> listItemData = new ArrayList<>();
//                Long key = entry.getKey();
//                String value = entry.getValue();
//                for (GoodsOrderItem item : goodsOrderItem) {
//                    if (item.getClassifyId() == key) {
//                        listItemData.add(item);
//                    }
//                }
//                goodsListData.put(value ,listItemData);
//            }
            List<String> classList = new LinkedList<>();
            for (GoodsItemPerform item : goodsItemPerforms) {
                classList.add(item.getSpecOrderedAttr());
            }
            List<String> newClassList = new ArrayList(new HashSet(classList));
            for (String className : newClassList) {
                List<GoodsItemPerform> listItemData = new ArrayList<>();
                for (GoodsItemPerform item : goodsItemPerforms) {
                    if (item.getSpecOrderedAttr().equals(className)) {
                        listItemData.add(item);
                    }
                }
                goodsListData.put(className, listItemData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsListData;
    }
}
