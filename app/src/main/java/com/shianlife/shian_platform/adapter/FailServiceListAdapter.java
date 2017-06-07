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
        TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        TextView tvGo = holder.getView(R.id.tv_go);
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void setLayoutDataNoReturnCar(BaseViewHolder holder, FailServiceListResultBean.FailServiceItemData failServiceItemData, int index) {
        TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        TextView tvGo = holder.getView(R.id.tv_go);
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_PIC);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_back_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_back_mileage));
                dataDialog.setPhoteText(getContext().getString(R.string.driver_order_text_mileagephoto));
                dataDialog.setCallBack(new DriverOrderDataDialog.CallBack() {
                    @Override
                    public void clickTop(DialogInterface dialog) {
                        dialog.cancel();
                    }

                    @Override
                    public void clickBottom(DialogInterface dialog, String location, String mileage, List<String> fileUrlList) {
                        if (location == null || location.isEmpty()) {
                            ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_check_1));
                            return;
                        }
                        if (mileage == null || mileage.isEmpty()) {
                            ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_check_2));
                            return;
                        }
                        if (fileUrlList == null || fileUrlList.size() == 0) {
                            ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_check_3));
                            return;
                        }
                        dialog.cancel();
                    }
                });
                dataDialog.show();
            }
        });
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
