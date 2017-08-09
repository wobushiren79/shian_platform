package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.StoreOrderGoodsListAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.list.ScrollExpandableListView;
import com.shianlife.shian_platform.custom.show.store.StoreExpandableTitleView;
import com.shianlife.shian_platform.mvp.order.bean.GoodsOrderItem;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderDetailsResultBean;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreOrderDetailsPresenter;
import com.shianlife.shian_platform.mvp.order.presenter.impl.StoreOrderDetailsPresenterImpl;
import com.shianlife.shian_platform.mvp.order.view.IStoreOrderDetailsView;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreOrderDetailsActivity extends BaseActivity implements IStoreOrderDetailsView, StoreExpandableTitleView.CallBack {

    @BindView(R.id.tv_customer_name)
    TextView tvCustomerName;
    @BindView(R.id.tv_customer_phone)
    TextView tvCustomerPhone;
    @BindView(R.id.tv_service_location)
    TextView tvServiceLocation;
    @BindView(R.id.tv_service_time)
    TextView tvServiceTime;
    @BindView(R.id.goods_expand_list_view)
    ScrollExpandableListView expandListView;
    @BindView(R.id.goods_expand_title)
    StoreExpandableTitleView goodsExpandTitle;

    private Intent intent;
    private IStoreOrderDetailsPresenter storeOrderDetailsPresenter;
    private StoreOrderGoodsListAdapter goodsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_details);


    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_order_details), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        goodsExpandTitle.setCallBack(this);
        goodsListAdapter = new StoreOrderGoodsListAdapter(this);
        expandListView.setAdapter(goodsListAdapter);
    }

    @Override
    protected void initData() {
        intent = getIntent();
        storeOrderDetailsPresenter = new StoreOrderDetailsPresenterImpl(this);
        storeOrderDetailsPresenter.getStoreOrderDetails();

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void getStoreOrderDetailsSuccess(StoreOrderDetailsResultBean resultBean) {

    }

    @Override
    public void getStoreOrderDetailsFail(String msg) {
        ToastUtils.showToastShort(this, msg);
    }

    @Override
    public Long getOrderId() {
        return intent.getLongExtra(IntentUtils.INTENT_ORDERID, -1);
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(this, msg);
    }


    @Override
    public void setCustomerName(String name) {
        tvCustomerName.setText("客户：" + name);
    }

    @Override
    public void setCustomerPhone(String phone) {
        tvCustomerPhone.setText(phone);
    }

    @Override
    public void setServiceLocation(String location) {
        tvServiceLocation.setText("地址：" + location);
    }

    @Override
    public void setServiceTime(String time) {
        tvServiceTime.setText("服务时间：" + time);
    }

    @Override
    public void setGoodsItemNumber(String number) {
        goodsExpandTitle.setData("总计：" + number);
    }

    @Override
    public void onClickExpandable(View view, boolean isExpandable) {
        if (view == goodsExpandTitle) {
            if (isExpandable)
                expandListView.setVisibility(View.VISIBLE);
            else
                expandListView.setVisibility(View.GONE);
        }
    }

    @Override
    public void setGoodsListData(Map<String, List<GoodsOrderItem>> data) {
        goodsListAdapter.setData(data);
        AppUtils.expandGroup(expandListView, goodsListAdapter);
    }


}
