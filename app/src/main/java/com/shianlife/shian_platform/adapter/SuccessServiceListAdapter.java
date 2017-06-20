package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCSAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.DriverStateEnum;
import com.shianlife.shian_platform.custom.dialog.DriverOrderDataDialog;
import com.shianlife.shian_platform.custom.show.TextShowLayout;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.ui.activity.DriverOrderDetailsActivity;
import com.shianlife.shian_platform.ui.activity.MapFindLocationActivity;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class SuccessServiceListAdapter extends BaseRCSAdapter<SuccessServiceListResultBean.SuccessServiceItemData> {
    //等待接单
    private final int LAYOUT_DETAILS = 0;
    //错误布局
    private final int LAYOUT_ERROR = 1;

    /**
     * 多布局初始化
     *
     * @param context
     */
    public SuccessServiceListAdapter(Context context) {
        super(context);
    }

    @Override
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_successservice_item_details);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_error);
    }

    @Override
    public void convert(BaseViewHolder holder, SuccessServiceListResultBean.SuccessServiceItemData successServiceItemData, int index) {
        if (getItemViewType(index) == LAYOUT_DETAILS) {
            setLayoutDataDetails(holder, successServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_ERROR) {

        }
    }

    private void setLayoutDataDetails(BaseViewHolder holder, final SuccessServiceListResultBean.SuccessServiceItemData successServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(successServiceItemData.getReason());

        layoutCarnum.setContent(successServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.successService.getName());
        layoutPersonnum.setContent(successServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(successServiceItemData.getRemark());
        layoutTime.setContent(successServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(successServiceItemData.getCustomer());
        layoutCustomer.setPhone(successServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(successServiceItemData.getSource());
        layoutFinallocation.setContent(successServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentUtils
                        .Build(getContext(), DriverOrderDetailsActivity.class)
                        .setLong(IntentUtils.INTENT_ORDERID, successServiceItemData.getOrderId())
                        .start();
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {


            @Override
            public void clickMap(View view) {
                if (view == layoutMeetlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, successServiceItemData.getSource())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, successServiceItemData.getTarget())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }


    private Context getContext() {
        return mContext;
    }
}
