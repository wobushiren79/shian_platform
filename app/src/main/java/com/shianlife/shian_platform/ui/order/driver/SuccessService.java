package com.shianlife.shian_platform.ui.order.driver;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.InServiceListAdapter;
import com.shianlife.shian_platform.adapter.SuccessServiceListAdapter;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.driver.bean.SuccessServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.ISuccessServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.InServiceListPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.SuccessServiceListPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.ISuccessServiceListView;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class SuccessService extends BaseDriverLayout implements ISuccessServiceListView {
    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private ISuccessServiceListPresenter successServiceListPresenter;
    private SuccessServiceListAdapter mListAdapter;

    public SuccessService(Context context) {
        super(context, R.layout.layout_driver_order_successservice);
        init();
    }

    private void init() {
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }

    @Override
    protected void initView() {
        mListAdapter = new SuccessServiceListAdapter(getContext());
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rcContent.setAdapter(mListAdapter);
    }

    @Override
    protected void initData() {
        successServiceListPresenter = new SuccessServiceListPresenterImpl(this);
        successServiceListPresenter.getSuccessServiceListData();
    }

    @Override
    protected void refesh() {

    }

    @Override
    public void getSuccessServiceListSuccess(SuccessServiceListResultBean result) {
        mListAdapter.setData(result.getItems());
    }

    @Override
    public void getSuccessServiceListFail(String msg) {

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
