package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.ValidStatus;
import com.shianlife.shian_platform.appenum.WorkOrderStatusEnum;
import com.shianlife.shian_platform.appenum.WorkOrderTypeStatusEnum;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditorAssignRecord;
import com.shianlife.shian_platform.mvp.ordercenter.bean.CustomerInfo;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderStatusChange;
import com.shianlife.shian_platform.mvp.ordercenter.bean.PerformRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.WorkOrder;
import com.shianlife.shian_platform.ui.activity.OrderCenterAuditActivity;
import com.shianlife.shian_platform.ui.activity.OrderCenterDetailsActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class OrderCenterAuditListAdapter extends BaseRCAdapter<OrderCenterAuditListResultBean.Content> {
    /**
     * 单布局初始化
     *
     * @param context
     */
    public OrderCenterAuditListAdapter(Context context) {
        super(context, R.layout.layout_order_center_item);
    }

    @Override
    public void convert(BaseViewHolder holder, OrderCenterAuditListResultBean.Content data, int index) {
        TextView tvOrderNumber = holder.getView(R.id.tv_order_number);
        TextView tvServiceLocation = holder.getView(R.id.tv_service_location);
        TextView tvPlanTime = holder.getView(R.id.tv_plan_time);
        TextView tvRemark = holder.getView(R.id.tv_order_remark);
        TextView tvOrderType = holder.getView(R.id.tv_service_type);
        TextView tvSendTime = holder.getView(R.id.tv_send_time);
        final TextView tvOrderAudit = holder.getView(R.id.tv_order_audit);
        LinearLayout llCustomerPhone = holder.getView(R.id.ll_customer_phone);
        LinearLayout llAgentPhone = holder.getView(R.id.ll_agent_phone);
        final LinearLayout llContent = holder.getView(R.id.ll_content);

        final WorkOrder workOrder = data.getWorkOrder();
        CustomerInfo customerInfo = data.getCustomerInfo();

        List<OrderStatusChange> listOrderStatusChange = data.getListOrderStatusChange();
        AuditorAssignRecord assignRecord = data.getAuditorAssignRecord();

        //点击事件
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == llContent) {
                    jumpOrderDetails(workOrder.getId());
                } else if (v == tvOrderAudit) {
                    jumpOrderAudit(workOrder.getId());
                }
            }
        };


        if (workOrder != null) {
            //订单编号
            if (workOrder.getOrderNumber() != null)
                tvOrderNumber.setText(workOrder.getOrderNumber());
            //预约时间
            if (workOrder.getAppointmentTime() != null)
                tvPlanTime.setText(workOrder.getAppointmentTime());
            //备注
            if (workOrder.getOrderDescribe() != null)
                tvRemark.setText(workOrder.getOrderDescribe());
            //服务类型
            if (workOrder.getOrderType() != null) {
                String orderType = WorkOrderTypeStatusEnum.getValueText(workOrder.getOrderType());
                if (orderType != null)
                    tvOrderType.setText(orderType);
            }
            //订单详情
            if (workOrder.getId() != null) {
                llContent.setOnClickListener(onClick);
                tvOrderAudit.setOnClickListener(onClick);
            }
            //订单按钮处理
            if (workOrder.getOrderStatus() != null && workOrder.getOrderStatus() == WorkOrderStatusEnum.auditing.getCode())
                tvOrderAudit.setVisibility(View.VISIBLE);
            else
                tvOrderAudit.setVisibility(View.GONE);
        }

        if (customerInfo != null) {
            //服务地址
            if (customerInfo.getAddress() != null)
                tvServiceLocation.setText(customerInfo.getAddress());

            //电话设置
            AppUtils.call(llCustomerPhone, customerInfo.getContactPhone());
            AppUtils.call(llAgentPhone, customerInfo.getAgentPhone());
        }

        if (listOrderStatusChange != null) {
            //派单时间
            String sendTime = getTimeByStatus(listOrderStatusChange, WorkOrderStatusEnum.waitaccept.getCode());
            if (sendTime != null)
                tvSendTime.setText(sendTime);
        }

        /**
         * 设置审核按钮
         */
        if (assignRecord != null && workOrder != null && workOrder.getOrderStatus() != null)
            if (assignRecord.getValid() == ValidStatus.valid.getCode() && workOrder.getOrderStatus() == WorkOrderStatusEnum.auditing.getCode())
                tvOrderAudit.setVisibility(View.VISIBLE);
            else
                tvOrderAudit.setVisibility(View.GONE);
        else
            tvOrderAudit.setVisibility(View.GONE);
    }


    /**
     * 根据状态获取时间
     *
     * @param listData
     * @param status
     * @return
     */
    private String getTimeByStatus(List<OrderStatusChange> listData, Integer status) {
        String time = new String();
        for (OrderStatusChange item : listData) {
            if (item.getUpdataStatus() != null && item.getUpdataStatus() == status && item.getUpdateTime() != null) {
                time = item.getUpdateTime();
                break;
            }
        }
        return time;
    }


    /**
     * 跳转详情界面
     *
     * @param orderId
     */
    private void jumpOrderDetails(Long orderId) {
        if (orderId != null) {
            Intent intent = new Intent(mContext, OrderCenterDetailsActivity.class);
            intent.putExtra(IntentUtils.INTENT_ORDERID, orderId);
            mContext.startActivity(intent);
        }
    }

    /**
     * 跳转审核界面
     *
     * @param orderId
     */
    private void jumpOrderAudit(Long orderId) {
        if (orderId != null) {
            Intent intent = new Intent(mContext, OrderCenterAuditActivity.class);
            intent.putExtra(IntentUtils.INTENT_ORDERID, orderId);
            mContext.startActivity(intent);
        }
    }
}
