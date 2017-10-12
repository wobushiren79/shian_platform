package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.StoreOrderGoodsListAdapter;
import com.shianlife.shian_platform.adapter.StoreOrderInvoiceDetailsAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.show.store.StoreEditNormalView;
import com.shianlife.shian_platform.custom.show.store.StoreExpandableTitleView;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollExpandableListView;
import com.shianlife.shian_platform.custom.view.scrollview.ScrollRecyclerView;
import com.shianlife.shian_platform.mvp.order.bean.GoodsInvoiceDetailsItem;
import com.shianlife.shian_platform.mvp.order.bean.GoodsItemPerform;
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
    @BindView(R.id.invoice_title)
    StoreExpandableTitleView invoiceTitle;
    @BindView(R.id.invoice_list_view)
    ScrollRecyclerView invoiceListView;
    @BindView(R.id.tv_remark)
    StoreEditNormalView tvRemark;
    @BindView(R.id.tv_money_customer)
    TextView tvMoneyCustomer;
    @BindView(R.id.tv_money_counselor)
    TextView tvMoneyCounselor;
    @BindView(R.id.tv_order_number)
    TextView tvOrderNumber;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_order_pay_time)
    TextView tvOrderPayTime;
    @BindView(R.id.tv_order_pay_number)
    TextView tvOrderPayNumber;

    private Intent intent;
    private IStoreOrderDetailsPresenter storeOrderDetailsPresenter;
    private StoreOrderGoodsListAdapter goodsListAdapter;
    private StoreOrderInvoiceDetailsAdapter invoiceDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_details);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_order_details), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        goodsExpandTitle.setCallBack(this);
        invoiceTitle.setCallBack(this);

        goodsListAdapter = new StoreOrderGoodsListAdapter(this,true);
        invoiceDetailsAdapter = new StoreOrderInvoiceDetailsAdapter(this);

        expandListView.setAdapter(goodsListAdapter);
        invoiceListView.setAdapter(invoiceDetailsAdapter);
        invoiceListView.setLayoutManager(new LinearLayoutManager(this));

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
        } else if (view == invoiceTitle) {
            if (isExpandable)
                invoiceListView.setVisibility(View.VISIBLE);
            else
                invoiceListView.setVisibility(View.GONE);
        }

    }

    @Override
    public void setGoodsListData(Map<String, List<GoodsItemPerform>> data) {
        goodsListAdapter.setData(data);
        AppUtils.expandGroup(expandListView, goodsListAdapter);
    }

    @Override
    public void setIsNeedInvoice(String content) {
        invoiceTitle.setData(content);
    }

    @Override
    public void setInvoiceData(List<GoodsInvoiceDetailsItem> listData) {
        invoiceDetailsAdapter.setData(listData);
    }

    @Override
    public void setRemark(String remark) {
        tvRemark.setData(remark);
    }

    @Override
    public void setCustomerMoney(String money) {
        tvMoneyCustomer.setText(money);
    }

    @Override
    public void setCounselorMoney(String money) {
        tvMoneyCounselor.setText(money);
    }

    @Override
    public void setOrderNumber(String number) {
        tvOrderNumber.setText(number);
    }

    @Override
    public void setOrderTime(String time) {
        tvOrderTime.setText(time);
    }

    @Override
    public void setOrderPayTime(String time) {
        tvOrderPayTime.setText(time);
    }

    @Override
    public void setOrderPayNumber(String payNumber) {
        tvOrderPayNumber.setText(payNumber);
    }


}
