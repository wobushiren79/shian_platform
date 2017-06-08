package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.show.orderdetails.DetailsLayout;
import com.shianlife.shian_platform.mvp.driver.bean.OrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IOrderDetailsPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.OrderDetailsPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IOrderDetailsView;

import butterknife.BindView;

public class DriverOrderDetailsActivity extends BaseActivity implements IOrderDetailsView {

    @BindView(R.id.tv_orderid)
    TextView tvOrderid;
    @BindView(R.id.ll_content)
    LinearLayout llContent;


    private IOrderDetailsPresenter orderDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_order_details);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_drvier_details), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
    }

    @Override
    protected void initData() {
        orderDetailsPresenter = new OrderDetailsPresenterImpl(this);
        orderDetailsPresenter.getOrderDeails();

    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void getOrderDetailsSuccess(OrderDetailsResultBean result) {
        addAcceptOrderView("test");
        addGetCarView("test", "test", "test", "test");
        addGoView("test", "test", "test");
        addArriveMeetLocation("test");
        addGetPersonView("test", "test", "test");
        addArriveFinalLocation("test", "test", "test");
        addReturnCarView("test", "test", "test", "test");
    }

    @Override
    public void getOrderDetailsFail(String msg) {

    }

    private LinearLayout.LayoutParams getLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.dimen_24dp);
        return layoutParams;
    }

    /**
     * 增加接单数据
     */
    private void addAcceptOrderView(String acceptTime) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_1));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_1_time), acceptTime);
        llContent.addView(detailsLayout);
    }


    /**
     * 增加接车数据
     */
    private void addGetCarView(String getCarLocation, String getCarTime, String getCarMilieage, String getCarPic) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_2));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_2_location), getCarLocation);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_2_time), getCarTime);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_2_mileage), getCarMilieage);
        detailsLayout.addPicView(getString(R.string.driver_order_details_title_2_pic), getCarPic);
        llContent.addView(detailsLayout);
    }


    /**
     * 增加出发数据
     */
    private void addGoView(String goLocation, String goTime, String goMilieage) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_3));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_3_location), goLocation);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_3_time), goTime);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_3_mileage), goMilieage);
        llContent.addView(detailsLayout);
    }

    /**
     * 增加到达预约地数据
     */
    private void addArriveMeetLocation(String arriveTime) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_4));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_4_time), arriveTime);
        llContent.addView(detailsLayout);
    }

    /**
     * 增加出发数据
     */
    private void addGetPersonView(String getPersonLocation, String getPersonTime, String getPersonMilieage) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_5));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_5_location), getPersonLocation);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_5_time), getPersonTime);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_5_mileage), getPersonMilieage);
        llContent.addView(detailsLayout);
    }

    /**
     * 增加到达目的地数据
     */
    private void addArriveFinalLocation(String finalLocation, String finalTime, String finalMilieage) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_6));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_6_location), finalLocation);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_6_time), finalTime);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_6_mileage), finalMilieage);
        llContent.addView(detailsLayout);
    }


    /**
     * 增加還車数据
     */
    private void addReturnCarView(String getCarLocation, String getCarTime, String getCarMilieage, String getCarPic) {
        DetailsLayout detailsLayout = new DetailsLayout(this, getString(R.string.driver_order_details_title_7));
        detailsLayout.setLayoutParams(getLayoutParams());
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_7_location), getCarLocation);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_7_time), getCarTime);
        detailsLayout.addTextView(getString(R.string.driver_order_details_title_7_mileage), getCarMilieage);
        detailsLayout.addPicView(getString(R.string.driver_order_details_title_7_pic), getCarPic);
        llContent.addView(detailsLayout);
    }
}
