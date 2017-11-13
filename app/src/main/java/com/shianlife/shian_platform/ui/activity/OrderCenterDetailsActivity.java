package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterDetailsResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterRecord;
import com.shianlife.shian_platform.mvp.ordercenter.bean.PerformRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.IOrderCenterDetailsPresenter;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.impl.OrderCenterDetailsPresenterImpl;
import com.shianlife.shian_platform.mvp.ordercenter.view.IOrderCenterDetailsView;
import com.shianlife.shian_platform.ui.order.ordercenter.OrderCenterHistoryList;
import com.shianlife.shian_platform.ui.order.ordercenter.OrderCenterInfoLayout;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderCenterDetailsActivity extends BaseActivity implements IOrderCenterDetailsView {

    @BindView(R.id.layout_order_info)
    OrderCenterInfoLayout layoutOrderInfo;
    @BindView(R.id.layout_audit_list)
    OrderCenterHistoryList layoutAuditList;
    @BindView(R.id.layout_performer_list)
    OrderCenterHistoryList layoutPerformerList;
    @BindView(R.id.ll_content)
    LinearLayout llContent;


    private IOrderCenterDetailsPresenter orderCenterDetailsPresenter;
    protected Long orderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_center_details);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setTitle("工单详情", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        orderId = getIntent().getLongExtra(IntentUtils.INTENT_ORDERID, -1);
        orderCenterDetailsPresenter = new OrderCenterDetailsPresenterImpl(this);
        orderCenterDetailsPresenter.getOrderCenterDetails();
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public void getOrderCenterDetailsSuccess(OrderCenterDetailsResultBean resultBean) {

    }

    @Override
    public void getOrderCenterDetailsFail(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public Long getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderCenterNumber(String orderCenterNumber) {
        layoutOrderInfo.setOrderCenterNumber(orderCenterNumber);
    }

    @Override
    public void setOrderCenterServiceLocation(String location) {
        layoutOrderInfo.setOrderCenterServiceLocation(location);
    }

    @Override
    public void setOrderCenterPlanTime(String time) {
        layoutOrderInfo.setOrderCenterPlanTime(time);
    }

    @Override
    public void setOrderCenterDescribe(String remark) {
        layoutOrderInfo.setOrderCenterDescribe(remark);
    }

    @Override
    public void setOrderCenterServiceType(String type) {
        layoutOrderInfo.setOrderCenterServiceType(type);
    }

    @Override
    public void setOrderCenterServiceTag(String tag) {
        layoutOrderInfo.setOrderCenterServiceTag(tag);
    }

    @Override
    public void setOrderCenterPrice(String price) {
        layoutOrderInfo.setOrderCenterPrice(price);
    }

    @Override
    public void setOrderCenterCustomerPhone(String customerPhone) {
        layoutOrderInfo.setOrderCenterCustomerPhone(customerPhone);
    }

    @Override
    public void setOrderCenterCustomerName(String name) {
        layoutOrderInfo.setOrderCenterCustomerName(name);
    }

    @Override
    public void setOrderCenterAgentPhone(String agentPhone) {
        layoutOrderInfo.setOrderCenterAgentPhone(agentPhone);
    }

    @Override
    public void setOrderCenterAgentName(String name) {
        layoutOrderInfo.setOrderCenterAgentName(name);
    }

    @Override
    public void setOrderCenterPerformRecordList(List<PerformRecordDetails> listData) {
        List<OrderCenterRecord> newListData = new ArrayList<>();
        for (PerformRecordDetails item : listData) {
            OrderCenterRecord data = new OrderCenterRecord();
            data.setPerformRecordDetails(item);
            newListData.add(data);
        }
        layoutPerformerList.setListData(newListData);
    }

    @Override
    public void setOrderCenterAuditRecordList(List<AuditRecordDetails> listData) {
        List<OrderCenterRecord> newListData = new ArrayList<>();
        for (AuditRecordDetails item : listData) {
            OrderCenterRecord data = new OrderCenterRecord();
            data.setAuditRecordDetails(item);
            newListData.add(data);
        }
        layoutAuditList.setListData(newListData);
    }

    @Override
    public void setOrderCenterAdvistorName(String advistorName) {
        layoutOrderInfo.setAdvisorName(advistorName);
    }

    @Override
    public void setOrderCenterAdvistorPhone(String phone) {
        layoutOrderInfo.setAdvisorPhone(phone);
    }
}
