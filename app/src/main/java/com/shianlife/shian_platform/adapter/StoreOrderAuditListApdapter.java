package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.GoodsOrderStatusEnum;
import com.shianlife.shian_platform.appenum.GoodsServiceWayEnum;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrder;
import com.shianlife.shian_platform.mvp.order.bean.GoodsServiceInfo;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;
import com.shianlife.shian_platform.ui.activity.StoreOrderAuditPerformActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;


/**
 * Created by zm.
 */

public class StoreOrderAuditListApdapter extends BaseRCAdapter<StoreOrderAuditResultListBean.Content> {

    private CallBack callBack;

    /**
     * 单布局初始化
     *
     * @param context
     */
    public StoreOrderAuditListApdapter(Context context) {
        super(context, R.layout.layout_store_order_audit_list_item);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void convert(BaseViewHolder holder, final StoreOrderAuditResultListBean.Content data, int index) {
        TextView tvGoodsNumber = holder.getView(R.id.tv_goods_number);

        TextView tvGoodsAttr = holder.getView(R.id.tv_goods_attr);
        TextView tvCustomerName = holder.getView(R.id.tv_customer_name);
        TextView tvServiceWay = holder.getView(R.id.tv_service_way);
        TextView tvServiceTime = holder.getView(R.id.tv_service_time);
        TextView tvCounselorName = holder.getView(R.id.tv_counselor_name);

        ImageView ivOrderMore = holder.getView(R.id.iv_order_more);
        LinearLayout llContent = holder.getView(R.id.ll_content);
        final LinearLayout llCustomerPhone = holder.getView(R.id.ll_customer_phone);
        final LinearLayout llCounselorPhone = holder.getView(R.id.ll_counselor_phone);

        final TextView tvOrderDetails = holder.getView(R.id.tv_order_details);
        final TextView tvAuditDetails = holder.getView(R.id.tv_audit_details);
        final TextView tvOrderAudit = holder.getView(R.id.tv_order_audit);

        if (data.getGoodsOrder() == null || data.getGoodsServiceInfo() == null) {
            tvGoodsNumber.setText("数据错误");
            return;
        }
        GoodsOrder goodsOrder = data.getGoodsOrder();
        GoodsServiceInfo goodsServiceInfoBean = data.getGoodsServiceInfo();

        tvGoodsNumber.setText(goodsOrder.getOrderNumber());
        tvGoodsAttr.setText("订单属性：" + goodsOrder.getConnectId() + "");
        tvCustomerName.setText("客户姓名：" + goodsOrder.getCustomerName());
        tvServiceWay.setText("执行方式：" + GoodsServiceWayEnum.getValueText(goodsServiceInfoBean.getServiceWay()));
        tvServiceTime.setText("预约服务时间：" + goodsServiceInfoBean.getBookTime());
        tvCounselorName.setText("顾问姓名：" + "待完善");

        //电话设置
        AppUtils.call(llCustomerPhone, data.getGoodsOrder().getCustomerPhone());
        AppUtils.call(llCounselorPhone, "待定。。");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == tvOrderDetails) {

                } else if (v == tvAuditDetails) {

                } else if (v == tvOrderAudit) {
                    new IntentUtils.Build(mContext, StoreOrderAuditPerformActivity.class)
                            .setLong(IntentUtils.INTENT_ORDERID, data.getGoodsOrder().getId())
                            .start();
                }
            }
        };
        tvOrderDetails.setOnClickListener(onClickListener);
        tvAuditDetails.setOnClickListener(onClickListener);
        tvOrderAudit.setOnClickListener(onClickListener);

        if (goodsOrder.getOrderStatus() == GoodsOrderStatusEnum.servicecomplete.getCode()
                || goodsOrder.getOrderStatus() == GoodsOrderStatusEnum.servicesuccess.getCode()) {
            tvOrderDetails.setVisibility(View.VISIBLE);
            tvAuditDetails.setVisibility(View.VISIBLE);
            tvOrderAudit.setVisibility(View.GONE);
        } else {
            tvOrderDetails.setVisibility(View.VISIBLE);
            tvAuditDetails.setVisibility(View.GONE);
            tvOrderAudit.setVisibility(View.VISIBLE);
        }
    }


    public interface CallBack {
        void refresh();

        void refreshAll();
    }
}
