package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCSAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.appenum.DriverStateEnum;
import com.shianlife.shian_platform.custom.dialog.DriverOrderDataDialog;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.custom.show.EditTextShowLayout;
import com.shianlife.shian_platform.custom.show.ImageUpLoadShowLayout;
import com.shianlife.shian_platform.custom.show.TextShowLayout;
import com.shianlife.shian_platform.mvp.driver.bean.AcceptOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.RejectOrderResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakeCarResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IAcceptOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.IRejectOrderPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.ITakeCarPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.AcceptOrderPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.RejectOrderPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.TalkCarPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IAcceptOrderView;
import com.shianlife.shian_platform.mvp.driver.view.IRejectOrderView;
import com.shianlife.shian_platform.mvp.driver.view.ITakeCarView;
import com.shianlife.shian_platform.ui.activity.MapFindLocationActivity;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;

import static com.shianlife.shian_platform.custom.dialog.DriverOrderDataDialog.STYLE_PIC;

/**
 * Created by zm.
 */

public class WaitServiceListAdapter extends BaseRCSAdapter<WaitServiceListResultBean.WaitServiceItemData> implements IAcceptOrderView, IRejectOrderView, ITakeCarView {
    private IAcceptOrderPresenter acceptOrderPresenter;
    private IRejectOrderPresenter rejectOrderPresenter;
    private ITakeCarPresenter takeCarPresenter;
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
        takeCarPresenter = new TalkCarPresenterImpl(this);
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
        TextView tvReject = holder.getView(R.id.tv_reject);
        TextView tvAccept = holder.getView(R.id.tv_accept);

        layoutCarnum.setContent(waitServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.isAttribute.getName());
        layoutPersonnum.setContent(waitServiceItemData.getPersonNum());
        layoutTime.setContent(waitServiceItemData.getGetPersonTime());
        layoutMeetlocation.setContent(waitServiceItemData.getSource());
        layoutFinallocation.setContent(waitServiceItemData.getTarget());

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
            public void clickRemark(View view) {
                if (!waitServiceItemData.getRemark().isEmpty()) {
                    TipsDialog tipsDialog = new TipsDialog(getContext());
                    tipsDialog.setTop(getContext().getString(R.string.driver_order_text_remark));
                    tipsDialog.setTitle(waitServiceItemData.getRemark());
                    tipsDialog.setBottomButton(getContext().getString(R.string.dialog_true_3), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    tipsDialog.show();
                } else {
                    ToastUtils.showToastShort(getContext(), getContext().getString(R.string.bug_text_3));
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
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getSource())
                            .start();
                } else if (view == layoutFinallocation) {
                    new IntentUtils
                            .Build(getContext(), MapFindLocationActivity.class)
                            .setString(IntentUtils.INTENT_LOCATION, waitServiceItemData.getTarget())
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
    private void setLayoutDataWaitGetCar(BaseViewHolder holder, WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        final TextShowLayout layoutCarlocation = holder.getView(R.id.layout_carlocation);
        TextView tvGo = holder.getView(R.id.tv_go);

        layoutCarnum.setContent(waitServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.waitGetCar.getName());
        layoutPersonnum.setContent(waitServiceItemData.getPersonNum());
        layoutTime.setContent(waitServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(waitServiceItemData.getCustomer());
        layoutMeetlocation.setContent(waitServiceItemData.getSource());
        layoutFinallocation.setContent(waitServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_PIC);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_nowcarlocation));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_nowmileage));
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
                        takeCarPresenter.saveTakeCarData();
                        dialog.cancel();
                    }
                });
                dataDialog.show();
            }
        });

        TextShowLayout.CallBack buttonClick = new TextShowLayout.CallBack() {
            @Override
            public void clickRemark(View view) {

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
                } else if (view == layoutCarlocation) {
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
        layoutCarlocation.setCallBack(buttonClick);
    }

    /**
     * 设置等待出发数据
     *
     * @param holder
     * @param waitServiceItemData
     * @param index
     */
    private void setLayoutDataWaitGo(BaseViewHolder holder, WaitServiceListResultBean.WaitServiceItemData waitServiceItemData, int index) {
        final TextShowLayout layoutCarnum = holder.getView(R.id.layout_carnum);
        final TextShowLayout layoutPersonnum = holder.getView(R.id.layout_personnum);
        final TextShowLayout layoutTime = holder.getView(R.id.layout_time);
        final TextShowLayout layoutCustomer = holder.getView(R.id.layout_customer);
        final TextShowLayout layoutMeetlocation = holder.getView(R.id.layout_meetlocation);
        final TextShowLayout layoutFinallocation = holder.getView(R.id.layout_finallocation);
        TextView tvGo = holder.getView(R.id.tv_go);

        layoutCarnum.setContent(waitServiceItemData.getCarNum());
        layoutCarnum.setContentBold();
        layoutCarnum.setStateText(DriverStateEnum.setOff.getName());
        layoutPersonnum.setContent(waitServiceItemData.getPersonNum());
        layoutTime.setContent(waitServiceItemData.getGetPersonTime());
        layoutCustomer.setContent(waitServiceItemData.getCustomer());
        layoutMeetlocation.setContent(waitServiceItemData.getSource());
        layoutFinallocation.setContent(waitServiceItemData.getTarget());

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_NOPIC);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_go_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_gomileage));
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
                        dialog.cancel();
                    }
                });
                dataDialog.show();
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
    public void saveTalkCarDataSuccess(TakeCarResultBean result) {

    }

    @Override
    public void saveTalkCarDataFail(String msg) {

    }

    @Override
    public void rejectOrderSuccess(RejectOrderResultBean result) {
        ToastUtils.showToastShort(mContext, "此功能还未开放~！");
    }

    @Override
    public void rejectOrderFail(String msg) {

    }

    @Override
    public void acceptOrderSuccess(AcceptOrderResultBean result) {
        ToastUtils.showToastShort(mContext, mContext.getString(R.string.driver_order_accept_success));
    }

    @Override
    public void acceptOrderFail(String msg) {
        ToastUtils.showToastShort(mContext, mContext.getString(R.string.driver_order_accept_fail));
    }

}
