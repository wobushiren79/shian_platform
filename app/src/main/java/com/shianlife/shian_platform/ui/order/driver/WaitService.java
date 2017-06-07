package com.shianlife.shian_platform.ui.order.driver;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.WaitServiceListAdapter;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.driver.bean.WaitServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IWaitServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.WaitServiceListPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IWaitServiceListView;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * Created by zm.
 */

public class WaitService extends BaseDriverLayout implements IWaitServiceListView {

    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private IWaitServiceListPresenter mWaitServiceListPresenter;
    private WaitServiceListAdapter mListAdapter;

    public WaitService(Context context) {
        super(context, R.layout.layout_driver_order_waitservice);
        init();
    }

    private void init() {
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }

    @Override
    protected void initView() {
        mListAdapter = new WaitServiceListAdapter(getContext());
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rcContent.setAdapter(mListAdapter);
    }

    @Override
    protected void initData() {
        mWaitServiceListPresenter = new WaitServiceListPresenterImpl(this);
        mWaitServiceListPresenter.getWaitServiceListData();
    }

    @Override
    protected void refesh() {

    }

    @Override
    public void getWaitServiceListSuccess(WaitServiceListResultBean result) {
        mListAdapter.setData(result.getItems());
    }

    @Override
    public void getWaitServiceListFail(String msg) {

    }

    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {

        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {

        }
    };
}
