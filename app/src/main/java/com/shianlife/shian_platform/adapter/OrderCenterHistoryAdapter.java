package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.view.piccorner.RoundCornerImageView;
import com.shianlife.shian_platform.mvp.ordercenter.bean.AuditRecordDetails;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterRecord;
import com.shianlife.shian_platform.mvp.ordercenter.bean.PerformRecordDetails;
import com.shianlife.shian_platform.ui.activity.ImagePreviewActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

        String timeTitle = "";
        String userNameTitle = "";
        String userName = "";
        String dealContentTitle = "";
        List<String> picUrlList = new ArrayList<>();
        if (orderCenterRecord.getAuditRecordDetails() != null) {
            AuditRecordDetails data = orderCenterRecord.getAuditRecordDetails();
            timeTitle = "审核时间：";
            userNameTitle = "审核人：";
            dealContentTitle = "审核反馈：";
            if (data.getCreatedAt() != null)
                tvOrderTime.setText(data.getCreatedAt());
            if (data.getAuditSummary() != null)
                tvDealContent.setText(data.getAuditSummary());
            if (data.getAuditorName() != null)
                userName = data.getAuditorName();
            AppUtils.call(llPhone, data.getAuditorPhone());
            data.getAuditPic();
            picUrlList = StringUtils.getSplitList(data.getAuditPic(), ",");
        } else if (orderCenterRecord.getPerformRecordDetails() != null) {
            PerformRecordDetails data = orderCenterRecord.getPerformRecordDetails();
            timeTitle = "处理时间：";
            userNameTitle = "处理人：";
            dealContentTitle = "处理反馈：";
            if (data.getCreatedAt() != null)
                tvOrderTime.setText(data.getCreatedAt());
            if (data.getPerformSummary() != null)
                tvDealContent.setText(data.getPerformSummary());
            if (data.getPerformerName() != null)
                userName = data.getPerformerName();
            AppUtils.call(llPhone, data.getPerformerPhone());
            picUrlList = StringUtils.getSplitList(data.getPerformPic(), ",");
        } else {
            AppUtils.call(llPhone, null);
        }
        for (String picUrl : picUrlList) {
            addPicView(llPics, picUrl);
        }
        tvOrderTimeTitle.setText(timeTitle);
        tvUserName.setText(userNameTitle + userName);
        tvDealContentTitle.setText(dealContentTitle);
    }

    /**
     * 增加图片内容
     * @param llPics
     * @param picUrl
     */
    private void addPicView(LinearLayout llPics, final String picUrl) {
        int dpPic = mContext.getResources().getDimensionPixelOffset(R.dimen.dimen_100dp);
        int dpMargin = mContext.getResources().getDimensionPixelOffset(R.dimen.dimen_16dp);

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(dpPic, dpPic);
        layout.leftMargin = dpMargin;
        layout.rightMargin = dpMargin;
        layout.bottomMargin = dpMargin;
        layout.topMargin = dpMargin;
        RoundCornerImageView iv = new RoundCornerImageView(mContext);
        iv.setLayoutParams(layout);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ImagePreviewActivity.class);
                intent.putExtra(IntentUtils.INTENT_URL, Constants.QINIUURL + picUrl);
                mContext.startActivity(intent);
            }
        });
        llPics.addView(iv);
        AppUtils.loadPic(mContext, iv, Constants.QINIUURL + picUrl, R.drawable.zhy_pic_loading);
    }
}
