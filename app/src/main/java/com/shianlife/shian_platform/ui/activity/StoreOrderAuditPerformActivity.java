package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.StoreAuditPerformListAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.store.bean.StoreAuditPerformListResultBean;
import com.shianlife.shian_platform.mvp.store.presenter.IStoreAuditPerformListPresenter;
import com.shianlife.shian_platform.mvp.store.presenter.impl.StoreAuditPerformListPresenterImpl;
import com.shianlife.shian_platform.mvp.store.view.IStoreAuditPerformListView;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class StoreOrderAuditPerformActivity extends BaseActivity implements IStoreAuditPerformListView, StoreAuditPerformListAdapter.CallBack {
    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private Intent intent;
    private StoreAuditPerformListAdapter listApdapter;
    private IStoreAuditPerformListPresenter storeAuditPerformListPresenter;
    public static boolean isRefresh_Change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order_audit_perform);
        ButterKnife.bind(this);
        start();
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_order_audit_perform), BaseTitleEnum.BACKNORMALTITLE.getTitleType());

        listApdapter = new StoreAuditPerformListAdapter(getContext());
        listApdapter.setCallBack(this);
        rcContent.setAdapter(listApdapter);
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initData() {
        intent = getIntent();
        storeAuditPerformListPresenter = new StoreAuditPerformListPresenterImpl(this);
    }

    private void start() {
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
        /* 延时100秒,自动刷新 */
        ptrLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrLayout.autoRefresh();
            }
        }, 100);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void getAuditPerformListSuccess(StoreAuditPerformListResultBean resultBean) {
        ptrLayout.refreshComplete();
        listApdapter.setData(resultBean.getContent());
    }

    @Override
    public void getAuditPerformListFail(String msg) {
        ptrLayout.refreshComplete();
        ToastUtils.showToastShort(getContext(), msg);
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
    public void refresh() {
        ptrLayout.autoRefresh();
    }

    @Override
    public void refreshAll() {
        ptrLayout.autoRefresh();
    }

    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            storeAuditPerformListPresenter.getAuditPerformListData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            storeAuditPerformListPresenter.getAuditPerformListData();
        }
    };

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if (isRefresh_Change) {
            refresh();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isRefresh_Change = false;
    }
}
