package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterRecord;
import com.shianlife.shian_platform.mvp.ordercenter.bean.PerformRecordDetails;
import com.shianlife.shian_platform.utils.AppUtils;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class OrderCenterHistoryAdapter extends BaseRCAdapter<OrderCenterRecord> {

    /**
     * 单布局初始化
     *
     * @param context
     */
    public OrderCenterHistoryAdapter(Context context) {
        super(context, R.layout.layout_order_center_history_item);
    }

    @Override
    public void convert(BaseViewHolder holder, OrderCenterRecord orderCenterRecord, int index) {
        TextView tvOrderTimeTitle = holder.getView(R.id.tv_order_time_title);
        TextView tvOrderTime = holder.getView(R.id.tv_order_time);
        TextView tvUserName = holder.getView(R.id.tv_user_name);
        LinearLayout llPhone = holder.getView(R.id.ll_phone);
        TextView tvDealContentTitle = holder.getView(R.id.tv_deal_content_title);
        TextView tvDealContent = holder.getView(R.id.tv_deal_content);
        LinearLayout llPics = holder.getView(R.id.ll_pics);
        HorizontalScrollView layoutPics = holder.getView(R.id.layout_pics);

        String timeTitle;
        String userNameTitle;
        String dealContentTitle;
        if (orderCenterRecord.getAuditRecordDetails() != null) {
            AuditRecordDetails data = orderCenterRecord.getAuditRecordDetails();
            timeTitle = "审核时间：";
            userNameTitle = "审核人：";
            dealContentTitle = "审核反馈：";
            tvOrderTime.setText(data.getCreatedAt());
            tvDealContent.setText(data.getAuditSummary());
            AppUtils.call(llPhone, data.getAuditorPhone());
        } else if (orderCenterRecord.getPerformRecordDetails() != null) {
            PerformRecordDetails data = orderCenterRecord.getPerformRecordDetails();
            timeTitle = "处理时间：";
            userNameTitle = "处理人：";
            dealContentTitle = "处理反馈：";
            tvOrderTime.setText(data.getCreatedAt());
            tvDealContent.setText(data.getPerformSummary());
            AppUtils.call(llPhone, data.getPerformerPhone());
        } else {
            timeTitle = "";
            userNameTitle = "";
            dealContentTitle = "";
            AppUtils.call(llPhone, null);
        }
        tvOrderTimeTitle.setText(timeTitle);
        tvUserName.append(userNameTitle);
        tvDealContentTitle.setText(dealContentTitle);
    }
}
