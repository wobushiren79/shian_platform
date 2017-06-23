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
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.custom.show.TextShowLayout;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.model.IServiceOngoingModel;
import com.shianlife.shian_platform.mvp.driver.model.impl.ServiceOngoingModelImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.IAcceptOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.IRejectOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.IServiceOngoingPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.AcceptOrderPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.RejectOrderPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.ServiceOngoingPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IAcceptOrderView;
import com.shianlife.shian_platform.mvp.driver.view.IRejectOrderView;
import com.shianlife.shian_platform.mvp.driver.view.IServiceOngoingView;
import com.shianlife.shian_platform.ui.activity.MapFindLocationActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class WaitServiceListAdapter extends BaseRCSAdapter<WaitServiceListResultBean.WaitServiceItemData> implements IAcceptOrderView, IRejectOrderView {
    private IAcceptOrderPresenter acceptOrderPresenter;
    private IRejectOrderPresenter rejectOrderPresenter;
    //等待接单
    private final int LAYOUT_WAITGETORDER = 0;
    //等待取车
    private final int LAYOUT_WAITGETCAR = 1;
    //等待出发
    private final int LAYOUT_WAITGO = 2;
    //错误布局
    private final int LAYOUT_ERROR = 3;

    /**
     * 多布局初始化
     *
     * @param context
     */
    public WaitServiceListAdapter(Context context) {
        super(context);
        acceptOrderPresenter = new AcceptOrderPresenterImpl(this);
        rejectOrderPresenter = new RejectOrderPresenterImpl(this);
    }

    @Override
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_waitgetorder);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_waitgetcar);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_waitgo);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_error);
    }

    @Override
    public void convert(BaseViewHolder holder, WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, int index) {
//        holder.setIsRecyclable(false);
        if (getItemViewType(index) == LAYOUT_WAITGETORDER) {
            setLayoutDataWaitGetOrder(holder, waitServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_WAITGETCAR) {
            setLayoutDataWaitGetCar(holder, waitServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_WAITGO) {
            setLayoutDataWaitGo(holder, waitServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_ERROR) {

        }
    }

    /**
     * 设置等待接单数据
     *
     * @param holder
     * @param waitServiceItemData
     * @param index
     */
    private void setLayoutDataWaitGetOrder(final BaseViewHolder holder, final WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        final TextShowLayout layoutRemark = holder.getView(R.id.layout_remark);

        TextView tvReject = holder.getView(R.id.tv_reject);
        TextView tvAccept = holder.getView(R.id.tv_accept);

        layoutCarnum.setContent(waitServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.isAttribute.getName());
        layoutPersonnum.setContent(waitServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(waitServiceItemData.getRemark());
        layoutRemark.setContent(waitServiceItemData.getRemark());
        layoutTime.setContent(waitServiceItemData.getGetPersonTime());
        layoutMeetlocation.setContent(waitServiceItemData.getSource());
        layoutFinallocation.setContent(waitServiceItemData.getTarget());
        layoutResaon.setContent(waitServiceItemData.getReason());
        tvAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceptOrderPresenter.acceptOrder(waitServiceItemData.getOrderId());
            }
        });
        tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rejectOrderPresenter.rejectOrder(waitServiceItemData.getOrderId());
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {
            @Override
            public void clickMap(View view) {
                if (view == layoutMeetlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getSource())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getSourceLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getSourceLatitude())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getTarget())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getTargetLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getTargetLatitude())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }

    /**
     * 设置等待取车数据
     *
     * @param holder
     * @param waitServiceItemData
     * @param index
     */
    private void setLayoutDataWaitGetCar(BaseViewHolder holder, final WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, final int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutCarlocation = holder.getView(R.id.layout_carlocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        final TextShowLayout layoutRemark = holder.getView(R.id.layout_remark);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(waitServiceItemData.getReason());
        layoutCarnum.setContent(waitServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.waitGetCar.getName());
        layoutPersonnum.setContent(waitServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(waitServiceItemData.getRemark());
        layoutRemark.setContent(waitServiceItemData.getRemark());
        layoutTime.setContent(waitServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(waitServiceItemData.getCustomer());
        layoutCustomer.setPhone(waitServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(waitServiceItemData.getSource());
        layoutFinallocation.setContent(waitServiceItemData.getTarget());
        layoutCarlocation.setContent(waitServiceItemData.getTakeCarLocation());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_PIC, waitServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_nowcarlocation));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_nowmileage));
                dataDialog.setPhoteText(getContext().getString(R.string.driver_order_text_mileagephoto));
                dataDialog.setCallBack(new DriverOrderDataDialog.CallBack() {
                    @Override
                    public void getDataSuccess(ServiceOngoingResultBean result) {
                        if (callBack != null)
                            callBack.refesh();
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
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getSource())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getSourceLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getSourceLatitude())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getTarget())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getTargetLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getTargetLatitude())
                            .start();
                } else if (view == layoutCarlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getTakeCarLocation())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getTakeCarLocationLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getTakeCarLocationLatitude())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
        layoutCarlocation.setCallBack(buttonClick);
    }

    /**
     * 设置等待出发数据
     *
     * @param holder
     * @param waitServiceItemData
     * @param index
     */
    private void setLayoutDataWaitGo(BaseViewHolder holder, final WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        final TextShowLayout layoutRemark = holder.getView(R.id.layout_remark);
        TextView tvGo = holder.getView(R.id.tv_go);

        layoutResaon.setContent(waitServiceItemData.getReason());
        layoutCarnum.setContent(waitServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.setOff.getName());
        layoutPersonnum.setContent(waitServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(waitServiceItemData.getRemark());
        layoutRemark.setContent(waitServiceItemData.getRemark());
        layoutTime.setContent(waitServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(waitServiceItemData.getCustomer());
        layoutCustomer.setPhone(waitServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(waitServiceItemData.getSource());
        layoutFinallocation.setContent(waitServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_NOPIC, waitServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_go_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_gomileage));
                dataDialog.setCallBack(new DriverOrderDataDialog.CallBack() {
                    @Override
                    public void getDataSuccess(ServiceOngoingResultBean result) {
                        if (callBack != null)
                            callBack.refeshAll();
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
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getSource())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getSourceLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getSourceLatitude())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getTarget())
                            .setString(IntentUtils.INTENT_LOCATION_LONGITUDE, waitServiceItemData.getTargetLongitude())
                            .setString(IntentUtils.INTENT_LOCATION_LATITUDE, waitServiceItemData.getTargetLatitude())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }


    @Override
    public int getItemViewType(int position) {
        WaitServiceListResultBean.WaitServiceItemData waitServiceItemData = mDatas.get(position);
        if (waitServiceItemData.getOrderState() == DriverStateEnum.isAttribute.getCode()) {
            return LAYOUT_WAITGETORDER;
        } else if (waitServiceItemData.getOrderState() == DriverStateEnum.waitGetCar.getCode()) {
            return LAYOUT_WAITGETCAR;
        } else if (waitServiceItemData.getOrderState() == DriverStateEnum.setOff.getCode()) {
            return LAYOUT_WAITGO;
        } else {
            return LAYOUT_ERROR;
        }
    }

    @Override
    public Context getContext() {
        return mContext;
    }


    @Override
    public void rejectOrderSuccess(RejectOrderResultBean result) {
        if (callBack != null)
            callBack.refesh();
        ToastUtils.showToastShort(mContext, mContext.getString(R.string.driver_order_reject_success));
    }

    @Override
    public void rejectOrderFail(String msg) {
        ToastUtils.showToastShort(mContext, mContext.getString(R.string.driver_order_reject_fail));
    }

    @Override
    public void acceptOrderSuccess(AcceptOrderResultBean result) {
        if (callBack != null)
            callBack.refesh();
        ToastUtils.showToastShort(mContext, mContext.getString(R.string.driver_order_accept_success));
    }

    @Override
    public void acceptOrderFail(String msg) {
        ToastUtils.showToastShort(mContext, mContext.getString(R.string.driver_order_accept_fail));
    }

}
