package com.shianlife.shian_platform.mvp.ordercenter.presenter.impl;

import android.content.DialogInterface;

import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.mvp.base.OnGetDataListener;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterSubmitAuditResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.model.IOrderCenterSubmitAuditModel;
import com.shianlife.shian_platform.mvp.ordercenter.model.impl.OrderCenterSubmitAuditModelImpl;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.IOrderCenterSubmitAuditPresenter;
import com.shianlife.shian_platform.mvp.ordercenter.view.IOrderCenterSubmitAuditView;

/**
 * Created by zm.
 */

public class OrderCenterSubmitAuditPresenterImpl implements IOrderCenterSubmitAuditPresenter {
    private IOrderCenterSubmitAuditModel orderCenterSubmitAuditModel;
    private IOrderCenterSubmitAuditView orderCenterSubmitAuditView;

    public OrderCenterSubmitAuditPresenterImpl(IOrderCenterSubmitAuditView orderCenterSubmitAuditView) {
        this.orderCenterSubmitAuditView = orderCenterSubmitAuditView;
        orderCenterSubmitAuditModel = new OrderCenterSubmitAuditModelImpl();
    }


    @Override
    public void submitAudit(final Integer auditStatus) {
        if (orderCenterSubmitAuditView.getContext() == null) {
            orderCenterSubmitAuditView.showToast("没有上下文对象");
            return;
        }
        if (orderCenterSubmitAuditView.getOrderId() == null) {
            orderCenterSubmitAuditView.showToast("没有orderId");
            return;
        }
        if (auditStatus == null) {
            orderCenterSubmitAuditView.showToast("没有审核状态");
            return;
        }
        if (orderCenterSubmitAuditView.getAuditSummary() == null || orderCenterSubmitAuditView.getAuditSummary().length() == 0) {
            orderCenterSubmitAuditView.showToast("还没有填写审核内容...");
            return;
        }

        TipsDialog tipsDialog = new TipsDialog(orderCenterSubmitAuditView.getContext());
        tipsDialog.setTop("提示");
        tipsDialog.setTitle("提示后不可修改，请确认提交内容正确");
        tipsDialog.setTopButton("取消", null);
        tipsDialog.setBottomButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OrderCenterSubmitAuditBean params = new OrderCenterSubmitAuditBean();
                params.setOrderId(orderCenterSubmitAuditView.getOrderId());
                params.setAuditSummary(orderCenterSubmitAuditView.getAuditSummary());
                params.setAuditStatus(auditStatus);
                params.setAuditPic(orderCenterSubmitAuditView.getAuditPic());
                orderCenterSubmitAuditModel.submitAudit(orderCenterSubmitAuditView.getContext(), params, new OnGetDataListener<OrderCenterSubmitAuditResultBean>() {
                    @Override
                    public void getDataSuccess(OrderCenterSubmitAuditResultBean result) {
                        orderCenterSubmitAuditView.submitOrderCenterAuditSuccess(result);
                    }

                    @Override
                    public void getDataFail(String msg) {
                        orderCenterSubmitAuditView.submitOrderCenterAuditFail(msg);
                    }
                });
            }
        });
        tipsDialog.show();
    }
}
