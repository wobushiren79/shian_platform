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
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
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
    //错误布局
    private final int LAYOUT_ERROR = 2;

    /**
     * 多布局初始化
     *
     * @param context
     */
    public FailServiceListAdapter(Context context) {
        super(context);
    }

    @Override
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_failservice_item_returncar);
        mListLayoutId.add(R.layout.layout_driver_order_failservice_item_noreturncar);
    }

    @Override
    public void convert(BaseViewHolder holder, FailServiceListResultBean.FailServiceItemData failServiceItemData, int index) {
        if (getItemViewType(index) == LAYOUT_ALDRETURNCAR) {
            setLayoutDataAldReturnCar(holder, failServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_NORETURNCAR) {
            setLayoutDataNoReturnCar(holder, failServiceItemData, index);
        }
    }


    private void setLayoutDataAldReturnCar(BaseViewHolder holder, final FailServiceListResultBean.FailServiceItemData failServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        final TextShowLayout layoutRemark = holder.getView(R.id.layout_remark);

        TextView tvGo = holder.getView(R.id.tv_go);

        layoutResaon.setContent(failServiceItemData.getReason());
        layoutCarnum.setContent(failServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.cancel.getName());
        layoutPersonnum.setContent(failServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(failServiceItemData.getRemark());
        layoutRemark.setContent(failServiceItemData.getRemark());
        layoutTime.setContent(failServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(failServiceItemData.getCustomer());
        layoutCustomer.setPhone(failServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(failServiceItemData.getSource());
        layoutFinallocation.setContent(failServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentUtils
                        .Build(getContext(), DriverOrderDetailsActivity.class)
                        .setLong(IntentUtils.INTENT_ORDERID, failServiceItemData.getOrderId())
                        .start();
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {
            @Override
            public void clickMap(View view) {
                if (view == layoutMeetlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, failServiceItemData.getSource())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, failServiceItemData.getSourceLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, failServiceItemData.getSourceLatitude())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, failServiceItemData.getTarget())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, failServiceItemData.getTargetLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, failServiceItemData.getTargetLatitude())
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
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        final TextShowLayout layoutRemark = holder.getView(R.id.layout_remark);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(failServiceItemData.getReason());

        layoutCarnum.setContent(failServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.deliverd.getName());
        layoutPersonnum.setContent(failServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(failServiceItemData.getRemark());
        layoutRemark.setContent(failServiceItemData.getRemark());
        layoutTime.setContent(failServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(failServiceItemData.getCustomer());
        layoutCustomer.setPhone(failServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(failServiceItemData.getSource());
        layoutFinallocation.setContent(failServiceItemData.getTarget());
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_PIC, failServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_back_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_back_mileage));
                dataDialog.setPhoteText(getContext().getString(R.string.driver_order_text_mileagephoto));
                dataDialog.setCallBack(new DriverOrderDataDialog.CallBack() {
                    @Override
                    public void getDataSuccess(ServiceOngoingResultBean result) {
                        if (callBack != null)
                            callBack.refresh();
                    }

                    @Override
                    public void getDataFail(String msg) {

                    }
                });
                dataDialog.show();
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {
            @Override
            public void clickMap(View view) {
                if (view == layoutMeetlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, failServiceItemData.getSource())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, failServiceItemData.getSourceLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, failServiceItemData.getSourceLatitude())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, failServiceItemData.getTarget())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, failServiceItemData.getTargetLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, failServiceItemData.getTargetLatitude())
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
    public int getItemViewType(int position) {
        FailServiceListResultBean.FailServiceItemData failServiceItemData = mDatas.get(position);
        if (failServiceItemData.getOrderState() == DriverStateEnum.cancel.getCode()) {
            if (failServiceItemData.isCancelReturnCar()) {
                return LAYOUT_ALDRETURNCAR;
            } else {
                return LAYOUT_NORETURNCAR;
            }
        } else {
            return LAYOUT_ERROR;
        }
    }
}
