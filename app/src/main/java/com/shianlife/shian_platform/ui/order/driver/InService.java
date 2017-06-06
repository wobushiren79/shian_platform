package com.shianlife.shian_platform.ui.order.driver;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.InServiceListAdapter;
import com.shianlife.shian_platform.adapter.WaitServiceListAdapter;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IInServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.InServiceListPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IInServiceListView;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/**
 * Created by zm.
 */

public class InService extends BaseDriverLayout implements IInServiceListView {

    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    PtrClassicFrameLayout ptrLayout;

    private InServiceListAdapter mListAdapter;
    private IInServiceListPresenter inServiceListPresenter;

    public InService(Context context) {
        super(context, R.layout.layout_driver_order_inservice);
    }

    @Override
    protected void initView() {
        mListAdapter = new InServiceListAdapter(getContext());
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rcContent.setAdapter(mListAdapter);
    }

    @Override
    protected void initData() {
        inServiceListPresenter = new InServiceListPresenterImpl(this);
        inServiceListPresenter.getInServiceListData();
    }

    @Override
    protected void refesh() {

    }

    @Override
    public void getInServiceListSuccess(InServiceListResultBean result) {
        mListAdapter.setData(result.getItems());
    }

    @Override
    public void getInServiceListFail(String msg) {

    }
}
