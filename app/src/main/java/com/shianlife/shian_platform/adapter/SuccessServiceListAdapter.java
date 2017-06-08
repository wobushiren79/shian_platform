package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCSAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
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

    /**
     * 多布局初始化
     *
     * @param context
     */
    public SuccessServiceListAdapter(Context context) {
        super(context);
    }

    @Override
    public void convert(BaseViewHolder holder, SuccessServiceListResultBean.SuccessServiceItemData successServiceItemData, int index) {
        if (getItemViewType(index) == LAYOUT_DETAILS) {
            setLayoutDataDetails(holder, successServiceItemData, index);
        }
    }

    private void setLayoutDataDetails(BaseViewHolder holder, SuccessServiceListResultBean.SuccessServiceItemData successServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        TextView tvGo = holder.getView(R.id.tv_go);
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentUtils
                        .Build(getContext(), DriverOrderDetailsActivity.class)
                        .start();
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {
            @Override
            public void clickRemark(View view) {
                if (view == layoutCarnum) {
                }
            }

            @Override
            public void clickPhone(View view) {

            }

            @Override
            public void clickMap(View view) {
                if (view == layoutMeetlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, "轿子音乐厅")
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, "轿子音乐厅")
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }

    @Override
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_successservice_item_details);
    }

    private Context getContext() {
        return mContext;
    }
}
