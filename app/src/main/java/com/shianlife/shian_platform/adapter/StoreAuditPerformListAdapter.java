package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.GoodsPerformStatusEnum;
import com.shianlife.shian_platform.appenum.GoodsPerformWayEnum;
import com.shianlife.shian_platform.appenum.GoodsServiceWayEnum;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrderItem;
import com.shianlife.shian_platform.mvp.order.bean.GoodsPerform;
import com.shianlife.shian_platform.mvp.order.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.ui.activity.StoreAuditPerformActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;

import butterknife.BindView;

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
        ImageView ivOrderMore = holder.getView(R.id.iv_order_more);
        LinearLayout llContent = holder.getView(R.id.ll_content);
        LinearLayout llBusinessPhone = holder.getView(R.id.ll_business_phone);
        LinearLayout llCounselorPhone = holder.getView(R.id.ll_counselor_phone);
        TextView tvPerformAuditCheck = holder.getView(R.id.tv_perform_audit_check);
        TextView tvPerformAuditUncheck = holder.getView(R.id.tv_perform_audit_uncheck);

        if (data.getGoodsOrderItem() == null
                || data.getGoodsPerform() == null) {
            tvGoodsClass.setText("数据有误，请重新登陆");
        }
        GoodsOrderItem goodsOrderItem = data.getGoodsOrderItem();
        GoodsPerform goodsPerform = data.getGoodsPerform();

        tvGoodsClass.setText(goodsOrderItem.getSpecOrderedAttr());
        tvPerformStatus.setText(GoodsPerformStatusEnum.getValueText(goodsPerform.getPerformStatus()));
        tvGoodsName.setText(goodsOrderItem.getSpecOrderedVolume() + "(" + goodsOrderItem.getSpecAlias() + ")" + "x" + goodsOrderItem.getSpecOrderedNum());
        tvPerformBusiness.setText("执行商家：" + data.getPerformUserName());
        tvPerformMan.setText("执行人员：" + goodsPerform.getPerformUserName());
        tvServiceWay.setText("实际执行方式：" + GoodsPerformWayEnum.getValueText(goodsPerform.getPerformWay()));

        AppUtils.call(llBusinessPhone,data.getPerformUserPhone());
        AppUtils.call(llCounselorPhone, goodsPerform.getPerformUserPhone());

        if (goodsPerform.getPerformStatus() == GoodsPerformStatusEnum.auditing.getCode()) {
            tvPerformAuditCheck.setVisibility(View.VISIBLE);
            tvPerformAuditUncheck.setVisibility(View.GONE);
        } else if (goodsPerform.getPerformStatus() == GoodsPerformStatusEnum.success.getCode()) {
            tvPerformAuditCheck.setVisibility(View.GONE);
            tvPerformAuditUncheck.setVisibility(View.VISIBLE);
        } else {
            tvPerformAuditCheck.setVisibility(View.GONE);
            tvPerformAuditUncheck.setVisibility(View.GONE);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auditPerform(data);
            }
        };

        tvPerformAuditCheck.setOnClickListener(onClickListener);
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
