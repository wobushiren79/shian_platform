package com.shianlife.shian_platform.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.adapter.DynamicListAdapter;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.dynamic.bean.DynamicResultBean;
import com.shianlife.shian_platform.mvp.dynamic.presenter.IDynamicPresenter;
import com.shianlife.shian_platform.mvp.dynamic.presenter.impl.DynamicPresenterImpl;
import com.shianlife.shian_platform.mvp.dynamic.view.IDynamicView;
import com.shianlife.shian_platform.utils.ToastUtils;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class DynamicListActivity extends BaseActivity implements IDynamicView {
    @BindView(R.id.rc_content)
    RecyclerView rcContent;
    @BindView(R.id.ptr_layout)
    CustomPtrFramelayout ptrLayout;

    private int pagerSize = 10;
    private int pagerNum = 0;
    private IDynamicPresenter dynamicPresenter;
    private DynamicListAdapter dynamicListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list);
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_dynamic), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        rcContent.setLayoutManager(new LinearLayoutManager(this));
        ptrLayout.setPtrHandler(ptrDefaultHandler2);
    }

    @Override
    protected void initData() {
        dynamicPresenter = new DynamicPresenterImpl(this);
        dynamicListAdapter = new DynamicListAdapter(this);
        rcContent.setAdapter(dynamicListAdapter);
        dynamicPresenter.getDynamicData();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public int getPagerSize() {
        return pagerSize;
    }

    @Override
    public int getPagerNum() {
        return pagerNum;
    }

    @Override
    public void showData(DynamicResultBean result) {
        ptrLayout.refreshComplete();
        DynamicResultBean data = result;
        dynamicListAdapter.setData(data.getItems());

    }


    @Override
    public void showMsg(String msg) {
        ptrLayout.refreshComplete();
        pagerNum = pagerNum > 0 ? pagerNum : pagerNum--;
//        ToastUtils.showToastShort(this, msg);
    }

    PtrDefaultHandler2 ptrDefaultHandler2 = new PtrDefaultHandler2() {
        @Override
        public void onLoadMoreBegin(PtrFrameLayout frame) {
            pagerNum++;
            dynamicPresenter.getDynamicData();
        }

        @Override
        public void onRefreshBegin(PtrFrameLayout frame) {
            pagerNum = 0;
            dynamicPresenter.getDynamicData();
        }
    };
}
