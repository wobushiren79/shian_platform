package com.shianlife.shian_platform.ui.order.driver;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.InServiceListAdapter;
import com.shianlife.shian_platform.adapter.WaitServiceListAdapter;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.mvp.driver.bean.InServiceListResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IInServiceListPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.InServiceListPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IInServiceListView;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by zm.
 */

public class InService extends BaseDriverLayout implements IInServiceListView,InServiceListAdapter.CallBack {

    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;
    private long pageSize;
    private long pageNum;
    private InServiceListAdapter mListAdapter;
    private IInServiceListPresenter inServiceListPresenter;

    public InService(Context context) {
        super(context, R.layout.layout_driver_order_inservice);
        init();
    }

    private void init() {
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }

    @Override
    protected void initView() {
         /* 延时100秒,自动刷新 */
        ptrLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrLayout.autoRefresh();
            }
        }, 100);
        mListAdapter = new InServiceListAdapter(getContext());
        rcContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rcContent.setAdapter(mListAdapter);
    }

    @Override
    protected void initData() {
        pageSize = 10;
        pageNum = 1;

        inServiceListPresenter = new InServiceListPresenterImpl(this);
        inServiceListPresenter.getInServiceListData();
    }

    @Override
    public void refesh() {
        pageNum = 1;
        inServiceListPresenter.getInServiceListData();
    }

    @Override
    public long getPageSize() {
        return pageSize;
    }

    @Override
    public long getPageNum() {
        return pageNum;
    }

    @Override
    public void getInServiceListSuccess(InServiceListResultBean result) {
        if (result.getPageNum() < pageNum && pageNum > 1) {
            pageNum--;
        } else {
            if (pageNum == 1) {
                mListAdapter.setData(result.getList());
            } else {
                mListAdapter.addData(result.getList());
            }
        }
        ptrLayout.refreshComplete();
    }

    @Override
    public void getInServiceListFail(String msg) {

        ptrLayout.refreshComplete();
    }


    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            pageNum++;
            inServiceListPresenter.getInServiceListData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            pageNum = 1;
            inServiceListPresenter.getInServiceListData();
        }
    };
}
