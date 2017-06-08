package com.shianlife.shian_platform.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.base.BaseRCSAdapter;
import com.shianlife.shian_platform.adapter.base.BaseViewHolder;
import com.shianlife.shian_platform.custom.dialog.DriverOrderDataDialog;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.custom.show.TextShowLayout;
import com.shianlife.shian_platform.mvp.driver.bean.ArriveDestinationResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.GetOnCarResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.ReturnCarResultBean;
import com.shianlife.shian_platform.mvp.driver.bean.TakePersonResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IArriveDestinationPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.IGetOnCarPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.IReturnCarPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.ITakePersonPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.ArriveDestinationPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.GetOnCarPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.ReturnCarPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.TakePersonPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IArriveDestinationView;
import com.shianlife.shian_platform.mvp.driver.view.IGetOnCarView;
import com.shianlife.shian_platform.mvp.driver.view.IReturnCarView;
import com.shianlife.shian_platform.mvp.driver.view.ITakePersonView;
import com.shianlife.shian_platform.ui.activity.MapFindLocationActivity;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class InServiceListAdapter extends BaseRCSAdapter<InServiceListResultBean.InServiceItemData> implements ITakePersonView, IGetOnCarView, IArriveDestinationView, IReturnCarView {

    //接人
    private final int LAYOUT_TAKEPERSON = 0;
    //等待上车
    private final int LAYOUT_WAITGOCAR = 1;
    //上车
    private final int LAYOUT_INCAR = 2;
    //到达
    private final int LAYOUT_ARRIVE = 3;


    private ITakePersonPresenter takePersonPresenter;
    private IGetOnCarPresenter getOnCarPresenter;
    private IArriveDestinationPresenter arriveDestinationPresenter;
    private IReturnCarPresenter returnCarPresenter;

    /**
     * 多布局初始化
     *
     * @param context
     */
    public InServiceListAdapter(Context context) {
        super(context);
        takePersonPresenter = new TakePersonPresenterImpl(this);
        getOnCarPresenter = new GetOnCarPresenterImpl(this);
        arriveDestinationPresenter = new ArriveDestinationPresenterImpl(this);
        returnCarPresenter = new ReturnCarPresenterImpl(this);
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
        }
    }

    /**
     * 接人
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataTakePerson(BaseViewHolder holder, InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
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
                TipsDialog tipsDialog = new TipsDialog(getContext());
                tipsDialog.setTitle(getContext().getString(R.string.dialog_text_1));
                tipsDialog.setBottomButton(getContext().getString(R.string.dialog_true_4), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        takePersonPresenter.takePerson();
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

    /**
     * 等待上车
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataWaitGoCar(BaseViewHolder holder, InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
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
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_NOPIC);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_nowlocation));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_nowmileage));
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
                        getOnCarPresenter.getOnCar();
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

    /**
     * 已上车
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataInCar(BaseViewHolder holder, InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
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
                DriverOrderDataDialog dataDialog = new DriverOrderDataDialog(getContext(), DriverOrderDataDialog.STYLE_NOPIC);
                dataDialog.setLocationText(getContext().getString(R.string.driver_order_text_arrive_location));
                dataDialog.setMileageText(getContext().getString(R.string.driver_order_text_arrive_mileage));
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
                        arriveDestinationPresenter.arriveDestination();
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

    /**
     * 已送达
     *
     * @param holder
     * @param inServiceItemData
     * @param index
     */
    private void setLayoutDataArrive(BaseViewHolder holder, InServiceListResultBean.InServiceItemData inServiceItemData, int index) {
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
                        returnCarPresenter.returnCar();
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
    public void addLayout(List<Integer> mListLayoutId) {
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_takeperson);
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_waitgocar);
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_incar);
        mListLayoutId.add(R.layout.layout_driver_order_inservice_item_arrive);
    }

    @Override
    public int getItemViewType(int position) {
        InServiceListResultBean.InServiceItemData inServiceItemData = mDatas.get(position);
        if (position % 4 == 0) {
            return LAYOUT_TAKEPERSON;
        } else if (position % 4 == 1) {
            return LAYOUT_WAITGOCAR;
        } else if (position % 4 == 2) {
            return LAYOUT_INCAR;
        } else if (position % 4 == 3) {
            return LAYOUT_ARRIVE;
        }
        return LAYOUT_TAKEPERSON;
    }


    public Context getContext() {
        return mContext;
    }


    @Override
    public void takePersonSuccess(TakePersonResultBean result) {
        ToastUtils.showToastShort(getContext(), "test");
    }

    @Override
    public void takePersonFail(String msg) {

    }

    @Override
    public void getOnCarSuccess(GetOnCarResultBean result) {
        ToastUtils.showToastShort(getContext(), "test");
    }

    @Override
    public void getOnCarFail(String msg) {

    }

    @Override
    public void arriveDestinationSuccess(ArriveDestinationResultBean result) {
        ToastUtils.showToastShort(getContext(), "test");
    }

    @Override
    public void arriveDestinationFail(String msg) {

    }

    @Override
    public void returnCarSuccess(ReturnCarResultBean result) {
        ToastUtils.showToastShort(getContext(), "test");
    }

    @Override
    public void returnCarFail(String msg) {

    }
}
