package com.shianlife.shian_platform.ui.order.ordercenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.utils.AppUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class OrderCenterInfoLayout extends BaseLayout {
    @BindView(R.id.tv_order_number)
    TextView tvOrderNumber;
    @BindView(R.id.tv_service_location)
    TextView tvServiceLocation;
    @BindView(R.id.tv_plan_time)
    TextView tvPlanTime;
    @BindView(R.id.tv_service_type)
    TextView tvServiceType;
    @BindView(R.id.tv_service_tag)
    TextView tvServiceTag;
    @BindView(R.id.tv_order_price)
    TextView tvOrderPrice;
    @BindView(R.id.tv_order_remark)
    TextView tvOrderRemark;
    @BindView(R.id.tv_customer_name)
    TextView tvCustomerName;
    @BindView(R.id.ll_customer_phone)
    LinearLayout llCustomerPhone;
    @BindView(R.id.tv_agent_name)
    TextView tvAgentName;
    @BindView(R.id.ll_agent_phone)
    LinearLayout llAgentPhone;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.iv_more)
    ImageView ivMore;

    public OrderCenterInfoLayout(Context context) {
        this(context, null);
    }

    public OrderCenterInfoLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_order_center_info, attrs);
        initView();
        initData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    public void setOrderCenterNumber(String orderCenterNumber) {
        if (orderCenterNumber != null)
            tvOrderNumber.append(orderCenterNumber);
    }

    public void setOrderCenterServiceLocation(String location) {
        if (location != null)
            tvServiceLocation.append(location);
    }

    public void setOrderCenterPlanTime(String time) {
        if (time != null)
            tvPlanTime.append(time);
    }

    public void setOrderCenterDescribe(String describe) {
        if (describe != null)
            tvOrderRemark.append(describe);
    }

    public void setOrderCenterServiceType(String type) {
        if (type != null)
            tvServiceType.append(type);
    }

    public void setOrderCenterServiceTag(String tag) {
        if (tag != null)
            tvServiceTag.append(tag);
    }

    public void setOrderCenterPrice(String price) {
        if (price != null)
            tvOrderPrice.append(price + "￥");
    }

    public void setOrderCenterCustomerPhone(String customerPhone) {
        if (customerPhone != null)
            AppUtils.call(llCustomerPhone, customerPhone);
    }

    public void setOrderCenterCustomerName(String name) {
        if (name != null)
            tvCustomerName.append( name);
    }

    public void setOrderCenterAgentPhone(String agentPhone) {
        if (agentPhone != null)
            AppUtils.call(llAgentPhone, agentPhone);
    }

    public void setOrderCenterAgentName(String name) {
        if (name != null)
            tvAgentName.append(name);
    }
}
