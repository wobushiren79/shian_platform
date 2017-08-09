package com.shianlife.shian_platform.ui.order.store;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.StoreOrderAuditListAdapter;
import com.shianlife.shian_platform.base.BaseOrderListLayout;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.order.bean.StoreOrderAuditResultListBean;
import com.shianlife.shian_platform.mvp.order.presenter.IStoreOrderAuditListPresenter;
import com.shianlife.shian_platform.mvp.order.presenter.impl.StoreOrderAuditListPresenterImpl;
import com.shianlife.shian_platform.mvp.order.view.IStoreOrderAuditListView;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class StoreOrderAuditList extends BaseOrderListLayout implements IStoreOrderAuditListView, StoreOrderAuditListAdapter.CallBack {
    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private CallBack callBack;
    private List<Integer> orderStatus;
    private Integer performStatus;
    private StoreOrderAuditListAdapter listApdapter;
    private IStoreOrderAuditListPresenter storeOrderAuditListPresenter;

    private int pageSize = 10;
    private int pageNumber = 1;

    public StoreOrderAuditList(Context context, List<Integer> orderStatus, Integer performStatus) {
        super(context, R.layout.layout_store_order_audit);
        this.orderStatus = orderStatus;
        this.performStatus = performStatus;
        initView();
        initData();
        start();
    }


    public StoreOrderAuditList(Context context, Integer[] status, Integer performStatus) {
        super(context, R.layout.layout_store_order_audit);
        if (status != null)
            this.orderStatus = Arrays.asList(status);
        this.performStatus = performStatus;
        initView();
        initData();
        start();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }


    private void initView() {
        listApdapter = new StoreOrderAuditListAdapter(getContext());
        listApdapter.setCallBack(this);
        rcContent.setAdapter(listApdapter);
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }


    private void initData() {
        storeOrderAuditListPresenter = new StoreOrderAuditListPresenterImpl(this);
    }

    private void start() {
        /* 延时100秒,自动刷新 */
        ptrLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrLayout.autoRefresh();
            }
        }, 100);
    }

    @Override
    public void refresh() {
        ptrLayout.autoRefresh();
    }

    @Override
    public void refreshAll() {
        if (callBack != null)
            callBack.refreshAll(this);
    }

    @Override
    public void getStoreOrderAuditListSuccess(StoreOrderAuditResultListBean resultBean) {
        ptrLayout.refreshComplete();
        if (resultBean.getPageNumber() < pageNumber && pageNumber > 1) {
            pageNumber--;
        } else {
            if (pageNumber == 1) {
                listApdapter.setData(resultBean.getContent());
            } else {
                listApdapter.addData(resultBean.getContent());
            }
        }
    }

    @Override
    public void getStoreOrderAuditListFail(String msg) {
        ptrLayout.refreshComplete();
        pageNumber = pageNumber > 0 ? pageNumber : pageNumber--;
        ToastUtils.showToastShort(getContext(), msg);
    }

    @Override
    public Integer getPagerSize() {
        return pageSize;
    }

    @Override
    public Integer getPagerNumber() {
        return pageNumber;
    }

    @Override
    public List<Integer> getOrderStatus() {
        return orderStatus;
    }

    @Override
    public Integer getPerformStatus() {
        return performStatus;
    }

    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            pageNumber++;
            storeOrderAuditListPresenter.getStoreOrderAuditListData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            pageNumber = 1;
            storeOrderAuditListPresenter.getStoreOrderAuditListData();
        }
    };


    public interface CallBack {
        void refreshAll(View view);
    }
}
