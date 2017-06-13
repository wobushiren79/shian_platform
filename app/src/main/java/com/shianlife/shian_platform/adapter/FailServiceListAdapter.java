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
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.ui.activity.DriverOrderDetailsActivity;
import com.shianlife.shian_platform.ui.activity.MapFindLocationActivity;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class FailServiceListAdapter extends BaseRCSAdapter<FailServiceListResultBean.FailServiceItemData> {
    //已经还车
    private final int LAYOUT_ALDRETURNCAR = 0;
    //等待还车
    private final int LAYOUT_NORETURNCAR = 1;

    /**
     * 多布局初始化
     *
     * @param context
     */
    public FailServiceListAdapter(Context context) {
        super(context);
    }

    @Override
    public void convert(BaseViewHolder holder, FailServiceListResultBean.FailServiceItemData failServiceItemData, int index) {
        if (getItemViewType(index) == LAYOUT_ALDRETURNCAR) {
            setLayoutDataAldReturnCar(holder, failServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_NORETURNCAR) {
            setLayoutDataNoReturnCar(holder, failServiceItemData, index);
        }
    }


    private void setLayoutDataAldReturnCar(BaseViewHolder holder, FailServiceListResultBean.FailServiceItemData failServiceItemData, int index) {
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

    private void setLayoutDataNoReturnCar(BaseViewHolder holder, final FailServiceListResultBean.FailServiceItemData failServiceItemData, int index) {
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
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_PIC, failServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_back_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_back_mileage));
                dataDialog.setPhoteText(getContext().getString(R.string.driver_order_text_mileagephoto));
                dataDialog.show();
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {

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

    private Context getContext() {
        return mContext;
    }

    @Override
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_failservice_item_returncar);
        mListLayoutId.add(R.layout.layout_driver_order_failservice_item_noreturncar);
    }

    @Override
    public int getItemViewType(int position) {
        FailServiceListResultBean.FailServiceItemData inServiceItemData = mDatas.get(position);
        if (position % 2 == 0) {
            return LAYOUT_ALDRETURNCAR;
        } else if (position % 2 == 1) {
            return LAYOUT_NORETURNCAR;
        }
        return LAYOUT_ALDRETURNCAR;
    }
}
