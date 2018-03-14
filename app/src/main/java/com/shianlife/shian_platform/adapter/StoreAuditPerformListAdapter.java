package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.GoodsPerformStatusEnum;
import com.shianlife.shian_platform.appenum.GoodsPerformWayEnum;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.mvp.store.bean.GoodsOrderItem;
import com.shianlife.shian_platform.mvp.store.bean.GoodsPerform;
import com.shianlife.shian_platform.mvp.store.bean.GoodsPerformCancel;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.ui.activity.StoreAuditPerformActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

/**
 * Created by zm.
 */

public class StoreAuditPerformListAdapter extends BaseRCAdapter<StoreAuditPerformListResultBean.Content> {

    private CallBack callBack;

    /**
     * 单布局初始化
     *
     * @param context
     */
    public StoreAuditPerformListAdapter(Context context) {
        super(context, R.layout.layout_store_audit_perform_list_item);
    }

    @Override
    public void convert(BaseViewHolder holder, final StoreAuditPerformListResultBean.Content data, int index) {
        TextView tvGoodsClass = holder.getView(R.id.tv_goods_class);
        TextView tvPerformStatus = holder.getView(R.id.tv_perform_status);
        TextView tvGoodsName = holder.getView(R.id.tv_goods_name);
        TextView tvPerformBusiness = holder.getView(R.id.tv_perform_business);
        TextView tvPerformMan = holder.getView(R.id.tv_perform_man);
        TextView tvServiceWay = holder.getView(R.id.tv_service_way);
        final TextView tvCancelReason = holder.getView(R.id.tv_cancel_reason);
        final ImageView ivOrderMore = holder.getView(R.id.iv_order_more);
        LinearLayout llContent = holder.getView(R.id.ll_content);
        LinearLayout llBusinessPhone = holder.getView(R.id.ll_business_phone);
        LinearLayout llCounselorPhone = holder.getView(R.id.ll_counselor_phone);
        final TextView tvPerformAuditCheck = holder.getView(R.id.tv_perform_audit_check);
        TextView tvPerformAuditUncheck = holder.getView(R.id.tv_perform_audit_uncheck);

        if (data.getGoodsOrderItem() == null
                || data.getGoodsPerform() == null) {
            tvGoodsClass.setText("数据有误，请重新登录");
        }
        GoodsOrderItem goodsOrderItem = data.getGoodsOrderItem();
        GoodsPerform goodsPerform = data.getGoodsPerform();

        tvGoodsClass.setText(goodsOrderItem.getSpecOrderedAttr());
        tvPerformStatus.setText(GoodsPerformStatusEnum.getValueText(goodsPerform.getPerformStatus()));
        tvGoodsName.setText(goodsOrderItem.getSpecOrderedVolume() + "(" + goodsOrderItem.getSpecAlias() + ")" + "x" + goodsOrderItem.getSpecOrderedNum());

        if (data.getPerformUserName() != null)
            tvPerformBusiness.setText("执行商家：" + data.getPerformUserName());
        else
            tvPerformBusiness.setText("执行商家：暂无");

        if (goodsPerform.getPerformUserName() != null)
            tvPerformMan.setText("执行人员：" + goodsPerform.getPerformUserName());
        else
            tvPerformMan.setText("执行人员：暂无");

        if (goodsPerform.getPerformWay() != null)
            tvServiceWay.setText("实际执行方式：" + GoodsPerformWayEnum.getValueText(goodsPerform.getPerformWay()));
        else
            tvServiceWay.setText("实际执行方式：暂无");

        AppUtils.call(llBusinessPhone, data.getPerformUserPhone());
        AppUtils.call(llCounselorPhone, goodsPerform.getPerformUserPhone());

        tvPerformAuditCheck.setVisibility(View.GONE);
        tvPerformAuditUncheck.setVisibility(View.GONE);
        tvCancelReason.setVisibility(View.GONE);

        if (goodsPerform.getPerformStatus() == GoodsPerformStatusEnum.auditing.getCode()) {
            tvPerformAuditCheck.setVisibility(View.VISIBLE);
        } else if (goodsPerform.getPerformStatus() == GoodsPerformStatusEnum.success.getCode()) {
            tvPerformAuditUncheck.setVisibility(View.VISIBLE);
        } else if (goodsPerform.getPerformStatus() == GoodsPerformStatusEnum.cancel.getCode()) {
            tvCancelReason.setVisibility(View.VISIBLE);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == tvPerformAuditCheck)
                    auditPerform(data);
                else if (v == tvCancelReason)
                    cancelReason(data);
            }
        };

        tvPerformAuditCheck.setOnClickListener(onClickListener);
        tvCancelReason.setOnClickListener(onClickListener);
    }

    private void cancelReason(StoreAuditPerformListResultBean.Content data) {
        GoodsPerformCancel goodsPerformCancel = data.getGoodsPerformCancel();
        if (goodsPerformCancel == null) {
            ToastUtils.showToastShort(mContext, "没有关闭原因");
            return;
        }
        String reason = "无";
        if (goodsPerformCancel.getCancelReason() != null && !goodsPerformCancel.getCancelReason().isEmpty()) {
            reason = goodsPerformCancel.getCancelReason();
        }
        TipsDialog dialog = new TipsDialog(mContext);
        dialog.setTitle(reason);
        dialog.setTop("交易关闭原因");
        dialog.setBottomButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    private void auditPerform(StoreAuditPerformListResultBean.Content content) {
        new IntentUtils
                .Build(mContext, StoreAuditPerformActivity.class)
                .setData(IntentUtils.INTENT_DATA, content)
                .start();
    }


    public interface CallBack {
        void refresh();

        void refreshAll();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
