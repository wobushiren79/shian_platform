package com.shianlife.shian_platform.ui.order.driver;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.FailServiceListAdapter;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.driver.bean.FailServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IFailServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.FailServiceListPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IFailServiceListView;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class FailService extends BaseDriverLayout implements IFailServiceListView {
    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private FailServiceListAdapter mListAdapter;
    private IFailServiceListPresenter failServiceListPresenter;

    public FailService(Context context) {
        super(context, R.layout.layout_driver_order_failservice);
        init();
    }

    private void init() {
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }

    @Override
    protected void initView() {
        mListAdapter = new FailServiceListAdapter(getContext());
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rcContent.setAdapter(mListAdapter);
    }

    @Override
    protected void initData() {
        failServiceListPresenter = new FailServiceListPresenterImpl(this);
        failServiceListPresenter.getFailServiceListData();
    }

    @Override
    protected void refesh() {

    }


    @Override
    public void getFailServiceListDataSuccess(FailServiceListResultBean result) {
        mListAdapter.setData(result.getItems());
    }

    @Override
    public void getFailServiceListDataFail(String msg) {

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
