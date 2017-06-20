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
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IServiceOngoingPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.ServiceOngoingPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IServiceOngoingRequestView;
import com.shianlife.shian_platform.ui.activity.MapFindLocationActivity;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class InServiceListAdapter extends BaseRCSAdapter<InServiceListResultBean.InServiceItemData> implements IServiceOngoingRequestView {

    //接人
    private final int LAYOUT_TAKEPERSON = 0;
    //等待上车
    private final int LAYOUT_WAITGOCAR = 1;
    //上车
    private final int LAYOUT_INCAR = 2;
    //到达
    private final int LAYOUT_ARRIVE = 3;
    //错误布局
    private final int LAYOUT_ERROR = 4;

    private IServiceOngoingPresenter serviceOngoingPresenter;

    /**
     * 多布局初始化
     *
     * @param context
     */
    public InServiceListAdapter(Context context) {
        super(context);
        serviceOngoingPresenter = new ServiceOngoingPresenterImpl(this);
    }

    @Override
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_takeperson);
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_waitgocar);
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_incar);
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_arrive);
        mListLayoutId.add(R.layout.layout_driver_order_waitservice_item_error);
    }

    @Override
    public void convert(BaseViewHolder holder, InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
        if (getItemViewType(index) == LAYOUT_TAKEPERSON) {
            setLayoutDataTakePerson(holder, inServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_WAITGOCAR) {
            setLayoutDataWaitGoCar(holder, inServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_INCAR) {
            setLayoutDataInCar(holder, inServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_ARRIVE) {
            setLayoutDataArrive(holder, inServiceItemData, index);
        } else if (getItemViewType(index) == LAYOUT_ERROR) {

        }
    }

    /**
     * 接人
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataTakePerson(BaseViewHolder holder, final InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(inServiceItemData.getReason());

        layoutCarnum.setContent(inServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.callFor.getName());
        layoutPersonnum.setContent(inServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(inServiceItemData.getRemark());
        layoutTime.setContent(inServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(inServiceItemData.getCustomer());
        layoutCustomer.setPhone(inServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(inServiceItemData.getSource());
        layoutFinallocation.setContent(inServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipsDialog tipsDialog = new TipsDialog(getContext());
                tipsDialog.setTitle(getContext().getString(R.string.dialog_text_1));
                tipsDialog.setBottomButton(getContext().getString(R.string.dialog_true_4), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ServiceOngoingBean serviceOngoingBean = new ServiceOngoingBean();
                        serviceOngoingBean.setOrderId(inServiceItemData.getOrderId());
                        serviceOngoingBean.setServiceStep(inServiceItemData.getOrderState());
                        serviceOngoingPresenter.saveServiceOngoing(serviceOngoingBean);
                    }
                });
                tipsDialog.setTopButton(getContext().getString(R.string.dialog_false_4), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                tipsDialog.show();
            }
        });
        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {

            @Override
            public void clickMap(View view) {
                if (view == layoutMeetlocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getSource())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getTarget())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }

    /**
     * 等待上车
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataWaitGoCar(BaseViewHolder holder, final InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(inServiceItemData.getReason());

        layoutCarnum.setContent(inServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.waitGoOnCar.getName());
        layoutPersonnum.setContent(inServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(inServiceItemData.getRemark());
        layoutTime.setContent(inServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(inServiceItemData.getCustomer());
        layoutCustomer.setPhone(inServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(inServiceItemData.getSource());
        layoutFinallocation.setContent(inServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_NOPIC, inServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_nowlocation));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_nowmileage));
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
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getSource())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getTarget())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }

    /**
     * 已上车
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataInCar(BaseViewHolder holder, final InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(inServiceItemData.getReason());

        layoutCarnum.setContent(inServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.alreadyGoOnCar.getName());
        layoutPersonnum.setContent(inServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(inServiceItemData.getRemark());
        layoutTime.setContent(inServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(inServiceItemData.getCustomer());
        layoutCustomer.setPhone(inServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(inServiceItemData.getSource());
        layoutFinallocation.setContent(inServiceItemData.getTarget());
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_NOPIC, inServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_arrive_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_arrive_mileage));
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
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getSource())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getTarget())
                            .start();
                }
            }
        };
        layoutPersonnum.setCallBack(buttonClick);
        layoutMeetlocation.setCallBack(buttonClick);
        layoutFinallocation.setCallBack(buttonClick);
    }

    /**
     * 已送达
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataArrive(BaseViewHolder holder, final InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutResaon = holder.getView(R.id.layout_resaon);
        TextView tvGo = holder.getView(R.id.tv_go);
        layoutResaon.setContent(inServiceItemData.getReason());

        layoutCarnum.setContent(inServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.deliverd.getName());
        layoutPersonnum.setContent(inServiceItemData.getPersonNum());
        layoutPersonnum.setRemark(inServiceItemData.getRemark());
        layoutTime.setContent(inServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(inServiceItemData.getCustomer());
        layoutCustomer.setPhone(inServiceItemData.getCustomerPhone());
        layoutMeetlocation.setContent(inServiceItemData.getSource());
        layoutFinallocation.setContent(inServiceItemData.getTarget());
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_PIC, inServiceItemData);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_back_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_back_mileage));
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
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getSource())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, inServiceItemData.getTarget())
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
        InServiceListResultBean.InServiceItemData inServiceItemData = mDatas.get(position);
        if (inServiceItemData.getOrderState() == DriverStateEnum.callFor.getCode()) {
            return LAYOUT_TAKEPERSON;
        } else if (inServiceItemData.getOrderState() == DriverStateEnum.waitGoOnCar.getCode()) {
            return LAYOUT_WAITGOCAR;
        } else if (inServiceItemData.getOrderState() == DriverStateEnum.alreadyGoOnCar.getCode()) {
            return LAYOUT_INCAR;
        } else if (inServiceItemData.getOrderState() == DriverStateEnum.deliverd.getCode()) {
            return LAYOUT_ARRIVE;
        } else {
            return LAYOUT_ERROR;
        }
    }


    public Context getContext() {
        return mContext;
    }

    @Override
    public void saveServiceOngoingSuccess(ServiceOngoingResultBean result) {
        if (callBack != null)
            callBack.refesh();
        ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_serviceonoing_success));
    }

    @Override
    public void saveServiceOngoingFail(String msg) {
        ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_serviceonoing_fail));
    }


}
