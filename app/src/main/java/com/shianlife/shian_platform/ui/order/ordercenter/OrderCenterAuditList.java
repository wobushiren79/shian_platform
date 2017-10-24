package com.shianlife.shian_platform.ui.order.ordercenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.OrderCenterAuditListAdapter;
import com.shianlife.shian_platform.base.BasePtrRecyclerView;
import com.shianlife.shian_platform.mvp.ordercenter.bean.OrderCenterAuditListResultBean;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.IOrderCenterAuditListPresenter;
import com.shianlife.shian_platform.mvp.ordercenter.presenter.impl.OrderCenterAuditListPresenterImpl;
import com.shianlife.shian_platform.mvp.ordercenter.view.IOrderCenterAuditListView;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.Arrays;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class OrderCenterAuditList extends BasePtrRecyclerView implements IOrderCenterAuditListView {

    private String title;

    private int pageSize = 10;
    private int pageNumber = 1;
    private Integer listType;

    private IOrderCenterAuditListPresenter orderCenterAuditListPresenter;

    private OrderCenterAuditListAdapter listAdapter;

    public OrderCenterAuditList(Context context, Integer listType) {
        super(context);
        this.listType = listType;
        setReminderText(R.drawable.zhy_no_order_text);
        init();
    }

    private void init() {
        listAdapter = new OrderCenterAuditListAdapter(getContext());
        orderCenterAuditListPresenter = new OrderCenterAuditListPresenterImpl(this);

        this.setAdapter(listAdapter);
        this.setLayoutManager(new LinearLayoutManager(getContext()));
        this.setPtrHandler2(ptrDefaultHandler2);


        /* 延时100秒,自动刷新 */
        ptrLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrLayout.autoRefresh();
            }
        }, 100);

    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(getContext(), msg);
    }


    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public Integer getListType() {
        return listType;
    }

    @Override
    public Integer getPageNumber() {
        return pageNumber;
    }

    @Override
    public void getOrderCenterAuditListDataSuccess(OrderCenterAuditListResultBean resultBean) {
        ptrLayout.refreshComplete();
        if (resultBean.getPageNumber() < pageNumber && pageNumber > 1) {
            pageNumber--;
        } else {
            if (pageNumber == 1) {
                listAdapter.setData(resultBean.getContent());
            } else {
                listAdapter.addData(resultBean.getContent());
            }
        }
        hasData(listAdapter);
    }

    @Override
    public void getOrderCenterAuditListDataFail(String msg) {
        ptrLayout.refreshComplete();
        pageNumber = pageNumber > 0 ? pageNumber : pageNumber--;
        hasData(listAdapter);
    }


    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            pageNumber++;
            orderCenterAuditListPresenter.getOrderCenterAuditListData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            pageNumber = 1;
            orderCenterAuditListPresenter.getOrderCenterAuditListData();
        }
    };


    /**
     * 刷新數據
     */
    public void refreshData() {
        ptrLayout.autoRefresh();
    }
}
